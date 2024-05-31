package com.sparta.practice_spring.repository;

import com.sparta.practice_spring.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
