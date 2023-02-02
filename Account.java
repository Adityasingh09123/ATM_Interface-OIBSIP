package com.company;
import java.util.ArrayList;

public class Account
{
    private String accountHolderName;
    private int accountNumber;
    private int pin;
    private double totalBalance;

    // =================> Account constructor initializes attributes <===================

    public Account(String name,int theAccountNumber, int thePIN, double theTotalBalance){
        accountHolderName = name;
        accountNumber = theAccountNumber;
        pin = thePIN;
        totalBalance = theTotalBalance;
    }

    // ===================> Validation of User input Pin to the Account Pin <===============

    public boolean validatePIN(int userPIN){
        if(userPIN == pin){
            return true;
        }
        else{
            return false;
        }
    }

    // ===============> Return the AccountHolderName of User <=================

    public String getAccountHolderName(){
        return accountHolderName;
    }

    // ===============> Return the TotalBalance of User <=================

    public double getTotalBalance(){

        return totalBalance;
    }

    // ===============> Credits an Amount to the Account <=================

    public void credit(double amount){

        totalBalance += amount;
    }

    // ===============> Debit an Amount from the Account <=================

    public void debit(double amount){

        totalBalance -= amount;
    }

    // ===============> Return the AccountNumber of User <=================

    public int getAccountNumber(){
        return accountNumber;
    }
}  // end class Account
