package com.iy.stockproject.web;

import com.iy.stockproject.business.domain.CompanyStock;
import com.iy.stockproject.business.service.CompanyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CompanyStockWebController {
    private final CompanyStockService companyStockService;

    @Autowired
    public CompanyStockWebController(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }

    @GetMapping("/companystocks")
    public List<CompanyStock> getCompanyStocks(Model model) {
        List<CompanyStock> companyStocks = this.companyStockService.getAllCompanyStocks();
        return companyStocks;
    }

    @GetMapping("/companystocks/{tickerSymbol}")
    public String getCompanyStockByTickerSymbol(@PathVariable String tickerSymbol) {
        String companyStock = this.companyStockService.getCompanyStockByTickerSymbol(tickerSymbol);
        return companyStock;
    }

//    @GetMapping("/companystocks/{companyId}")
//    public CompanyStock getCompanyStockById(@PathVariable long companyId) {
//        CompanyStock companyStock = this.companyStockService.getCompanyStockById(companyId);
//        return companyStock;
//    }
//
//    @GetMapping("/companystocks/{companyID}/{date}")
//    public String getCompanyStocks(@RequestParam(value = "date", required = false) String dateString, Model model) {
//        Date date = DateUtils.createDateFromDate(dateString);
//        List<CompanyStock> companyStocks = this.companyStockService.getCompanyStocksForDate(date);
//        model.addAttribute("companyStocks", companyStocks);
//        return "companyStocks";
//    }
}
