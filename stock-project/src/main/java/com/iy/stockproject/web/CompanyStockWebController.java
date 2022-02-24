package com.iy.stockproject.web;

import com.iy.stockproject.business.domain.CompanyStock;
import com.iy.stockproject.business.service.CompanyStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/companystocks")
public class CompanyStockWebController {
    private final CompanyStockService companyStockService;

    @Autowired
    public CompanyStockWebController(CompanyStockService companyStockService) {
        this.companyStockService = companyStockService;
    }

    @GetMapping
    public String getCompanyStocks(@RequestParam(value = "date", required = false) String dateString, Model model) {
        Date date = DateUtils.createDateFromDate(dateString);
        List<CompanyStock> companyStocks = this.companyStockService.getCompanyStocksForDate(date);
        model.addAttribute("companyStocks", companyStocks);
        return "companyStocks";
    }
}
