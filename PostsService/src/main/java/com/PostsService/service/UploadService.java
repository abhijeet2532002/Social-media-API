package com.PostsService.service;

import com.PostsService.entity.Upload;

import java.util.List;

public interface UploadService {
    List<Upload> getAllUploadDetails();
    Upload getUploadDetails(String id);
    List<Upload> getAllUploadsDetailsByUserId(String id);
    Upload saveUploadDetails(Upload upload);
}
