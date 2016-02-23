package com.agileengine.skeleton.model;

import javax.persistence.Entity;

@Entity
public class Statistics {

    private String countryName;

    private int sum;

    public Statistics() {
    }

    public Statistics(String countryName, int sum) {
        this.countryName = countryName;
        this.sum = sum;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
