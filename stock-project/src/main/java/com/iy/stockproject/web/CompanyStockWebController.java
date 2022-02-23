package com.iy.stockproject.web;

import com.iy.stockproject.business.service.StockGraphService;
import com.iy.stockproject.data.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graph")
public class CompanyStockWebController {
    private final StockGraphService stockGraphService;

    @Autowired
    public CompanyStockWebController(StockGraphService stockGraphService) {
        this.stockGraphService = stockGraphService;
    }

    @GetMapping
    public String getCompanies(Model model) {
        List<Company> companies = this.stockGraphService.getCompanies();
        model.addAttribute("companies", companies);
        return "companies";
    }
}
