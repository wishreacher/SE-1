/*
    Написати "найпростіший калькулятор", що отримує на вхід 2 числа і операцію над ними після чого
    повертає результат обчислень.

    File: Calculator.java
    Author: Федорич Володимир
 */

import acm.program.ConsoleProgram;

public class Calculator extends ConsoleProgram {
    public void run(){
        while(true){
            double firstNumber = readDouble("Enter first number: ");
            double secondNumber = readDouble("Enter second number: ");
            String stringValue = readLine("Enter value: ");

            if(stringValue.length() != 1){
                println("Error: value must be one character");
            } else {
                char operation = stringValue.charAt(0);
                double result = calculate(firstNumber, secondNumber, operation);
                println("Result: " + result);
            }
            handleExit();
        }
    }

    private void handleExit() {
        int exit = readInt("Enter 0 to exit and 1 to continue: ");
        while(exit != 0 && exit != 1){
            println("Error: value must be 0 or 1");
            exit = readInt("Enter 0 to exit and 1 to continue: ");
        }
        if(exit == 0){
            exit();
        }
    }

    private double calculate(double firstNumber, double secondNumber, char operation) {
        switch(operation){
            case '+':
                return firstNumber + secondNumber;
            case '-':
                return firstNumber - secondNumber;
            case '*':
                return firstNumber * secondNumber;
            case '/':
                return firstNumber / secondNumber;
            default:
                return 0;
        }
    }
}
