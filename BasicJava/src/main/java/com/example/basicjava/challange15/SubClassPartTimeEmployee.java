package com.example.basicjava.challange15;

public class SubClassPartTimeEmployee extends Employee implements Payable {

    double hourlyRate;
    double hoursWorked;

    public SubClassPartTimeEmployee(EmployeeType employeeType) {
        super();
    }


    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getDetails() {
        return "i am a part time employee and my name is: " + getName() + "";
    }

    @Override
    public double calculatePay() {

        return hourlyRate * hoursWorked;
    }
}
