package com.sparta.practice_spring.service;

import com.sparta.practice_spring.dto.CommentRequestDto;
import com.sparta.practice_spring.dto.CommentResponsetDto;
import com.sparta.practice_spring.entity.Comment;
import com.sparta.practice_spring.entity.Schedule;
import com.sparta.practice_spring.repository.CommentRepository;
import com.sparta.practice_spring.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

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

    @Transactional
    public CommentResponsetDto updateComment(Long scheduleId,
                                             Long commentId,
                                             CommentRequestDto requestDto) {

        scheduleRepository.findById(scheduleId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 일정 데이터가 없습니다."));

        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 댓글이 없습니다."));

        if (!Objects.equals(comment.getComment(), requestDto.getComment())) {
            throw new IllegalArgumentException("사용자가 일치하지 않습니다.");
        }

        comment.update(requestDto);
        return new CommentResponsetDto(comment);
    }
}
