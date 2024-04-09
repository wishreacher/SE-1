/*
    Написати свій власний клас виняток і продемонструвати його використання.
 */

public class Main {
    public static class MyException extends Exception{
        public MyException(String message){
            super(message + " It's custom!");
        }
    }

    public static int divideNumbers(int num1, int num2) throws MyException {
        if(num2 == 0){
            throw new MyException("Division by zero is not allowed");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        try{
            int result = divideNumbers(10, 0);
            System.out.println("Result: " + result);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}