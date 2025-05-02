package com.demo;



public class Account {
    private String accountId;
    private double balance;

    public Account(String accountId) {
        this.accountId = accountId;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) {
        this.balance -= amount;
    }
}
