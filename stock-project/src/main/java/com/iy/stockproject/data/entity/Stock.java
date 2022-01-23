package com.iy.stockproject.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Currency;

@Entity
@Table(name="STOCK")
public class Stock {
    //TODO: check what Yahoo finance AIP provides

    @Id
    @Column(name="COMPANY_ID")
    private long companyId;
    //TODO: double check if foreign key can be done like this

    @Column(name="CURRENT_PRICE")
    private Currency currentPrice;




}
