package com.example.basicjava;

public class MyClass {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Challange11 account1 = new Challange11("Natan haham", 1000.0);

        account1.deposit(500.0);
        account1.withdraw(200.0);

        System.out.println("Account balance: " + account1.ballance);
        System.out.println("Account owner: " + account1.ownerName);
        System.out.println("Account balance: " + account1.getBalance());
    }
}