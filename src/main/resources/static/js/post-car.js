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

    if (!uploadArea || !fileInput) {
        return;
    }

    const MAX_PHOTOS = 10;
    const MAX_FILE_SIZE = 10 * 1024 * 1024;
    const ALLOWED_TYPES = ["image/jpeg", "image/png", "image/webp"];

    let selectedFiles = [];
    let previewUrls = [];

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
            removeButton.setAttribute(
                "aria-label",
                `Remove ${file.name}`
            );

            removeButton.addEventListener("click", () => {
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

    function syncFileInput() {
        const transfer = new DataTransfer();

        selectedFiles.forEach((file) => transfer.items.add(file));
        fileInput.files = transfer.files;
    }

    function addFiles(fileList) {
        clearError();

        const incomingFiles = Array.from(fileList);
        const validFiles = [];
        const errors = [];

        for (const file of incomingFiles) {
            if (!ALLOWED_TYPES.includes(file.type)) {
                errors.push(`${file.name}: use JPG, PNG, or WEBP.`);
                continue;
            }

            if (file.size > MAX_FILE_SIZE) {
                errors.push(`${file.name}: the file exceeds 10 MB.`);
                continue;
            }

            const alreadySelected = selectedFiles.some(
                (existing) =>
                    existing.name === file.name &&
                    existing.size === file.size &&
                    existing.lastModified === file.lastModified
            );

            const alreadyIncoming = validFiles.some(
                (existing) =>
                    existing.name === file.name &&
                    existing.size === file.size &&
                    existing.lastModified === file.lastModified
            );

            if (!alreadySelected && !alreadyIncoming) {
                validFiles.push(file);
            }
        }

        const availableSlots = MAX_PHOTOS - selectedFiles.length;

        if (validFiles.length > availableSlots) {
            errors.push(`You can upload up to ${MAX_PHOTOS} photos.`);
        }

        selectedFiles.push(...validFiles.slice(0, availableSlots));

        if (errors.length > 0) {
            showError(errors.join(" "));
        }

        syncFileInput();
        renderPreviews();
    }

    uploadArea.addEventListener("click", (event) => {
        if (event.target.closest("button")) {
            return;
        }

        fileInput.click();
    });

    uploadArea.addEventListener("keydown", (event) => {
        if (event.key === "Enter" || event.key === " ") {
            event.preventDefault();
            fileInput.click();
        }
    });

    fileInput.addEventListener("change", () => {
        addFiles(fileInput.files);
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
        selectedFiles = [];
        clearError();
        syncFileInput();
        renderPreviews();
    });

    description.addEventListener("input", () => {
        descriptionCount.textContent =
            `${description.value.length} / 2000`;
    });


    postCarForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        clearError();

        if (selectedFiles.length === 0) {
            showError("Please select at least one car photo.");
            return;
        }

        const formData = new FormData();

        selectedFiles.forEach((file) => {
            formData.append("photos", file);
        });

        const submitButton = postCarForm.querySelector(
            'button[type="submit"]'
        );

        const originalButtonText = submitButton.textContent;

        submitButton.disabled = true;
        submitButton.textContent = "Uploading photos...";

        try {
            const csrfToken = document.querySelector(
                'input[name="_csrf"]'
            )?.value;

            const csrfHeader = document.querySelector(
                'meta[name="_csrf_header"]'
            )?.content;

            const headers = {};

            if (csrfToken && csrfHeader) {
                headers[csrfHeader] = csrfToken;
            }

            const response = await fetch("/api/car-photos/upload", {
                method: "POST",
                headers,
                body: formData
            });

            if (!response.ok) {
                const errorBody = await response.json().catch(() => null);

                throw new Error(
                    errorBody?.detail ||
                    errorBody?.message ||
                    "The photos could not be uploaded. Please try again."
                );
            }

            const uploadedPhotos = await response.json();

            console.log("Uploaded car photos:", uploadedPhotos);

            alert(
                `Success! ${uploadedPhotos.length} photo(s) uploaded to Cloudinary.`
            );

        } catch (error) {
            console.error("Photo upload failed:", error);
            showError(
                error.message || "Something went wrong while uploading."
            );
        } finally {
            submitButton.disabled = false;
            submitButton.textContent = originalButtonText;
        }
    });


    window.addEventListener("beforeunload", releasePreviewUrls);
});
