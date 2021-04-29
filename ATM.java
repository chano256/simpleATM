package ATM;

import java.util.Date;
import java.util.Scanner;

/**
 * ATM
 */
public class ATM {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int accountId = -1;
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100, 0.0);
        }

        do {
            System.out.println();
            System.out.println("Enter an ID: ");
            accountId = input.nextInt();
            if (accountId < 0 || accountId > 9) {
                continue;
            }

            do {
                printMainMenu();
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Your account balance is :" + accounts[accountId].getBalance());
                        break;
                
                    case 2:
                    System.out.println("Enter amount to withdraw: ");
                        double amount = input.nextInt();
                        
                        if (amount > accounts[accountId].getBalance()) {
                            System.out.println("The amount is greater than the balance.");
                        } else {
                            accounts[accountId].withDraw(amount);
                        }
                        break;

                    case 3:
                        System.out.print("Enter an amount to deposite: ");
                        amount = input.nextDouble();
                        accounts[accountId].deposit(amount);
                        break;

                    case 4:
                        break;
                }

                if (choice == 4) {
                    break;
                }

            } while (accountId <= 9 && accountId >= 0);

        } while (true);
    }

    public static void printMainMenu() {
        System.out.println();
        System.out.println("Main Menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
    }
}

class Account{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }  
    
    public Account(int id, double balance, double annualRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualRate;
        this.dateCreated = new Date();
    }  
    
    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 12);
    }

    public void withDraw(double amount) {
        //Deduct the amount on the current balance
        this.balance -= amount;
    }

    public void deposit(double amount) {
        //Add the amount to the current balance
        this.balance += amount;
    }
}