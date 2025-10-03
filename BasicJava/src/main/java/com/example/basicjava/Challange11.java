package com.example.basicjava;

public class Challange11 {
    String ownerName;
    double ballance;

    public Challange11(String ownerName, double ballance) {
        this.ownerName = ownerName;
        this.ballance = ballance;
    }

    public void deposit(double amount) {
        ballance += amount;
    }

    public boolean withdraw(double amount) {
        if (ballance >= amount) {
            ballance -=amount;
            return true;
        }
        return false;
    }
    public double getBalance() {
        return ballance;
    }
}
