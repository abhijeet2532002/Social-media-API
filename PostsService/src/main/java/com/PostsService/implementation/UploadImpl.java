package com.PostsService.implementation;

import com.PostsService.entity.Upload;
import com.PostsService.exception.ResourceNotFoundException;
import com.PostsService.repository.UploadRepository;
import com.PostsService.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UploadImpl implements UploadService {
    @Autowired
    private UploadRepository repository;

    @Override
    public List<Upload> getAllUploadDetails() {
        return repository.findAll();
    }

    @Override
    public Upload getUploadDetails(String id) {
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Upload details not available ..."));
    }

    @Override
    public List<Upload> getAllUploadsDetailsByUserId(String id) {
        List<Upload> byUserId = repository.findByUserId(id);
        return byUserId;
    }

    @Override
    public Upload saveUploadDetails(Upload upload) {
        upload.setId(UUID.randomUUID().toString());
        return repository.save(upload);
    }
}
