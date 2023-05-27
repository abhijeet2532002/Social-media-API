package com.RelationService.service;

import com.RelationService.entity.Relation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RelationService {
    List<Relation> getAllRelationDetails();
    List<Relation> getAllFollower(String id);
    List<Relation> getAllFollowing(String id);
    Relation saveRelationDetails(Relation relation);
    Relation getRelationDetails(String id);
}
