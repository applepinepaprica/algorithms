package com.company.application;

import com.company.calculator.Calc;
import com.company.calculator.ParsException;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    /**
     * Label для ввода арифметического выражения и вывода результата
     */
    public Label label;

    /**
     * Добавляет символ в поле для ввода выражения
     * Символ соотвествует надписи на кнопке
     */
    public void addChar(ActionEvent actionEvent) {
        if (label.getText().equals("Error")) {
            label.setText("");
        }

        label.setText(label.getText() + ((Button) actionEvent.getTarget()).getText());
    }

    /**
     * Высчитывает результат арифметического выражения, введеного в поле для ввода, и выводит в то же поле
     */
    public void result(ActionEvent actionEvent) {
        try {
            double result = Calc.calc(label.getText());
            label.setText(Double.toString(result));
        } catch (ParsException e) {
            label.setText("Error");
        }
    }

    /**
     * Удаляет последний символ
     */
    public void deleteLast(ActionEvent actionEvent) {
        String str = label.getText();
        label.setText(str.substring(0, str.length() - 1));
    }

    /**
     * Удаляет все символы
     */
    public void deleteAll(ActionEvent actionEvent) {
        label.setText("");
    }
}
