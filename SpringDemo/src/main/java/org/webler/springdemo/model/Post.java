package org.webler.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post {

    private String content;
    private int viewed;
    private boolean enabled;

}
