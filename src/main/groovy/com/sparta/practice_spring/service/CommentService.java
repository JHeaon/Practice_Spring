package com.sparta.practice_spring.service;

import com.sparta.practice_spring.dto.CommentRequestDto;
import com.sparta.practice_spring.dto.CommentResponsetDto;
import com.sparta.practice_spring.entity.Comment;
import com.sparta.practice_spring.entity.Schedule;
import com.sparta.practice_spring.repository.CommentRepository;
import com.sparta.practice_spring.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private ScheduleRepository scheduleRepository;

    public CommentService(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    public CommentResponsetDto createComment(Long query, CommentRequestDto responsetDto) {
        Schedule schedule = scheduleRepository.findById(query)
                .orElseThrow(() -> new IllegalArgumentException("해당 Id에 맞는 일정이 없습니다. "));
        Comment comment = commentRepository.save(new Comment(responsetDto, schedule));

        return new CommentResponsetDto(comment);
    }
}
