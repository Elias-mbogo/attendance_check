package com.example.attendance_check.repositories;

import com.example.attendance_check.models.Attendance;
import com.example.attendance_check.models.TimeLedger;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.repository.CrudRepository;

public interface TimeLedgerRepository extends CrudRepository<TimeLedger, Integer> {
    TimeLedger findFirstByOrderByAttendanceIdAsc(AggregateReference<Attendance, Integer> attendanceId);
}
