package com.example.CarSales.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.CarSales.DTOs.UploadedCarPhoto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryUploadService {

    private final Cloudinary cloudinary;

    public CloudinaryUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public UploadedCarPhoto uploadImage(MultipartFile file)
            throws IOException {

        Map<?, ?> result = cloudinary.uploader().upload(
                file.getBytes(),
                ObjectUtils.asMap(
                        "asset_folder", "carsales/pending",
                        "resource_type", "image"
                )
        );

        return new UploadedCarPhoto(
                (String) result.get("asset_id"),
                (String) result.get("public_id"),
                (String) result.get("secure_url")
        );
    }
}
