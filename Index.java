package Final;
import java.util.Scanner;

import Changing_package.BankAccount;
import Changing_package.Loan;
import Changing_package.Transaction;

import java.util.ArrayList;
public class Index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        ArrayList<Transaction> transactions = new ArrayList<>();//collection framework concept
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();//BankAccount and transactions are the classes
//        char loginEmoji = '\uD83D\uDEAA';
        int accountId;
        int pin;
        BankAccount currentAccount = null;
        boolean current = false;
        boolean Saving = false;
		boolean Business = false;
		boolean Salary = false;
        do {
            System.out.println("1. Login");
//            System.out.print(+LoginEmoji());
            System.out.println("2. Create Account");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter Account ID:" );
                    accountId = sc.nextInt();
                    System.out.print("Enter PIN:");
                    pin = sc.nextInt();
                    
                    currentAccount = login(bankAccounts, accountId, pin);
                    if (currentAccount == null) {
                        System.out.println("Invalid Account ID or PIN. Please try again.");
                    } else {
                        System.out.println("Login Successful!");
                        performTransactions(sc, currentAccount, transactions);
                    }
                    break;
                case 2:
				int option;
				do{
                		System.out.println("-------Which Account you want to create--------");
                		System.out.println("1.Current");
                		System.out.println("2.Saving");
                		System.out.println("3.Salary");
                		System.out.println("4.Buisness");
                		 option=sc.nextInt();
                	
					switch(option)
                	{
                	case 1: 
                		 if (current) {
                    		 System.out.println("***********************************************************");
                             System.out.println("SORRY, YOU CAN HAVE ONLY ONE CURRENT ACCOUNT IN OUR BANK");
                             System.out.println("**************************************************************");

                             break;
                         }
                		System.out.println("-----------Current Account form-------------");
                		  System.out.print("Enter Account ID:(IN numbers) ");
                          accountId = sc.nextInt();
                          System.out.print("Enter PIN: (IN numbers)");
                          pin = sc.nextInt();
                          BankAccount newAccount = createAccount(accountId, pin);
                          bankAccounts.add(newAccount);
                          System.out.println("Account created successfully!");
                          current=true;
                          break;
                	case 2: 
                		if (Saving) {
                   		 System.out.println("***********************************************************");
                            System.out.println("SORRY, YOU CAN HAVE ONLY ONE SAVING ACCOUNT IN OUR BANK");
                            System.out.println("**************************************************************");
                            break;
                        }
               		System.out.println("-----------Saving Account form-------------");
               		  System.out.print("Enter Account ID:(IN numbers) ");
                         accountId = sc.nextInt();
                         System.out.print("Enter PIN: (IN numbers)");
                         pin = sc.nextInt();
                         BankAccount newAccount1 = createAccount(accountId, pin);
                         bankAccounts.add(newAccount1);
                         System.out.println("Account created successfully!");
                         Saving=true;
                         break;
                	case 3:
                	
						if (Salary) {
                      		 System.out.println("***********************************************************");
                               System.out.println("SORRY, YOU CAN HAVE ONLY ONE SAVING ACCOUNT IN OUR BANK");
                               System.out.println("**************************************************************");

                               break;
                           }
                  		System.out.println("-----------Salary Account form-------------");
                  		  System.out.print("Enter Account ID: (IN numbers)");
                            accountId = sc.nextInt();
                            System.out.print("Enter PIN: (IN numbers)");
                            pin = sc.nextInt();
                            BankAccount newAccount2 = createAccount(accountId, pin);
                            bankAccounts.add(newAccount2);
                            System.out.println("Account created successfully!");
                            Salary=true;
                            break;
                	case 4:
                		if (Business) {
                     		 System.out.println("***********************************************************");
                              System.out.println("SORRY, YOU CAN HAVE ONLY ONE SAVING ACCOUNT IN OUR BANK");
                              System.out.println("**************************************************************");

                              break;
                          }
                 		System.out.println("-----------Business Account form-------------");
                 		  System.out.print("Enter Account ID: (IN numbers)");
                           accountId = sc.nextInt();
                           System.out.print("Enter PIN: (IN numbers)");
                           pin = sc.nextInt();
                           BankAccount newAccount3= createAccount(accountId, pin);
                           bankAccounts.add(newAccount3);
                           System.out.println("Account created successfully!");
                           Business=true;
                           break;
                        
                         
                	}
                  
                    break;
                	}while(option!=2);
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } while (currentAccount == null);
    }
    
    private static BankAccount login(ArrayList<BankAccount> bankAccounts, int accountId, int pin) {
        for (BankAccount account : bankAccounts) {
            if (account.getAccountId() == accountId && account.getPin() == pin) {
                return account;
            }
        }
        return null;
    }
    
    private static BankAccount createAccount(int accountId, int pin) {
        // You can implement additional validation or checks here.
        return new BankAccount(accountId, pin, 0);
    }
    
    private static void performTransactions(Scanner sc, BankAccount currentAccount, ArrayList<Transaction> transactions) {
        int option;
        do {
        	
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Passbook");
            System.out.println("4. Loan-Process");
            System.out.println("5.Log-Out");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();
            
            switch (option) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    if (depositAmount > 0) {
                        currentAccount.deposit(depositAmount);
                        transactions.add(new Transaction("Deposit", depositAmount,currentAccount.getBalance()));
                    } else {
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount > 0 && currentAccount.getBalance() >= withdrawAmount) {
                        currentAccount.withdraw(withdrawAmount);
                        transactions.add(new Transaction("Withdraw", -withdrawAmount,currentAccount.getBalance()));
                    } else {
                        System.out.println("Invalid amount or insufficient balance. Please try again.");
                    }
                    break;
                case 3:
                    System.out.println("Passbook:");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;
                case 4:
                	
                	System.out.print("Enter loan amount: Rs");
        	        double loanAmount = sc.nextDouble();

        	        System.out.print("Enter loan duration (in years): ");
        	        int loanDuration = sc.nextInt();

        	        System.out.print("Enter interest rate: ");
        	        double interestRate = sc.nextDouble();

        	        sc.nextLine(); // Consume newline character

        	        Loan personalLoan = new Loan(loanAmount, loanDuration, interestRate);
        	        personalLoan.processLoan();
        	        break;
                case 5:
                	System.out.println("Logging out....");
        	        
               
            }
        } while (option != 5);
	}

}
