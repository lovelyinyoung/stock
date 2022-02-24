package com.iy.stockproject.business.service;

import com.iy.stockproject.business.domain.CompanyStock;
import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.entity.Stock;
import com.iy.stockproject.data.repository.CompanyRepository;
import com.iy.stockproject.data.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyStockService {
    private CompanyRepository companyRepository;
    private StockRepository stockRepository;

    //TODO: get data from TD API

    public List<CompanyStock> getCompanyStocksForDate(Date date) {
        Iterable<Company> companies = this.companyRepository.findAll();
        Map<Long, CompanyStock> companyStockMap = new HashMap<>();
        companies.forEach(company -> {
            CompanyStock companyStock = new CompanyStock();
            companyStock.setCompanyId(company.getCompanyId());
            companyStock.setTickerSymbol(company.getTickerSymbol());
            companyStockMap.put(company.getCompanyId(), companyStock);
        });

        Iterable<Stock> stocks = this.stockRepository.findStockByDate(new java.sql.Date(date.getTime()));
        stocks.forEach(stock -> {
            CompanyStock companyStock = companyStockMap.get(stock.getCompanyId());
            companyStock.setDate(stock.getDate());
            companyStock.setPrice(stock.getPrice());
        });

        List<CompanyStock> companyStocks = new ArrayList<>();
        for(Long id : companyStockMap.keySet()) {
            companyStocks.add(companyStockMap.get(id));
        }
        return companyStocks;
    }

    public List<Company> getCompanies() {
        Iterable<Company> companies = this.companyRepository.findAll();
        List<Company> companyList = new ArrayList<>();
        companies.forEach(company -> {
            companyList.add(company);
        });
        return companyList;
    }

    public List<Stock> getStocks() {
        Iterable<Stock> stocks = this.stockRepository.findAll();
        List<Stock> stockList = new ArrayList<>();
        stocks.forEach(stock -> {
            stockList.add(stock);
        });
        return stockList;
    }
}
