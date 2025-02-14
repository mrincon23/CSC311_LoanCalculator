package edu.farmingdale.csc311_loancalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.text.NumberFormat;
import java.util.Locale;

public class HelloController {
    @FXML
    private TextField txtInterestRate;

    @FXML
    private TextField txtYears;

    @FXML
    private TextField txtLoanAmount;

    @FXML
    private TextField txtMonthlyPayment;

    @FXML
    private TextField txtTotalPayment;

    @FXML
    private void onCalculateButtonClick() {
        try {
            double annualRate = Double.parseDouble(txtInterestRate.getText());
            int years = Integer.parseInt(txtYears.getText());
            double loanAmount = Double.parseDouble(txtLoanAmount.getText());

            double monthlyRate = annualRate / 100 / 12;
            int numPayments = years * 12;

            double monthlyPayment = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -numPayments));
            double totalPayment = monthlyPayment * numPayments;

            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            txtMonthlyPayment.setText(currencyFormat.format(monthlyPayment));
            txtTotalPayment.setText(currencyFormat.format(totalPayment));
        } catch (NumberFormatException e) {
            txtMonthlyPayment.setText("Invalid input");
            txtTotalPayment.setText("Invalid input");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid numbers.");
            alert.showAndWait();
        }
    }
}