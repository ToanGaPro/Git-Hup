package com.example.service;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	File save(MultipartFile file,String folder);
	// đưa vào file và thư mục để lưu file
}
