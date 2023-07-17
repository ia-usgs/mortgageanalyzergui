package com.example.mortgageanalyzergui;

public class calculations {
    public static double calculateMonthlyPayment(double mortgageAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = interestRate / 12 / 100;
        int numPayments = loanTerm;

        double numerator = mortgageAmount * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numPayments);
        double denominator = Math.pow((1 + monthlyInterestRate), numPayments) - 1;

        double monthlyPayment = numerator / denominator;


        monthlyPayment = Math.ceil(monthlyPayment * 100) / 100; //this is so it rounds up the final number

        return monthlyPayment;
    }

    public static double calculateTotalInterest(double mortgageAmount, double monthlyPayment, int loanTerm) {
        double totalInterest = loanTerm * monthlyPayment - mortgageAmount;


        totalInterest = Math.ceil(totalInterest * 100) / 100; //again, to round up final number

        return totalInterest;
    }
}
