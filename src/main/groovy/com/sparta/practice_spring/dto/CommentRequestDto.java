package com.sparta.practice_spring.dto;

import com.sparta.practice_spring.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {

    private String comment;
    private String username;
}
