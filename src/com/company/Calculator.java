package com.company;

import java.util.Scanner;


public class Calculator {

    public static String addition(double number1, double number2) {
        return number1 + "+" + number2 + "=" + (number1 + number2);
    }

    public static String subtraction(double number1, double number2) {
        return number1 + "-" + number2 + "=" + (number1 - number2);
    }

    public static String multiplication(double number1, double number2) {
        return number1 + "*" + number2 + "=" + (number1 * number2);
    }

    public static String division(double number1, double number2){
        try {
            catching(number2);
            return number1 + "/" + number2 + "=" + (number1 / number2);
        } catch (MyException ex){
            return number1+ "/"+number2+"="+"You can't divide by zero";
        }
    }

    public static String exponentiation(double number1, double number2) {
        return number1 + "^" + number2 + "=" + Math.pow(number1, number2);
    }

    public static String sqrt(double number){
        try {
            catching(number);
            return "square root of " + number + "=" + Math.sqrt(number);
        } catch (MyException ex){
            return "sqrt of "+number + " = You can't extract the square root of a negative number";
        }
    }

    public static void catching(double number) throws MyException {
        if(number == 0) {
            throw new MyException("You can't divide by zero");
        }
        else if(number <0) {
            throw new MyException("You can't extract the square root of a negative number");
        }
    }


}
