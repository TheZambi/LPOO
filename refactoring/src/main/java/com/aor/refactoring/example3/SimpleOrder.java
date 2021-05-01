package com.aor.refactoring.example3;

public class SimpleOrder {
    private IDiscont discount;
    private double price;

    public SimpleOrder(double price) {
        this.price = price;
        discount = new DiscontNull();
    }

    public void setDiscount(IDiscont discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return discount.applyDiscount(price);
    }
}
