package com.aor.refactoring.example3;

public class DiscontPercentage implements IDiscont {
    private final double disc;

    DiscontPercentage(Double d)
    {
        disc = d;
    }

    public double applyDiscount(double price) {

        return price - price * disc;

    }

}
