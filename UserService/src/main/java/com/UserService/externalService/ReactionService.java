package com.UserService.externalService;

import com.UserService.entity.Reaction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "LIKE-SERVICE")
public interface ReactionService {

    @GetMapping("/reaction/post/{id}")
    public List<Reaction> getAllReactionDetailsByPostId(@PathVariable String id);
}
