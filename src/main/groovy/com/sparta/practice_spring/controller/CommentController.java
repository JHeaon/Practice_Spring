package com.sparta.practice_spring.controller;

import com.sparta.practice_spring.dto.CommentRequestDto;
import com.sparta.practice_spring.dto.CommentResponsetDto;
import com.sparta.practice_spring.service.CommentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/schedule/{scheduleId}/comment")
    public CommentResponsetDto createComment(@PathVariable("scheduleId") Long query, @RequestBody CommentRequestDto requestDto){
        return commentService.createComment(query, requestDto);
    }

    @PatchMapping("/schedule/{scheduleId}/comment/{commentId}")
    public CommentResponsetDto updateComment(@PathVariable("scheduleId") Long scheduleId,
                                             @PathVariable("commentId") Long commentId,
                                             @RequestBody CommentRequestDto requestDto){
        return commentService.updateComment(scheduleId, commentId, requestDto);
    }
}
