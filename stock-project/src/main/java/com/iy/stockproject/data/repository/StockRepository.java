package com.iy.stockproject.data.repository;

import com.iy.stockproject.data.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long> {
}
