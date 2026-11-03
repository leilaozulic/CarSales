document.addEventListener("DOMContentLoaded", () => {
    const uploadArea = document.getElementById("uploadArea");
    const fileInput = document.getElementById("carPhotos");
    const previewSection = document.getElementById("photoPreviewSection");
    const previewGrid = document.getElementById("photoPreviewGrid");
    const photoCount = document.getElementById("photoCount");
    const photoError = document.getElementById("photoError");
    const clearPhotosButton = document.getElementById("clearPhotos");
    const description = document.getElementById("description");
    const descriptionCount = document.getElementById("descriptionCount");
    const postCarForm = document.getElementById("postCarForm");
    const submitButton = document.getElementById("analyzeButton");

    const vehicleFormSection = document.getElementById("vehicleFormSection");
    const vehicleDetailsForm = document.getElementById("vehicleDetailsForm");
    const vehicleFormError = document.getElementById("vehicleFormError");

    // Database-backed dropdowns.
    const makeSelect = document.getElementById("make");
    const modelSelect = document.getElementById("model");
    const colorSelect = document.getElementById("exteriorColor");

    if (!uploadArea || !fileInput || !postCarForm || !submitButton) {
        console.error("Required car upload elements are missing.");
        return;
    }

    const MAX_PHOTOS = 10;
    const MAX_FILE_SIZE = 10 * 1024 * 1024;
    const ALLOWED_TYPES = ["image/jpeg", "image/png", "image/webp"];

    let selectedFiles = [];
    let previewUrls = [];
    let isSubmitting = false;

    function showError(message) {
        photoError.textContent = message;
        photoError.hidden = false;
    }

    function clearError() {
        photoError.textContent = "";
        photoError.hidden = true;
    }

    function releasePreviewUrls() {
        previewUrls.forEach((url) => URL.revokeObjectURL(url));
        previewUrls = [];
    }

    function syncFileInput() {
        const transfer = new DataTransfer();
        selectedFiles.forEach((file) => transfer.items.add(file));
        fileInput.files = transfer.files;
    }

    function renderPreviews() {
        releasePreviewUrls();
        previewGrid.replaceChildren();

        selectedFiles.forEach((file, index) => {
            const previewUrl = URL.createObjectURL(file);
            previewUrls.push(previewUrl);

            const item = document.createElement("div");
            item.className = "post-car-preview-item";

            const image = document.createElement("img");
            image.src = previewUrl;
            image.alt = `Selected car photo ${index + 1}`;

            const removeButton = document.createElement("button");
            removeButton.type = "button";
            removeButton.className = "post-car-preview-remove";
            removeButton.textContent = "×";
            removeButton.setAttribute("aria-label", `Remove ${file.name}`);

            removeButton.addEventListener("click", () => {
                if (isSubmitting) return;

                selectedFiles.splice(index, 1);
                clearError();
                syncFileInput();
                renderPreviews();
            });

            const name = document.createElement("div");
            name.className = "post-car-preview-name";
            name.textContent = file.name;

            item.append(image, removeButton, name);
            previewGrid.appendChild(item);
        });

        const count = selectedFiles.length;
        photoCount.textContent =
            `${count} photo${count === 1 ? "" : "s"} selected`;
        previewSection.hidden = count === 0;
    }

    function addFiles(fileList) {
        if (isSubmitting) return;

        clearError();

        const incomingFiles = Array.from(fileList);
        const validFiles = [];
        const errors = [];

        for (const file of incomingFiles) {
            if (!ALLOWED_TYPES.includes(file.type)) {
                errors.push(`${file.name}: use JPG, PNG or WEBP.`);
                continue;
            }

            if (file.size > MAX_FILE_SIZE) {
                errors.push(`${file.name}: the file exceeds 10 MB.`);
                continue;
            }

            const isDuplicate = [...selectedFiles, ...validFiles].some(
                (existing) =>
                    existing.name === file.name &&
                    existing.size === file.size &&
                    existing.lastModified === file.lastModified
            );

            if (!isDuplicate) {
                validFiles.push(file);
            }
        }

        const availableSlots = MAX_PHOTOS - selectedFiles.length;

        if (validFiles.length > availableSlots) {
            errors.push(`You can upload up to ${MAX_PHOTOS} photos.`);
        }

        selectedFiles.push(
            ...validFiles.slice(0, Math.max(0, availableSlots))
        );

        if (errors.length) showError(errors.join(" "));

        syncFileInput();
        renderPreviews();
    }

    uploadArea.addEventListener("click", (event) => {
        if (event.target.closest("button")) return;
        fileInput.click();
    });

    uploadArea.addEventListener("keydown", (event) => {
        if (
            event.target === uploadArea &&
            (event.key === "Enter" || event.key === " ")
        ) {
            event.preventDefault();
            fileInput.click();
        }
    });

    fileInput.addEventListener("change", () => {
        addFiles(fileInput.files);
        // Allow selecting the same file again after removing it.
        fileInput.value = "";
        syncFileInput();
    });

    ["dragenter", "dragover"].forEach((eventName) => {
        uploadArea.addEventListener(eventName, (event) => {
            event.preventDefault();
            uploadArea.classList.add("drag-over");
        });
    });

    ["dragleave", "drop"].forEach((eventName) => {
        uploadArea.addEventListener(eventName, (event) => {
            event.preventDefault();
            uploadArea.classList.remove("drag-over");
        });
    });

    uploadArea.addEventListener("drop", (event) => {
        if (event.dataTransfer?.files) {
            addFiles(event.dataTransfer.files);
        }
    });

    clearPhotosButton.addEventListener("click", () => {
        if (isSubmitting) return;

        selectedFiles = [];
        clearError();
        syncFileInput();
        renderPreviews();
    });

    description.addEventListener("input", () => {
        descriptionCount.textContent =
            `${description.value.length} / 2000`;
    });

    async function readErrorMessage(response) {
        const body = await response.json().catch(() => null);

        return body?.detail ||
            body?.message ||
            body?.error ||
            `Request failed (HTTP ${response.status}).`;
    }

    function getCsrfHeaders() {
        const token = document.querySelector('input[name="_csrf"]')?.value;
        const headerName =
            document.querySelector('meta[name="_csrf_header"]')?.content;

        const headers = {};

        if (token) {
            headers[headerName || "X-CSRF-TOKEN"] = token;
        }

        return headers;
    }

    function setFieldValue(id, value) {
        const field = document.getElementById(id);

        if (!field || value === null || value === undefined || value === "") {
            return;
        }

        field.value = String(value);
    }

    function setSelectValue(id, value) {
        const field = document.getElementById(id);

        if (!field || value === null || value === undefined || value === "") {
            return;
        }

        const wanted = String(value).trim().toLowerCase();

        const matchingOption = Array.from(field.options).find(
            (option) =>
                option.value.trim().toLowerCase() === wanted
        );

        if (matchingOption) {
            field.value = matchingOption.value;
        }
    }

    // Find an option by its displayed text or its value.
    function selectOptionByText(selectElement, value) {
        if (!selectElement || value === null || value === undefined || value === "") {
            return false;
        }

        const wanted = String(value).trim().toLowerCase();

        const matchingOption = Array.from(selectElement.options).find(
            (option) =>
                option.textContent.trim().toLowerCase() === wanted ||
                option.value.trim().toLowerCase() === wanted
        );

        if (!matchingOption) {
            return false;
        }

        selectElement.value = matchingOption.value;
        return true;
    }

    // Load models belonging to the selected make.
    async function loadModels(makeId, selectedModelName = "") {
        modelSelect.replaceChildren();

        modelSelect.add(new Option("Loading models...", ""));
        modelSelect.disabled = true;

        if (!makeId) {
            modelSelect.replaceChildren();
            modelSelect.add(new Option("Select make first", ""));
            return;
        }

        try {
            const response = await fetch(
                `/cars/models/${encodeURIComponent(makeId)}`
            );

            if (!response.ok) {
                throw new Error(await readErrorMessage(response));
            }

            const models = await response.json();

            modelSelect.replaceChildren();
            modelSelect.add(new Option("Select model", ""));

            models.forEach((model) => {
                modelSelect.add(
                    new Option(model.name, model.id)
                );
            });

            modelSelect.disabled = models.length === 0;

            if (models.length === 0) {
                modelSelect.replaceChildren();
                modelSelect.add(new Option("No models available", ""));
                return;
            }

            // If AI supplied a model name, select the matching option.
            if (selectedModelName) {
                selectOptionByText(modelSelect, selectedModelName);
            }

        } catch (error) {
            console.error("Could not load car models:", error);

            modelSelect.replaceChildren();
            modelSelect.add(new Option("Could not load models", ""));
            modelSelect.disabled = true;

            throw error;
        }
    }

    // When a user manually changes the make, load its models.
    makeSelect.addEventListener("change", async () => {
        await loadModels(makeSelect.value);
    });

    // Populate the form with AI results.
    async function populateVehicleForm(result) {

        // Match AI make name to an existing database option.
        const makeFound = selectOptionByText(makeSelect, result.make);

        // Load models for that make before selecting the AI model.
        if (makeFound) {
            await loadModels(makeSelect.value, result.model);
        } else {
            modelSelect.replaceChildren();
            modelSelect.add(new Option("Select make first", ""));
            modelSelect.disabled = true;
        }

        setFieldValue("year", result.year);

        // These fields still use their existing option values.
        setSelectValue("bodyType", result.bodyType);
        setSelectValue("fuelType", result.fuelType);
        setSelectValue("transmission", result.transmission);

        // Match AI colour to an existing database option.
        selectOptionByText(colorSelect, result.exteriorColor);

        setFieldValue("engineSize", result.engineSize);
        setFieldValue("enginePowerHp", result.enginePowerHp);
        setFieldValue("aiNotes", result.notes);

        vehicleFormSection.hidden = false;
        vehicleFormSection.scrollIntoView({
            behavior: "smooth",
            block: "start"
        });
    }

    postCarForm.addEventListener("submit", async (event) => {
        event.preventDefault();

        if (isSubmitting) return;

        clearError();

        if (selectedFiles.length === 0) {
            showError("Please select at least one car photo.");
            return;
        }

        isSubmitting = true;
        submitButton.disabled = true;

        const originalButtonText = submitButton.innerHTML;
        let photosUploaded = false;

        try {
            // STEP 1: Upload photos to Cloudinary.
            submitButton.textContent = "Uploading photos...";

            const formData = new FormData();
            selectedFiles.forEach((file) => {
                formData.append("photos", file);
            });

            const uploadResponse = await fetch("/api/car-photos/upload", {
                method: "POST",
                headers: getCsrfHeaders(),
                body: formData
            });

            if (!uploadResponse.ok) {
                throw new Error(await readErrorMessage(uploadResponse));
            }

            const uploadedPhotos = await uploadResponse.json();

            if (!Array.isArray(uploadedPhotos) || uploadedPhotos.length === 0) {
                throw new Error("No uploaded photo URLs were returned.");
            }

            const imageUrls = uploadedPhotos.map((photo) => photo.secureUrl);

            if (imageUrls.some((url) => typeof url !== "string" || !url.trim())) {
                throw new Error("An uploaded photo is missing its secure URL.");
            }

            photosUploaded = true;

            // STEP 2: Ask AI for structured vehicle details.
            submitButton.textContent = "Analyzing your car...";

            const analysisResponse = await fetch("/api/ai/analyse-car", {
                method: "POST",
                headers: {
                    ...getCsrfHeaders(),
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({
                    imageUrls,
                    description: description.value.trim()
                })
            });

            if (!analysisResponse.ok) {
                throw new Error(await readErrorMessage(analysisResponse));
            }

            const result = await analysisResponse.json();

            if (!result || typeof result !== "object") {
                throw new Error("The AI returned an invalid response.");
            }

            // STEP 3: Populate the editable form.
            await populateVehicleForm(result);

        } catch (error) {
            console.error("Car analysis failed:", error);

            showError(
                photosUploaded
                    ? `Photos uploaded, but analysis failed: ${error.message}`
                    : error.message || "The photo upload failed."
            );
        } finally {
            isSubmitting = false;
            submitButton.disabled = false;
            submitButton.innerHTML = originalButtonText;
        }
    });

    // This form is for review only; saving will be implemented separately.
    vehicleDetailsForm.addEventListener("submit", (event) => {
        event.preventDefault();

        vehicleFormError.hidden = true;
        vehicleFormError.textContent = "";

        if (!vehicleDetailsForm.reportValidity()) {
            return;
        }

        vehicleFormError.textContent =
            "Your details are ready for the next step. Saving the listing has not been connected yet.";
        vehicleFormError.hidden = false;
        vehicleFormError.scrollIntoView({
            behavior: "smooth",
            block: "center"
        });
    });

    window.addEventListener("beforeunload", releasePreviewUrls);
});
