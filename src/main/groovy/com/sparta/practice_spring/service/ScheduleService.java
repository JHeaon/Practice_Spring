package com.sparta.practice_spring.service;

import com.sparta.practice_spring.dto.ScheduleReponseDto;
import com.sparta.practice_spring.dto.ScheduleRequestDto;
import com.sparta.practice_spring.entity.Schedule;
import com.sparta.practice_spring.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
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


    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = findSchedule(id);
        schedule.update(requestDto);
        return id;
    }


    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("선택한 일정이 존재하지 않습니다.");
        });
    }
}
