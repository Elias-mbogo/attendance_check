package com.example.attendance_check.services;

import com.example.attendance_check.models.Company;
import com.example.attendance_check.models.CompanyDepartment;
import com.example.attendance_check.models.Department;
import com.example.attendance_check.models.Premise;
import com.example.attendance_check.models.dtos.CompanyDetailsNames;
import com.example.attendance_check.repositories.CompanyDepartmentRepository;
import com.example.attendance_check.repositories.CompanyRepository;
import com.example.attendance_check.repositories.DepartmentRepository;
import com.example.attendance_check.repositories.PremiseRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyDetailsService {
    private final PremiseRepository premiseRepository;
    private final CompanyRepository companyRepository;
    private final CompanyDepartmentRepository companyDepartmentRepository;
    private final DepartmentRepository departmentRepository;

    public CompanyDetailsService(
            PremiseRepository premiseRepository, CompanyRepository companyRepository,
            CompanyDepartmentRepository companyDepartmentRepository, DepartmentRepository departmentRepository){
        this.premiseRepository = premiseRepository;
        this.companyRepository = companyRepository;
        this.companyDepartmentRepository = companyDepartmentRepository;
        this.departmentRepository = departmentRepository;
    }

    public CompanyDetailsNames getCompanyIds(CompanyDetailsNames companyDetailsNames){
        Premise premiseSearch = premiseRepository.findByNames(companyDetailsNames.getPremise_name());
        Company companySearch = companyRepository.findByNames(companyDetailsNames.getCompany_name());
        CompanyDepartment companyDepartmentSearch = companyDepartmentRepository.findByNames(companyDetailsNames.getCompanydepartment_name());
        Department departmentSearch = departmentRepository.findByNames(companyDetailsNames.getDepartment_name());

        return new CompanyDetailsNames(premiseSearch.getNames(), companySearch.getNames(), companyDepartmentSearch.getNames(), departmentSearch.getNames());

    }
}
