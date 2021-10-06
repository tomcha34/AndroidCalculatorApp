package com.android.tom_chambers_red_calculator;

public class CalculatorModel {

    double firstNumber = 0.0;
    double secondNumber = 0.0;
    double result = 0.0;

    Boolean firstNumberSet = false;
    Boolean secondNumberSet = false;
    Boolean operatorSet = false;

    String operator = "";

    public void setFirstNumber(double num) {
        firstNumber = num;
        firstNumberSet = true;
    }

    public void setSecondNumber(double num) {
        secondNumber = num;
        secondNumberSet = true;
    }

    public double getResult() {

        computeResults();
        return result;
    }

    public void setOperator(String op) {
        operator = op;
        operatorSet = true;
    }

    public void computeResults() {

        if (firstNumberSet && secondNumberSet && operatorSet) {
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "X":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    result = firstNumber / secondNumber;
                    break;
                case "√":
                    result = Math.sqrt(firstNumber);
                    break;

            }
        } else { //do nothing
        }
    }

    public void clear() {
        firstNumberSet = false;
        firstNumber = 0.0;
        secondNumber = 0.0;
        secondNumberSet = false;
        operatorSet = false;
        operator = "";
        result = 0.0;

    }
    
}
