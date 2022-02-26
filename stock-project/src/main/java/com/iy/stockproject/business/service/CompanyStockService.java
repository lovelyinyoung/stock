package com.iy.stockproject.business.service;

import com.iy.stockproject.business.domain.CompanyStock;
import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.entity.Stock;
import com.iy.stockproject.data.repository.CompanyRepository;
import com.iy.stockproject.data.repository.StockRepository;
import com.iy.stockproject.web.HttpRequestor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CompanyStockService {
    private CompanyRepository companyRepository;
    private StockRepository stockRepository;
    private List<CompanyStock> companyStocks;

    public List<CompanyStock> getAllCompanyStocks() {
        //TODO: retrieve ticker symbols I have invested from DB and call HttpRequestor
        companyStocks = new ArrayList<>();
        CompanyStock tesla = new CompanyStock();
        tesla.setCompanyId(0);
        tesla.setTickerSymbol("TSLA");
        tesla.setPrice(720.00);
//        companyStock.setDate(date);
        companyStocks.add(tesla);

        CompanyStock teledoc = new CompanyStock();
        teledoc.setCompanyId(1);
        teledoc.setTickerSymbol("TELDOC");
        teledoc.setPrice(150.00);
//        companyStock.setDate(date);
        companyStocks.add(teledoc);

        return companyStocks;
    }

    public String getCompanyStockByTickerSymbol(String tickerSymbol) {
        return new HttpRequestor().do_request(tickerSymbol);
    }

    public CompanyStock getCompanyStockById(long id) {
        return companyStocks.stream().filter(companyStock ->
                companyStock.getCompanyId() == id).findFirst().get();
    }

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
