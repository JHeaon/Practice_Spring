package com.sparta.practice_spring.dto;

import com.sparta.practice_spring.entity.Comment;
import com.sparta.practice_spring.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponsetDto {

    private Long id;
    private String comment;
    private String username;

    public CommentResponsetDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.username = comment.getUsername();
    }
}
