package Final;

import java.util.Scanner;

public class Loan {
	Scanner sc=new Scanner(System.in);
	double demo,demo1;
	protected double amount;
    protected int duration;
    protected double interestRate;

    public Loan(double amount, int duration, double interestRate) {
        this.amount = amount;
        this.duration = duration;
        this.interestRate = interestRate;
    }
   
    public double calculateInterest() {
    	return amount*interestRate*duration;
    }

    public void processLoan() {
    	System.out.println("-----You are applied for loan containing following information-----");
        System.out.println("Loan processed for amount: Rs." + amount);
        System.out.println("Loan duration: " + duration + " years");
        System.out.println("Interest rate: " + (interestRate ) + "%");
        System.out.println("Interest amount: Rs " + calculateInterest());
        System.out.println("Loan processed successfully!");
        System.out.println("----------Thank you----------------");
       
    }
}
