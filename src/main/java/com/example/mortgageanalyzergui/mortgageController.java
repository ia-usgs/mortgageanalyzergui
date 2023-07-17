package com.example.mortgageanalyzergui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class mortgageController {
    private mortgageanalyzer mortgageAnalyzer;

    @FXML
    private TextField loanTextField;

    @FXML
    private TextField interestTextField;

    @FXML
    private TextField durationTextField;

    @FXML
    private TextArea textArea;

    @FXML
    private Button verificationButton;

    @FXML
    private Button analyzeButton;

    @FXML
    private void initialize() {
        mortgageAnalyzer = new mortgageanalyzer();
        analyzeButton.setDisable(true); // starts with the button off
    }

    @FXML
    private void verificationButton() {
        double loanAmount = Double.parseDouble(loanTextField.getText());
        double interestRate = Double.parseDouble(interestTextField.getText());
        int loanTerm = Integer.parseInt(durationTextField.getText());

        boolean verified = mortgageAnalyzer.verifyInput(loanAmount, loanTerm, interestRate);

        if (verified) {
            mortgageAnalyzer.setLoanDetails(loanAmount, loanTerm, interestRate);
            textArea.setText("Verification Complete");
            analyzeButton.setDisable(false); //turns on the analyzebutton if it goes through
        } else {
            textArea.setText("Invalid Input, please try again");
            analyzeButton.setDisable(true); // will turn off the analyzebutton if it doesw not go through
        }
    }

    @FXML
    private void analyzeButton() {
        double loanAmount = mortgageAnalyzer.getLoanAmount();
        double interestRate = mortgageAnalyzer.getInterestRate();
        int loanTerm = mortgageAnalyzer.getLoanTerm();

        double monthlyPayment = calculations.calculateMonthlyPayment(loanAmount, interestRate, loanTerm);
        double totalInterestPaid = calculations.calculateTotalInterest(loanAmount, monthlyPayment, loanTerm);

        textArea.setText("Amount of Loan: $" + loanAmount + "\n"
                + "Annual Interest Rate: " + interestRate + "%\n"
                + "Duration of loan in months: " + loanTerm + "\n"
                + "Monthly payment: $" + monthlyPayment + "\n"
                + "Total interest paid: $" + totalInterestPaid);
    }
}
