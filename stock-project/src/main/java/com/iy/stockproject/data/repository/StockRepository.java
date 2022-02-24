package com.iy.stockproject.data.repository;

import com.iy.stockproject.data.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
    Iterable<Stock> findStockByDate(Date date);
}
