package com.example.mortgageanalyzergui;

public class mortgageanalyzer {
    private double loanAmount;
    private int loanTerm;
    private double interestRate;

    public mortgageanalyzer() {
        loanAmount = 0;
        loanTerm = 0;
        interestRate = 0;
    }

    public void setLoanDetails(double loanAmount, int loanTerm, double interestRate) {
        this.loanAmount = loanAmount;
        this.loanTerm = loanTerm;
        this.interestRate = interestRate;
    }

    public boolean verifyInput(double mortgageAmount, int loanTerm, double interestRate) {
        boolean valid = true;

        if (mortgageAmount <= 0) {
            valid = false;
            System.out.println("Invalid loan amount. Please enter a positive value.");
        }

        if (loanTerm <= 0) {
            valid = false;
            System.out.println("Invalid loan term. Please enter a positive value.");
        }

        if (interestRate <= 0) {
            valid = false;
            System.out.println("Invalid interest rate. Please enter a positive value.");
        }

        return valid;
    }

    public double calculateMonthlyPayment(double mortgageAmount, double interestRate, int loanTerm) {
        double monthlyInterestRate = interestRate / 12 / 100;
        int numPayments = loanTerm;

        double numerator = mortgageAmount * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numPayments);
        double denominator = Math.pow((1 + monthlyInterestRate), numPayments) - 1;

        double monthlyPayment = numerator / denominator;
        monthlyPayment = Math.ceil(monthlyPayment * 100) / 100;

        return monthlyPayment;
    }

    public double calculateTotalInterest(double mortgageAmount, double monthlyPayment, int loanTerm) {
        double totalInterest = loanTerm * monthlyPayment - mortgageAmount;
        totalInterest = Math.ceil(totalInterest * 100) / 100;

        return totalInterest;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getLoanTerm() {
        return loanTerm;
    }
}
