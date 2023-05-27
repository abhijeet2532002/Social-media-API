package com.UserService.implementation;

import com.UserService.entity.Reaction;
import com.UserService.entity.Relation;
import com.UserService.entity.Upload;
import com.UserService.entity.User;
import com.UserService.exception.ResourceNotFoundException;
import com.UserService.externalService.ReactionService;
import com.UserService.externalService.RelationService;
import com.UserService.externalService.UploadService;
import com.UserService.repository.UserRepository;
import com.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Autowired
    private UploadService uploadService;
    @Autowired
    private ReactionService reactionService;
    @Autowired
    private RelationService relationService;

    @Override
    public List<User> getAllUserDetails() {
        return repository.findAll();
    }

    @Override
    public User getUserDetails(String id) {
        User user = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource are not available ..."));

        //Post service calling ....
        List<Upload> upload = uploadService.getUploadDetailsByUserId(user.getId());
        List<Upload> uploadList = upload.stream().map(uploads -> {
            //Reaction Service calling ....
            List<Reaction> allReactionDetailsByPostId = reactionService.getAllReactionDetailsByPostId(uploads.getId());
            uploads.setReactions(allReactionDetailsByPostId);
            return uploads;
        }).collect(Collectors.toList());
        user.setUploads(uploadList);

        //Relation service calling for follower ....
        List<Relation> follower = relationService.getAllRelationDetailsByUserId(user.getId());
        System.out.println("\n"+follower+"\n");
        user.setFollower(follower);

        //Relation service calling for following ....
        List<Relation> following = relationService.getAllRelationDetailsByFollowId(user.getId());
        user.setFollowing(following);
        return user;
    }

    @Override
    public User saveUserDetails(User user) {
        user.setId(UUID.randomUUID().toString());
        return repository.save(user);
    }
}
