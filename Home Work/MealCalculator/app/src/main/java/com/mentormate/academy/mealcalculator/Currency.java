package com.mentormate.academy.mealcalculator;

public enum Currency{
    EUR(1, " EUR"),
    BNG(1.96, " BGN"),
    USD(1.24, " USD");
    private final double exchangeRate;
    private final String name;
    private Currency(double exRate, String name){
        this.exchangeRate=exRate;
        this.name=name;
    }
    public Double Exchange(){
        return exchangeRate;
    }
    @Override
    public String toString(){
        return name;
    }
}
