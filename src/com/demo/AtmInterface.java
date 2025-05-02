package com.demo;
import java.util.*;

public class AtmInterface {
	private static Scanner scanner = new Scanner(System.in);

	 public static void main(String[] args) {
	     Bank bank = new Bank();
	     bank.seedData(); // Load some sample users

	     System.out.println("Welcome to the ATM");
	     System.out.print("Enter User ID: ");
	     String userId = scanner.nextLine();
	     System.out.print("Enter PIN: ");
	     String pin = scanner.nextLine();

	     if (bank.authenticate(userId, pin)) {
	         System.out.println("Login successful!\n");
	         boolean exit = false;
	         while (!exit) {
	             System.out.println("1. Show Transaction History");
	             System.out.println("2. Withdraw");
	             System.out.println("3. Deposit");
	             System.out.println("4. Transfer");
	             System.out.println("5. Quit");
	             System.out.print("Choose option: ");
	             int choice = scanner.nextInt();
	             scanner.nextLine();
	             switch (choice) {
	                 case 1:
	                     bank.showHistory(userId);
	                     break;
	                 case 2:
	                     System.out.print("Enter amount to withdraw: ");
	                     double wAmt = scanner.nextDouble();
	                     bank.withdraw(userId, wAmt);
	                     break;
	                 case 3:
	                     System.out.print("Enter amount to deposit: ");
	                     double dAmt = scanner.nextDouble();
	                     bank.deposit(userId, dAmt);
	                     break;
	                 case 4:
	                     System.out.print("Enter recipient User ID: ");
	                     String recipient = scanner.next();
	                     System.out.print("Enter amount to transfer: ");
	                     double tAmt = scanner.nextDouble();
	                     bank.transfer(userId, recipient, tAmt);
	                     break;
	                 case 5:
	                     exit = true;
	                     System.out.println("Thank you for using the ATM.");
	                     break;
	                 default:
	                     System.out.println("Invalid option.");
	             }
	         }
	     } else {
	         System.out.println("Invalid credentials!");
	     }
	 }
}


