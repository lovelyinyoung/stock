package com.iy.stockproject.web;

import com.iy.stockproject.business.service.CompanyStockService;
import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.entity.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getCompanyStocks(Model model) {
        //TODO: use a method that retrieves both company and stock
        List<Company> companies = this.companyStockService.getCompanies();
        model.addAttribute("companyStocks", companies);
        return "companyStocks";
    }
}
