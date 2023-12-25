package com.example.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brandId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long priceList;
    private Long productId;
    private Integer priority;
    private Double price;
    private String currency;

    public Price() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Long getPriceList() {
        return priceList;
    }

    public void setPriceList(Long priceList) {
        this.priceList = priceList;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public Price(Long id, Long brandId, LocalDate startDate, LocalDate endDate, Long priceList, Long productId, Integer priority, Double price, String currency) {
        this.id = id;
        this.brandId = brandId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price1 = (Price) o;
        return Objects.equals(getId(), price1.getId()) && Objects.equals(getBrandId(), price1.getBrandId()) && Objects.equals(getStartDate(), price1.getStartDate()) && Objects.equals(getEndDate(), price1.getEndDate()) && Objects.equals(getPriceList(), price1.getPriceList()) && Objects.equals(getProductId(), price1.getProductId()) && Objects.equals(getPriority(), price1.getPriority()) && Objects.equals(getPrice(), price1.getPrice()) && Objects.equals(getCurrency(), price1.getCurrency());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrandId(), getStartDate(), getEndDate(), getPriceList(), getProductId(), getPriority(), getPrice(), getCurrency());
    }
}
