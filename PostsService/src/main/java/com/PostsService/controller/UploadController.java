package com.PostsService.controller;

import com.PostsService.entity.Upload;
import com.PostsService.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService service;

    @GetMapping
    public List<Upload> getAllUploadDetails() {
        return service.getAllUploadDetails();
    }

    @GetMapping("/{id}")
    public Upload getUploadDetails(@PathVariable String id) {
        return service.getUploadDetails(id);
    }

    @GetMapping("/user/{id}")
    public List<Upload> getUploadDetailsByUserId(@PathVariable String id) {
        return service.getAllUploadsDetailsByUserId(id);
    }

    @PostMapping
    public Upload saveUploadDetails(@RequestBody Upload upload) {
        return service.saveUploadDetails(upload);
    }
}
