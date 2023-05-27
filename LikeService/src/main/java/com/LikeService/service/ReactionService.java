package com.LikeService.service;

import com.LikeService.entity.Reaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReactionService {
    List<Reaction> getAllReactionDetails();
    Reaction getReactionDetails(String id);
    List<Reaction> getAllReactionByUserId(String id);
    List<Reaction> getAllReactionByPostId(String id);
    Reaction saveReactionDetails(Reaction reaction);
}
