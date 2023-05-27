package com.RelationService.repository;

import com.RelationService.entity.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends JpaRepository<Relation,String> {
    List<Relation> findByUserId(String id);
    List<Relation> findByFollowId(String id);
    Relation findByUserIdAndFollowId(String uId,String fId);
}
