package com.company;

import java.util.Scanner;


public class Calculator {

    public static String addition(double number1, double number2) {
        System.out.println("Result is " + (number1 + number2));
        return number1 + "+" + number2 + "=" + (number1 + number2);
    }

    public static String subtraction(double number1, double number2) {
        System.out.println("Result is " + (number1 - number2));
        return number1 + "-" + number2 + "=" + (number1 - number2);
    }

    public static String multiplication(double number1, double number2) {
        System.out.println("Result is " + (number1 * number2));
        return number1 + "*" + number2 + "=" + (number1 * number2);
    }

    public static void divisionCheck(double number2) throws ArithmeticException {
        if (number2 == 0)
            throw new ArithmeticException("You can't divide by zero");
    }

    public static String division(double number1, double number2) throws ArithmeticException{
        System.out.println("Result is " + (number1 / number2));
        return number1 + "/" + number2 + "=" + (number1 / number2);
    }

    public static String exponentiation(double number1, double number2) {
        System.out.println("Result is " + Math.pow(number1, number2));
        return number1 + "^" + number2 + "=" + Math.pow(number1, number2);
    }

    public static void dataStandardInput(String number1, String number2) throws NotNumberException {
        if (isNumber(number1) == false)
            throw new NotNumberException("The first element isn't a number");
        if (isNumber(number2) == false)
            throw new NotNumberException("The second element isn't a number");
    }

    public static void sqrtCheck(String number) throws NotNumberException, ArithmeticException {
        if (isNumber(number) == false)
            throw new NotNumberException("Your element isn't a number");
        double num = Double.parseDouble(number);
        if (num < 0)
            throw new ArithmeticException("You can't extract the square root of a negative number");
    }

    public static String sqrt(String num) {
        double number = Double.parseDouble(num);
        System.out.println("Result is " + Math.sqrt(number));
        return "square root of" + number + "=" + Math.sqrt(number);
    }

    public static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }


}
