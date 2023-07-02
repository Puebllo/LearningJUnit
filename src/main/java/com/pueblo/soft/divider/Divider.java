package com.pueblo.soft.divider;

public class Divider {

    private double numerator;
    private double denominator;

    public Divider() {
        this.numerator = 0.0;
        this.denominator = 0.0;
    }

    public Divider(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double getNumerator() {
        return numerator;
    }

    public void setNumerator(double numerator) {
        this.numerator = numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    public void setDenominator(double denominator) {
        this.denominator = denominator;
    }

    public double divide(){
        if ((denominator == 0.0) || (denominator == 0.0 && numerator == 0.0)){
            throw new IllegalArgumentException("Denominator can't be zero !");
        }
        return numerator / denominator;
    }
}
