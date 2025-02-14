module edu.farmingdale.csc311_loancalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.csc311_loancalculator to javafx.fxml;
    exports edu.farmingdale.csc311_loancalculator;
}