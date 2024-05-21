package com.example.attendance_check.services;

import com.example.attendance_check.models.*;
import com.example.attendance_check.models.dtos.CheckKey;
import com.example.attendance_check.models.dtos.CheckLaptop;
import com.example.attendance_check.models.dtos.CheckVisitor;
import com.example.attendance_check.models.dtos.PeopleNationalid;
import com.example.attendance_check.repositories.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
    private final LaptopRepository laptopRepository;
    private final KeyRepository keyRepository;

    public CheckService(PeopleRepository peopleRepository, AttendanceRepository attendanceRepository,
                        CompanyRepository companyRepository, TimeLedgerRepository timeLedgerRepository,
                        LaptopRepository laptopRepository, KeyRepository keyRepository){
        this.peopleRepository = peopleRepository;
        this.attendanceRepository = attendanceRepository;
        this.companyRepository = companyRepository;
        this.timeLedgerRepository = timeLedgerRepository;
        this.laptopRepository = laptopRepository;
        this.keyRepository = keyRepository;
    }

    //CHECK INS
    //Check in visitor
    public CheckVisitor getVisitorCheckIn(PeopleNationalid peopleNationalid){
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

        timeLedgerRepository.save(new TimeLedger(null, formattedDate, null, true, formattedTime,
                null, AggregateReference.to(attendance.getId()), null, null));

        return new CheckVisitor(people.getUsername(), companyResult.getNames(), formattedDate, formattedTime);

    }
    //Check in Laptop
    public CheckLaptop getLaptopCheckIn(PeopleNationalid peopleNationalid){
        People people  = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Laptop laptop = laptopRepository.findByPeopleId(peopleId);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        timeLedgerRepository.save(new TimeLedger(null, formattedDate, null, true, formattedTime,
                null, null, AggregateReference.to(laptop.getId()), null));

        return new CheckLaptop(people.getUsername(), laptop.getModelType(), formattedDate, formattedTime);
    }
    //Check in Key
    public CheckKey getKeyCheckIn(PeopleNationalid peopleNationalid){
        People people  = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Key key = keyRepository.findByPeopleId(peopleId);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        timeLedgerRepository.save(new TimeLedger(null, formattedDate, null, true, formattedTime,
                null, null, null, AggregateReference.to(key.getId())));

        return new CheckKey(people.getUsername(), key.getNumber(), formattedDate, formattedTime);
    }

    //CHECK OUT'S
    //Check Out Visitor
    public CheckVisitor getVisitorCheckOut(PeopleNationalid peopleNationalid){
        People people = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Attendance attendance = attendanceRepository.findByPeopleId(peopleId);
        AggregateReference<Company, Integer> companyId = attendance.getCompany_id();
        Optional<Company> company = companyRepository.findById(companyId.getId());
        Company companyResult = company.get();

        TimeLedger checkOutTime = timeLedgerRepository.findFirstByOrderByAttendanceIdAsc(AggregateReference.to(attendance.getId()));

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        timeLedgerRepository.save(new TimeLedger(checkOutTime.getId(), checkOutTime.getDateCheckedIn(),
                formattedDate, false, checkOutTime.getTimeCheckedIn(), formattedTime, checkOutTime.getAttendanceId(), null, null));

        return new CheckVisitor(people.getUsername(), companyResult.getNames(), formattedDate, formattedTime);
    }

    //Check Out Laptop
    public CheckLaptop getLaptopCheckOut(PeopleNationalid peopleNationalid){
        People people = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Laptop laptop = laptopRepository.findByPeopleId(peopleId);

        TimeLedger checkOutTime = timeLedgerRepository.findFirstByOrderByAttendanceIdAsc(AggregateReference.to(laptop.getId()));

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        timeLedgerRepository.save(new TimeLedger(checkOutTime.getId(), checkOutTime.getDateCheckedIn(),
                formattedDate, false, checkOutTime.getTimeCheckedIn(), formattedTime, null, checkOutTime.getLaptopId(), null));

        return new CheckLaptop(people.getUsername(), laptop.getModelType(), formattedDate, formattedTime);
    }

    //Check Out Key
    public CheckKey getKeyCheckOut(PeopleNationalid peopleNationalid){
        People people = peopleRepository.findByNationalid(peopleNationalid.getNationalid());
        AggregateReference<People, Integer> peopleId = AggregateReference.to(people.getId());
        Key key = keyRepository.findByPeopleId(peopleId);

        TimeLedger checkOutTime = timeLedgerRepository.findFirstByOrderByAttendanceIdAsc(AggregateReference.to(key.getId()));

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        String formattedDate = dateFormatter.format(date);
        String formattedTime = timeFormatter.format(time);

        timeLedgerRepository.save(new TimeLedger(checkOutTime.getId(), checkOutTime.getDateCheckedIn(),
                formattedDate, false, checkOutTime.getTimeCheckedIn(), formattedTime, null, null, checkOutTime.getKeyId()));

        return new CheckKey(people.getUsername(), key.getNumber(), formattedDate, formattedTime);
    }


}
