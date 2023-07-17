package com.example.mortgageanalyzergui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MortgageAnalyzerTest {
    @Test
    public void testMortgageAnalyzer() {
        double mortgageAmount = 140000.0;
        double interestRate = 8.0;
        int loanTerm = 360;

        double expectedMonthlyPayment = 1027.27;
        double expectedTotalInterestPaid = 229817.20;

        double monthlyPayment = calculations.calculateMonthlyPayment(mortgageAmount, interestRate, loanTerm);
        double totalInterestPaid = calculations.calculateTotalInterest(mortgageAmount, monthlyPayment, loanTerm);

        assertEquals(expectedMonthlyPayment, monthlyPayment, 0.01);
        assertEquals(expectedTotalInterestPaid, totalInterestPaid, 0.01);
    }
}
