package com.LikeService.implementation;

import com.LikeService.entity.Reaction;
import com.LikeService.exception.ResourceNotFoundException;
import com.LikeService.repository.ReactionRepository;
import com.LikeService.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReactionImpl implements ReactionService {
    @Autowired
    private ReactionRepository repository;

    @Override
    public List<Reaction> getAllReactionDetails() {
        return repository.findAll();
    }

    @Override
    public Reaction getReactionDetails(String id) {
        Reaction reaction = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Like resource are not available ..."));
        return reaction;
    }

    @Override
    public List<Reaction> getAllReactionByUserId(String id) {
        return repository.findByUserId(id);
    }

    @Override
    public List<Reaction> getAllReactionByPostId(String id) {
        return repository.findByPostId(id);
    }

    @Override
    public Reaction saveReactionDetails(Reaction reaction) {
        Reaction reaction1 = repository.findByUserIdAndPostId(reaction.getUserId(), reaction.getPostId());
        if(reaction1==null){
            reaction.setId(UUID.randomUUID().toString());
            return repository.save(reaction);
        }
        else{
            reaction1.setName(reaction.getName());
            return repository.save(reaction1);
        }
    }
}
