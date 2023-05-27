package com.UserService.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Relation {
    private String id;
    private String userId;
    private String followId;
}
