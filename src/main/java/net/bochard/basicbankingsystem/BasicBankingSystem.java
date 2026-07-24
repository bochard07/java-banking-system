/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.bochard.basicbankingsystem;

import java.util.Scanner;

/**
 *
 * @author bochard
 */

public class BasicBankingSystem {
  public static void main(String[] args) {
    int userChoice;
    double balance = 0.0;
    Scanner scanner = new Scanner(System.in);
    
    System.out.println("===== BASIC JAVA BANKING PROGRAM =====");
    do {
      System.out.println("*****************");
      System.out.println("0. Exit\n1. Show balance\n2. Deposit\n3. Withdraw");
      System.out.println("*****************");
      
      System.out.print("Enter your choice: ");
      userChoice = scanner.nextInt();
      
      switch(userChoice) {
        case 0 -> System.out.println("Bye...");
        case 1 -> showBalance(balance);
        case 2 -> balance = deposit(balance, scanner);
        case 3 -> balance = withdraw(balance, scanner);
        default -> System.out.print("Invalid choice!\n\n");
      }
    } while(userChoice != 0);
    
    scanner.close();
  }
  
  public static void showBalance(double balance) {
    System.out.printf("Your current balance is: ₱%.2f\n\n", balance);
  }
  
  public static double deposit(double balance, Scanner scanner) {
    double toDeposit;
    
    System.out.print("Enter amount to deposit: ₱");
    toDeposit = scanner.nextDouble();
    
    balance += toDeposit;
    
    System.out.print("Deposit, succesful!\n\n");
    
    return balance;
  }
  
  public static double withdraw(double balance, Scanner scanner) {
    double toWithdraw;
    
    if(balance == 0) {
      System.out.print("You currently have no balance.");
    } else {
      System.out.print("Enter amount to withdraw: ₱");
      toWithdraw = scanner.nextDouble();

      if(toWithdraw > balance) {
        System.out.print("The withdrawal amount is greater than the available balance.");
      } else if(toWithdraw < 50) {
        System.out.print("The required amount to withdraw is ₱50.");
      } else {
        balance -= toWithdraw;

        System.out.print("Withdraw, succesful!");
      }
    }
    
    System.out.print("\n\n");
    
    return balance;
  }
}