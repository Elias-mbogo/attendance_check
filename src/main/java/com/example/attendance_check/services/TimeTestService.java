package com.example.attendance_check.services;

import com.example.attendance_check.models.TimeTest;
import com.example.attendance_check.repositories.TimeTestRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Service
public class TimeTestService {
    private final TimeTestRepository timeTestRepository;

    public TimeTestService(TimeTestRepository timeTestRepository){
        this.timeTestRepository = timeTestRepository;
    }

    public TimeTest getCurrentTime(){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        return timeTestRepository.save(new TimeTest(null, formattedDate, formattedTime));
    }
}
