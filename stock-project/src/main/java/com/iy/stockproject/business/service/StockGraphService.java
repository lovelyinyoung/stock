package com.iy.stockproject.business.service;

import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class StockGraphService {
    private CompanyRepository companyRepository;
    //TODO: get data from TD API

    public List<Company> getCompanies() {
        Iterable<Company> companies = this.companyRepository.findAll();
        List<Company> companyList = new ArrayList<>();
        companies.forEach(company -> {
            companyList.add(company);
        });
        return companyList;
    }
}
