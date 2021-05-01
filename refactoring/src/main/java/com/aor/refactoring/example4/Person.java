package com.aor.refactoring.example4;

public abstract class Person {
    protected String name;
    protected String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public boolean login(String username, String password) {
        return false;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
