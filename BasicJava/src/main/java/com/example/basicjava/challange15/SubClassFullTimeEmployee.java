package com.example.basicjava.challange15;

public class SubClassFullTimeEmployee extends Employee implements Payable {
    private double monthlySalary;

    public SubClassFullTimeEmployee(EmployeeType employeeType) {
        super();
    }


    @Override
    public String getDetails() {
        return "i am a full time employee and my name is: " + getName() + "";
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculatePay() {
        return getMonthlySalary();
    }
}
