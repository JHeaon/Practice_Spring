package com.sparta.practice_spring.dto;

import com.sparta.practice_spring.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleReponseDto {
    private String title;
    private String contents;
    private String manager;
    private String password;

    public ScheduleReponseDto(Schedule schedule) {
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.manager = schedule.getManager();
        this.password = schedule.getPassword();
    }
}
