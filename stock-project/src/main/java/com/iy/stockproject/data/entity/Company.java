package com.iy.stockproject.data.entity;

import javax.persistence.*;

@Entity
@Table(name="COMPANY")
public class Company {
    @Id
    @Column(name="COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;

    @Column(name="TICKER_SYMBOL")
    private String tickerSymbol;

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
    }
}
