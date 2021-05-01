package com.aor.refactoring.example3;

public class DiscontFixed implements IDiscont {
    private final int fixed;

    DiscontFixed(int f)
    {
        fixed=f;
    }

    public double applyDiscount(double price) {
        return fixed > price ? 0 : price - fixed;
    }
}
