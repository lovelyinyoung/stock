package com.iy.stockproject.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Currency;
import java.util.Date;

@Entity
@Table(name="STOCK")
public class Stock {
    //TODO: check what Yahoo finance AIP provides

    @Id
    @Column(name="COMPANY_ID")
    private long companyId;
    //TODO: double check if foreign key can be done like this

    @Column(name="PRICE")
    private double price;

    @Column(name="DATE")
    private Date date;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
