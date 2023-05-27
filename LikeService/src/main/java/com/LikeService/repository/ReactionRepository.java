package com.LikeService.repository;

import com.LikeService.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction,String> {
    List<Reaction> findByUserId(String id);
    List<Reaction> findByPostId(String id);
    Reaction findByUserIdAndPostId(String uId,String pId);
}
