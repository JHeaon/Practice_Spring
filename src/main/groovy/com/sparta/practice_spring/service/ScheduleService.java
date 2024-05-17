package com.sparta.practice_spring.service;

import com.sparta.practice_spring.dto.ScheduleReponseDto;
import com.sparta.practice_spring.dto.ScheduleRequestDto;
import com.sparta.practice_spring.entity.Schedule;
import com.sparta.practice_spring.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleReponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto);
        Schedule saveSchedule = scheduleRepository.save(schedule);
        return new ScheduleReponseDto(schedule);
    }

    public List<ScheduleReponseDto> getSchedules() {
        return scheduleRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(ScheduleReponseDto::new)
                .toList();
    }




}
