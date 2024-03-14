package com.example.demo.service;

import com.example.demo.dao.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company save(String name) {
        Company company = new Company();
        company.setName(name);
        return companyRepository.save(company);
    }
}
