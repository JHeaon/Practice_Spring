package com.sparta.practice_spring.entity;

import com.sparta.practice_spring.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String username;

    @ManyToOne
    @JoinColumn(name= "schedule_id")
    private Schedule schedule;

    public Comment(CommentRequestDto requestDto, Schedule schedule){
        this.comment = requestDto.getComment();
        this.username = requestDto.getUsername();
        this.schedule = schedule;
    }

    public void update(CommentRequestDto requestDto) {
        this.comment = requestDto.getComment();
    }
}
