package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepository extends CrudRepository<Attendance, Integer> {
}
