package com.android.tom_chambers_red_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    Boolean startNewNumber = true;
    String currentNumber;

    CalculatorModel calculatorModel = new CalculatorModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view) {
        Log.e(TAG, "buttonClicked: ");
        //Which button was pressed.
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        TextView textView = findViewById(R.id.numberDisplay);
        currentNumber = textView.getText().toString();

        switch (buttonText) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "0":
            case ".":
                if (startNewNumber) {
                    if (buttonText.equals(".")) {
                        currentNumber = "0.";
                    } else {
                        currentNumber = buttonText;
                    }
                    startNewNumber = false;
                } else {
                    if (buttonText.equals(".") && currentNumber.contains(".")) {
                        // Do nothing.
                    } else {
                        currentNumber = currentNumber + buttonText;
                    }
                }
                break;

            case "+":
            case "-":
            case "X":
            case "/":
            case "√":
                if (calculatorModel.firstNumberSet && calculatorModel.operatorSet
                        && !startNewNumber) {
                    calculate();

                }
                double firstNUmber = Double.parseDouble(currentNumber);
                calculatorModel.setFirstNumber(firstNUmber);

                calculatorModel.setOperator(buttonText);
                startNewNumber = true;
                break;

            case "=":
                if (calculatorModel.firstNumberSet) {
                    double secondNumber = Double.parseDouble(currentNumber);
                    calculatorModel.setSecondNumber(secondNumber);

                    calculate();
                    startNewNumber = true;
                }
                break;

            case "C":
                calculatorModel.clear();
                currentNumber = "0.";
                startNewNumber = true;
                break;
        }
        textView.setText(currentNumber);
    }


    public void calculate() {
        double secondNumber = Double.parseDouble(currentNumber);
        calculatorModel.setSecondNumber(secondNumber);

        currentNumber = resultToString(calculatorModel.getResult());
    }

    public String resultToString(double num) {
        int numInt = (int) num;

        if (num == numInt) {
            return Integer.toString(numInt);
        } else {
            return Double.toString(num);
        }
    }
}