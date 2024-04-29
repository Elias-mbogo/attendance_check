package com.example.attendance_check.services;

import com.example.attendance_check.models.Attendance;
import com.example.attendance_check.models.Company;
import com.example.attendance_check.models.People;
import com.example.attendance_check.models.TimeLedger;
import com.example.attendance_check.models.dtos.Check;
import com.example.attendance_check.models.dtos.PeopleNationalid;
import com.example.attendance_check.repositories.AttendanceRepository;
import com.example.attendance_check.repositories.CompanyRepository;
import com.example.attendance_check.repositories.PeopleRepository;
import com.example.attendance_check.repositories.TimeLedgerRepository;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class CheckService {
    private final PeopleRepository peopleRepository;
    private final AttendanceRepository attendanceRepository;
    private final CompanyRepository companyRepository;
    private final TimeLedgerRepository timeLedgerRepository;

    public CheckService(PeopleRepository peopleRepository, AttendanceRepository attendanceRepository,
                        CompanyRepository companyRepository, TimeLedgerRepository timeLedgerRepository){
        this.peopleRepository = peopleRepository;
        this.attendanceRepository = attendanceRepository;
        this.companyRepository = companyRepository;
        this.timeLedgerRepository = timeLedgerRepository;
    }

    public TimeLedger getCheckIn(PeopleNationalid peopleNationalid){
        People people = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Attendance attendance = attendanceRepository.findByPeopleId(peopleId);
        AggregateReference<Company, Integer> companyId = attendance.getCompany_id();
        Optional<Company> company = companyRepository.findById(companyId.getId());
        Company companyResult = company.get();

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        return timeLedgerRepository.save(new TimeLedger(null, formattedDate, null, true, formattedTime, null, AggregateReference.to(attendance.getId())));

        //new Check(people.getUsername(), companyResult.getNames(), formattedDate, formattedTime);

    }


}
