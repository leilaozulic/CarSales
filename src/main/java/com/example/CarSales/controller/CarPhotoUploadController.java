package com.example.CarSales.controller;

import com.example.CarSales.DTOs.UploadedCarPhoto;
import com.example.CarSales.service.CloudinaryUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/car-photos")
public class CarPhotoUploadController {

    private static final int MAX_PHOTOS = 10;
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024;

    private static final Set<String> ALLOWED_TYPES = Set.of( //unmodifiable set of allowed types in Strings
            "image/jpeg",
            "image/png",
            "image/webp"
    );

    private final CloudinaryUploadService uploadService;

    public CarPhotoUploadController(
            CloudinaryUploadService uploadService) {
        this.uploadService = uploadService;
    }

    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE //specifies the accepted request content type
    )
    public List<UploadedCarPhoto> uploadPhotos(
            @RequestParam("photos") List<MultipartFile> photos)
            throws IOException {

        if (photos == null || photos.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Please upload at least one photo."
            );
        }

        if (photos.size() > MAX_PHOTOS) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "You can upload a maximum of 10 photos."
            );
        }

        List<UploadedCarPhoto> uploadedPhotos = new ArrayList<>();

        for (MultipartFile photo : photos) {
            if (photo.isEmpty()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "One of the uploaded files is empty."
                );
            }

            if (photo.getSize() > MAX_FILE_SIZE) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Each photo must be 10 MB or smaller."
                );
            }

            if (!ALLOWED_TYPES.contains(photo.getContentType())) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "Only JPEG, PNG, and WEBP images are allowed."
                );
            }

            uploadedPhotos.add(uploadService.uploadImage(photo));
        }

        return uploadedPhotos;
    }
}
