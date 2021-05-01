package com.aor.refactoring.example4;

import com.sun.org.apache.xpath.internal.functions.FuncSubstringAfter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Supervisor extends Person {
    Set<Worker> supervisee;
    private final String username;
    private final String password;
    
    public Supervisor(String name, String phone, String username, String password) {
        super(name, phone);
        supervisee = new HashSet<>();
        this.username = username;
        this.password = password;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public void addSupervisee(Worker worker) {
        supervisee.add(worker);
    }

    public boolean isSupervisee(Worker worker) {
        return supervisee.contains(worker);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supervisor worker = (Supervisor) o;
        return Objects.equals(name, worker.name) &&
                Objects.equals(phone, worker.phone) &&
                Objects.equals(username, worker.username) &&
                Objects.equals(password, worker.password);
    }
}
