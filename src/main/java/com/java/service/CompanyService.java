package com.java.service;

import com.java.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();

    Company addCompany(Company company);

    Company updateCompany(Long id, Company company);

    boolean deleteCompany(Long id);

    Company getCompany(Long id);

}
