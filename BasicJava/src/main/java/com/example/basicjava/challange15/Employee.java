package com.example.basicjava.challange15;

public abstract class Employee implements Payable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDetails();
}
