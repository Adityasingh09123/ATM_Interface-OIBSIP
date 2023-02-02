package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class BankDatabase
{
    public Account[] accounts;
    double currentBalance = 0;
    double amount  = 0;
    ArrayList<Double> depositHistory = new ArrayList<Double>();
    ArrayList<Double> withdrawHistory = new ArrayList<Double>();

    // =======================> Account  Intialization <=========================

    public  BankDatabase(){
        accounts = new Account[10];
        accounts[0] = new Account("Aditya Singh",12345, 1234, 1200.0);
        accounts[1] = new Account("Akash Singh",98765, 56789,  2000.0);
    }


    // ========================> Retrieve Account for a specified Account Number <=========================

    private Account getAccount(int accountNumber){
        for(Account currentAccount : accounts){
            if(currentAccount.getAccountNumber() == accountNumber)
                return currentAccount;
        }
        return null;
    }

    // ======================> Retrieve Account Holder Name from a Account  <=============================


    public void getName(int userAccountNumber){
        getAccount(userAccountNumber).getAccountHolderName();
    }
    // ======================> Authenticate User Account Number and User Pin <=============================

    public boolean authenticateUser(int userAccountNumber, int userPIN){
        Account userAccount = getAccount(userAccountNumber);
        if(userAccount != null){
            return userAccount.validatePIN(userPIN);
        }
        else{
            return false;
        }
    }

    // =======================> Get Total Balance <===========================

    public double getTotalBalance(int userAccountNumber){
        return (getAccount(userAccountNumber).getTotalBalance());
    }

    // =======================> Get Credited Amount <==========================

    public void credit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).credit(amount);
    }

    // =======================> Get Withdraw Amount <==========================

    public void debit(int userAccountNumber, double amount){
        getAccount(userAccountNumber).debit(amount);
    }

    // ===================> Deposit Money to the Account <===================

    public void getCurrentDepositInput(int userAccountNumber) {
        System.out.println();
        currentBalance = getAccount(userAccountNumber).getTotalBalance();
        System.out.println("Current Account Balance: " + currentBalance );
        System.out.print("Deposit Amount be: ");
        Scanner input = new Scanner(System.in);
        amount = input.nextDouble();

        // Store Added money in a creditHistory List to show History

        depositHistory.add(amount);

        credit(userAccountNumber,amount);          // Update the Total Balance

        if ((currentBalance + amount) >= 0) {
            currentBalance = currentBalance + amount;
            System.out.println("New Current Account balance: " + currentBalance + "\n");
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    // ===================>  WithDraw Money from the Account <===================

    public void getCurrentWithdrawInput(int userAccountNumber) {
        System.out.println();
        currentBalance = getAccount(userAccountNumber).getTotalBalance();
        System.out.println("Current Account Balance: " + currentBalance );
        System.out.print("Withdraw Amount be: ");
        Scanner input = new Scanner(System.in);
        amount = input.nextDouble();

        // Store Added money in a debitHistory List to show History

        if((currentBalance-amount)>=0){
            withdrawHistory.add(amount);
            debit(userAccountNumber,amount);        // Update the Total Balance
        }
        else{
            System.out.println("Not Enough Money to Withdraw ! ");
        }


        if ((currentBalance - amount) >= 0) {
            currentBalance = currentBalance - amount;
            System.out.println("New Current Account balance: " + currentBalance + "\n");
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    public void TransactionHistory(int userAccountNumber){

        System.out.println();
        System.out.println("================> TRANSACTION HISTORY <================");
        System.out.println();

        if(depositHistory.size()>0 || withdrawHistory.size()>0){
            for(int i=0;i<depositHistory.size();i++){
                System.out.println("Credited to:    "+getAccount(userAccountNumber).getAccountHolderName() +"        +Rs "+depositHistory.get(i));
            }
            for(int i=0;i<withdrawHistory.size();i++){
                System.out.println("Debited from:   "+getAccount(userAccountNumber).getAccountHolderName()+"        -Rs "+withdrawHistory.get(i));
            }
        }
        else{
            System.out.println("There is no any Transaction held by this account");
        }


        System.out.println();
    }

}  // End of the Bank Database Class

