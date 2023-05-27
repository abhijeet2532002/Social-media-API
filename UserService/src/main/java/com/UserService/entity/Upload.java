package com.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Upload {
    private String id;
    private String name;
    private String type;
    private String userId;
    private List<Reaction> reactions = new ArrayList<>();
}
