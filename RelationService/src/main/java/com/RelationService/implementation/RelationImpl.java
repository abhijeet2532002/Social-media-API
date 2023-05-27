package com.RelationService.implementation;

import com.RelationService.entity.Relation;
import com.RelationService.exception.ResourceNotFoundException;
import com.RelationService.repository.RelationRepository;
import com.RelationService.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RelationImpl implements RelationService {
    @Autowired
    private RelationRepository relationRepository;

    @Override
    public List<Relation> getAllRelationDetails() {
        return relationRepository.findAll();
    }

    @Override
    public List<Relation> getAllFollower(String id) {
        return relationRepository.findByUserId(id);
    }

    @Override
    public List<Relation> getAllFollowing(String id) {
        return relationRepository.findByFollowId(id);
    }

    @Override
    public Relation saveRelationDetails(Relation relation) {
        if(relation.getUserId().equals(relation.getFollowId())){
            relation.setUserId("");
            relation.setFollowId("");
            return relation;
        }
        else{
            Relation byUserIdAndFollowId = relationRepository.findByUserIdAndFollowId(relation.getUserId(), relation.getUserId());
            if(byUserIdAndFollowId == null){
                relation.setId(UUID.randomUUID().toString());
                return relationRepository.save(relation);
            }
            else{
                return relation;
            }
        }
    }

    @Override
    public Relation getRelationDetails(String id) {
        return relationRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Relation are not available ...."));
    }
}
