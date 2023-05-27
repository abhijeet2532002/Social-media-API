package com.RelationService.controller;

import com.RelationService.entity.Relation;
import com.RelationService.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;

    @GetMapping
    public List<Relation> getAllRelationDetails() {
        return relationService.getAllRelationDetails();
    }

    @GetMapping("/{id}")
    public Relation getRelationDetails(@PathVariable String id) {
        return relationService.getRelationDetails(id);
    }

    @GetMapping("/user/{id}")
    public List<Relation> getAllRelationDetailsByUserId(@PathVariable String id) {
        return relationService.getAllFollower(id);
    }

    @GetMapping("/follow/{id}")
    public List<Relation> getAllRelationDetailsByFollowId(@PathVariable String id) {
        return relationService.getAllFollowing(id);
    }

    @PostMapping
    public Relation saveRelation(@RequestBody Relation relation) {
        return relationService.saveRelationDetails(relation);
    }
}
