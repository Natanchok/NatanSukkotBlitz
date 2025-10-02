package com.example.basicjava.challange15;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        SubClassFullTimeEmployee firstemployee= new SubClassFullTimeEmployee(EmployeeType.FULL_TIME);
        SubClassPartTimeEmployee employee1 = new SubClassPartTimeEmployee(EmployeeType.PART_TIME);
        SubClassFullTimeEmployee employee2 = new SubClassFullTimeEmployee(EmployeeType.FULL_TIME);
        SubClassManager manager = new SubClassManager(EmployeeType.MANAGER);

        firstemployee.setMonthlySalary(1000);
        employee2.setMonthlySalary(34.3);

        employee1.setHourlyRate(10);
        employee1.setHoursWorked(23);
        manager.setBonus(1000);

        manager.setName("Aviv");
        employee2.setName("Noam");
        employee1.setName("Adam");
        firstemployee.setName("Natan");

        ArrayList <Employee> employees = new ArrayList<>();
        employees.add(employee2);
        employees.add(employee1);
        employees.add(firstemployee);
        employees.add(manager);

        employees.sort(Comparator.comparingDouble(Employee::calculatePay).reversed());


        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.getDetails());
            System.out.println("and my salary is: " + employee.calculatePay());
        }

    }
}
