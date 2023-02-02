package com.company;
import java.util.Scanner;
import java.util.*;

public class Front_Interface extends  BankDatabase {
    Scanner Input = new Scanner(System.in);
    Boolean x = true;
    int choice;
    int CustomerId;
    int PinNumber;

    public void CreateNewAccount(){
        String name;
        int theAccountNumber,Pin;
        Double totalBalance;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Your Name: "); // Enter your name
        name = sc.nextLine();

        // Generate the Account Number Randomly

        Random random = new Random();
        double accountNumber = random.nextInt(10000);
        theAccountNumber = (int)accountNumber;
        System.out.println("Your Generated Account Number is: "+theAccountNumber);

        System.out.print("Enter your pin: "); // Enter your Pin Number
        Pin = sc.nextInt();

        System.out.print("Deposit your first Installment: "); // Deposit your first Installment
        totalBalance = sc.nextDouble();

        int i=2;

        if(i<accounts.length){
            accounts[i] = new Account(name,theAccountNumber,Pin,totalBalance);
        }
        else{
            System.out.println("Database is Full !");
        }
        i++;
    }
    public void getLogin(){
        do {
            try {
                System.out.println();
                System.out.println("*****=======> Welcome to the ATM Interface! <=======*****");
                System.out.println("Press 1 - Create a New Account");
                System.out.println("Press 2 - Login");

                System.out.println();

                System.out.print("Enter your choice: ");
                choice = Input.nextInt();

                switch(choice){
                    case 1:
                        CreateNewAccount();
                        getLogin();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println(" Invalid Choice ! Enter the right Input ");
                }

                System.out.println();
                System.out.println("=======================> LOGIN <========================");
                System.out.print("Enter Your Customer Id: ");
                CustomerId = Input.nextInt();

                System.out.print("Enter Your Pin Code: ");
                PinNumber = Input.nextInt();
            }
            catch (Exception e) {
                System.out.println( "Invalid character's Use only numbers." + "\n");
                x = false;
            }

            if(authenticateUser(CustomerId,PinNumber)){
                getCurrent();
            }
            else{
                System.out.println("Wrong Customer Id or Pin Number." + "\n");
            }

        } while (x);
    }

    // =========================> Display the Menu of the Current Account <==========================

    public void getCurrent() {
        System.out.println("*****************************************************");
        System.out.println("Current Account: ");
        System.out.println("Press 1 - Balance");
        System.out.println("Press 2 - Deposit");
        System.out.println("Press 3 - Withdraw ");
        System.out.println("Press 4 - Transactions History ");
        System.out.println("Press 5 - Exit");
        System.out.println("*****************************************************");

        System.out.print("Enter Your Choice: ");

        choice = Input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Current Account Balance: " + getTotalBalance(CustomerId) + "\n");
                getCurrent();
                break;

            case 2:
                getCurrentDepositInput(CustomerId);
                getCurrent();
                break;

            case 3:
                getCurrentWithdrawInput(CustomerId);
                getCurrent();
                break;

            case 4:
                TransactionHistory(CustomerId);
                getCurrent();
                break;

            case 5:
                System.out.println("Thank You for using this ATM, see you soon.");
                x=false;
                break;

            default:
                System.out.println("Invalid choice." + "\n");
                getCurrent();
        }
    }

}
