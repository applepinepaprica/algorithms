package com.company;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    public  Label label;

    public void AddChar(ActionEvent actionEvent) {
        if (label.getText().equals("Error"))
            label.setText("");
        label.setText(label.getText() + ((Button)actionEvent.getTarget()).getText());
    }

    public void Result(ActionEvent actionEvent) {
        label.setText(Calc.Calc(label.getText()));
    }

    public void deleteLast(ActionEvent actionEvent) {
        String str = label.getText();
        label.setText(str.substring(0, str.length() - 1));
    }

    public void deleteAll(ActionEvent actionEvent) {
        label.setText("");
    }
}
