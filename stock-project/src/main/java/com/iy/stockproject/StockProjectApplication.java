package com.iy.stockproject;

import com.iy.stockproject.data.entity.Company;
import com.iy.stockproject.data.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StockProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockProjectApplication.class, args);
	}
}
