package com.UserService.externalService;

import com.UserService.entity.Relation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RELATION-SERVICE")
public interface RelationService {
    @GetMapping("/relation/user/{id}")
    public List<Relation> getAllRelationDetailsByUserId(@PathVariable String id);

    @GetMapping("/relation/follow/{id}")
    public List<Relation> getAllRelationDetailsByFollowId(@PathVariable String id);
}
