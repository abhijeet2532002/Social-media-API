package com.UserService.externalService;

import com.UserService.entity.Upload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "POST-SERVICE")
public interface UploadService {

    @GetMapping("/upload/user/{id}")
    public List<Upload> getUploadDetailsByUserId(@PathVariable String id);
}
