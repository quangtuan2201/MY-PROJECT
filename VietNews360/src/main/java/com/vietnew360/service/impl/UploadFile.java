package com.vietnew360.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vietnew360.repository.NewRepository;
import com.vietnew360.service.IUploadFile;

@Service
public class UploadFile implements IUploadFile {
	//@Autowired
	//private NewRepository newRepository;
//	@Autowired
	//private ServletContext servletContext;
	@Autowired(required = true)
	private String fileUploadDir;

	@Override
	public void saveImage(MultipartFile file) {
		if (file.isEmpty()) {
            try {
                // Lưu file vào thư mục đã cấu hình
                String filename = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                Path path = Paths.get(fileUploadDir + filename);
                Files.write(path, bytes);
                System.out.println("Success to upload file.");
            } catch (IOException e) {
                e.printStackTrace();
               System.out.println("Failed to upload file.");
            }
        }
    }
}

	