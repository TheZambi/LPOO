package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;

    public Order() {
        lines = new ArrayList<>();
    }

    public void add(OrderLine order) {
        lines.add(order);
    }

    public boolean isElegibleForFreeDelivery() {
        double total = 0;

        for (OrderLine line : lines)
            total += line.getProduct().getPrice() * line.getQuantity();

        return (total > 100);
    }

    private double getTotal()
    {
        double total = 0;
        for (OrderLine line : lines) {
            total += line.getProduct().getPrice() * line.getQuantity();
        }
        return total;
    }

    public String printOrder() {
        StringBuilder printBuffer = new StringBuilder();
        double total = 0;
        for (OrderLine line : lines) {
            printBuffer.append(line.toString() + "\n");
        }
        printBuffer.append("Total: " + getTotal());
        return printBuffer.toString();
    }
}