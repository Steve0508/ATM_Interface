package com.demo;


import java.util.*;

public class Bank {
    private Map<String, AccountHolder> users = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, List<String>> transactionHistory = new HashMap<>();

    public void seedData() {
        AccountHolder ah = new AccountHolder("praveen0508", "1234");
        users.put("praveen0508", ah);
        accounts.put("praveen0508", new Account("praveen0508"));
        transactionHistory.put("praveen0508", new ArrayList<>());
    }

    public boolean authenticate(String userId, String pin) {
        AccountHolder ah = users.get(userId);
        return ah != null && ah.getPin().equals(pin);
    }

    public void showHistory(String userId) {
        List<String> history = transactionHistory.get(userId);
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            history.forEach(System.out::println);
        }
    }

    public void withdraw(String userId, double amount) {
        Account acc = accounts.get(userId);
        if (acc.getBalance() >= amount) {
            acc.debit(amount);
            transactionHistory.get(userId).add("Withdrawn: " + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(String userId, double amount) {
        Account acc = accounts.get(userId);
        acc.credit(amount);
        transactionHistory.get(userId).add("Deposited: " + amount);
        System.out.println("Deposit successful.");
    }

    public void transfer(String fromId, String toId, double amount) {
        if (!users.containsKey(toId)) {
            System.out.println("Recipient not found.");
            return;
        }
        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);
        if (from.getBalance() >= amount) {
            from.debit(amount);
            to.credit(amount);
            transactionHistory.get(fromId).add("Transferred " + amount + " to " + toId);
            transactionHistory.get(toId).add("Received " + amount + " from " + fromId);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}
