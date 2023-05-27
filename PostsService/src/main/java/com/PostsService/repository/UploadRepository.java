package com.PostsService.repository;

import com.PostsService.entity.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UploadRepository extends JpaRepository<Upload,String> {
    List<Upload> findByUserId(String id);
}
