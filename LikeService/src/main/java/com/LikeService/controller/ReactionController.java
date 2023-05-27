package com.LikeService.controller;

import com.LikeService.entity.Reaction;
import com.LikeService.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reaction")
public class ReactionController {
    @Autowired
    private ReactionService service;

    @GetMapping
    public List<Reaction> getAllReactionDetails() {
        return service.getAllReactionDetails();
    }

    @GetMapping("/{id}")
    public Reaction getReactionDetails(@PathVariable String id) {
        return service.getReactionDetails(id);
    }

    @GetMapping("/user/{id}")
    public List<Reaction> getAllReactionDetailsByUserId(@PathVariable String id) {
        return service.getAllReactionByUserId(id);
    }

    @GetMapping("/post/{id}")
    public List<Reaction> getAllReactionDetailsByPostId(@PathVariable String id) {
        return service.getAllReactionByPostId(id);
    }

    @PostMapping
    public Reaction saveReactionDetails(@RequestBody Reaction reaction) {
        return service.saveReactionDetails(reaction);
    }
}
