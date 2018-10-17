package com.company.file_calculator;

import com.company.calculator.Calc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        double result;
        String line;
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            line = br.readLine();
            result = Calc.calc(line);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        try (FileWriter file = new FileWriter("file.txt")) {
            file.write(line + "=" + result);
            System.out.println("Successfully wrote result to File...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
