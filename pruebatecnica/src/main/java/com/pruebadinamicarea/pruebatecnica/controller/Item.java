package com.pruebadinamicarea.pruebatecnica.controller;

import java.util.Date;

public class Item {
    private int BrandId;
    public Date SDate;
    private Date EDate;
    private int PList;
    private long ProductId;
    private int Priority;
    private double Price;
    private String Curr;

    public Item(int brandId, Date SDate, Date EDate, int PList, long productId, int priority, double price, String curr) {
        BrandId = brandId;
        this.SDate = SDate;
        this.EDate = EDate;
        this.PList = PList;
        ProductId = productId;
        Priority = priority;
        Price = price;
        Curr = curr;
    }

    public int getBrandId() {
        return BrandId;
    }

    public Date getSDate() {
        return SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public int getPList() {
        return PList;
    }

    public long getProductId() {
        return ProductId;
    }

    public int getPriority() {
        return Priority;
    }

    public double getPrice() {
        return Price;
    }

    public String getCurr() {
        return Curr;
    }
}
