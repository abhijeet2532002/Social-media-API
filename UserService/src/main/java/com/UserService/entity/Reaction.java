package com.UserService.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reaction {
    private String id;
    private String userId;
    private String postId;
    private String name;
}
