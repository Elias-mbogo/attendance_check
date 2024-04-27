package com.example.attendance_check.services;

import com.example.attendance_check.models.*;
import com.example.attendance_check.models.dtos.AttendanceDetailsIds;
import com.example.attendance_check.models.dtos.AttendanceDetailsNames;
import com.example.attendance_check.repositories.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final PremiseRepository premiseRepository;
    private final CompanyRepository companyRepository;
    private final CompanyDepartmentRepository companyDepartmentRepository;
    private final DepartmentRepository departmentRepository;
    private final PeopleRepository peopleRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, PeopleRepository peopleRepository,
                             PremiseRepository premiseRepository, CompanyRepository companyRepository,
                             CompanyDepartmentRepository companyDepartmentRepository, DepartmentRepository departmentRepository){
        this.attendanceRepository = attendanceRepository;
        this.peopleRepository = peopleRepository;
        this.premiseRepository = premiseRepository;
        this.companyRepository = companyRepository;
        this.companyDepartmentRepository = companyDepartmentRepository;
        this.departmentRepository = departmentRepository;
    }

    public AttendanceDetailsIds addNewAttendance(AttendanceDetailsNames attendanceDetailsNames){
       Premise premise = premiseRepository.findByNames(attendanceDetailsNames.getPremise_name());
       AggregateReference<Premise, Integer> premiseAggregateReference = AggregateReference.to(premise.getId());
       Company company = companyRepository.findByNames(attendanceDetailsNames.getCompany_name());
       AggregateReference<Company, Integer> companyAggregateReference = AggregateReference.to(company.getId());
       CompanyDepartment companyDepartment = companyDepartmentRepository.findByNames(attendanceDetailsNames.getCompanydepartment_name());
       AggregateReference<CompanyDepartment, Integer> companyDepartmentAggregateReference = AggregateReference.to(companyDepartment.getId());
       Department department = departmentRepository.findByNames(attendanceDetailsNames.getDepartment_name());
       AggregateReference<Department, Integer> departmentAggregateReference = AggregateReference.to(department.getId());
       People people = peopleRepository.findByNationalid(attendanceDetailsNames.getPeople_nationalid());
       AggregateReference<People, Integer> peopleAggregateReference = AggregateReference.to(people.getId());

        attendanceRepository.save(new Attendance(null, premiseAggregateReference, companyAggregateReference,
                companyDepartmentAggregateReference, departmentAggregateReference, peopleAggregateReference));

        return new AttendanceDetailsIds(premise.getId(), company.getId(), companyDepartment.getId(), department.getId(), people.getId());
    }
}
