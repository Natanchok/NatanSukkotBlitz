package com.example.basicjava.challange15;

public class SubClassManager extends Employee implements Payable {
    String name;
    double fixedSalary = 4500.90;
    double bonus;

    public SubClassManager(EmployeeType employeeType) {
        super();
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDetails() {
        return "hey my name is: " + getName() + " and i am a manager";
    }

    @Override
    public double calculatePay() {
        return fixedSalary + getBonus();
    }
}
