package com.sparta.practice_spring.dto;

import com.sparta.practice_spring.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private Long id;
    private String title;
    private String contents;
    private String manager;
    private String password;

}
