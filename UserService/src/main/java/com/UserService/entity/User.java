package com.UserService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private String id;
    private String name;
    private String Login;
    @Transient
    private List<Upload> uploads = new ArrayList<>();
    @Transient
    private List<Relation> following = new ArrayList<>();
    @Transient
    private List<Relation> follower = new ArrayList<>();
}
