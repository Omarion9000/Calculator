package org.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
    @FXML
    private Label result;
    private long number1;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    public void processNumbers(ActionEvent actionEvent) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button) actionEvent.getSource()).getText();
        result.setText(result.getText() + value);
    }

    public void processOperators(ActionEvent actionEvent) {
        String value = ((Button) actionEvent.getSource()).getText();
        if (!value.equals("=")) {

            if (!operator.isEmpty())
                return;
            operator = value;
            number1 = Long.parseLong(result.getText());
            result.setText("");
        }
   else {
            if (operator.isEmpty())
                return;
            long number2=Long.parseLong(result.getText());
            float output= model.calculate(number1, number2, operator);
            result.setText(String.valueOf(output));
        }
    }
}
