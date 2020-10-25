package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static final ArrayList<String> history = new ArrayList<String>();
    private static double number1;
    private static double number2;

    public static void menu() {
        Scanner in = new Scanner(System.in);
        int key = 1;
        int choice = 1;

        while (key == 1) {
            System.out.println("Press 1 to calculate or 0 to see the history");
            choice = in.nextInt();
            in.nextLine();

            if (choice == 1) {
                System.out.println("Choose the operation sign(+, -, *, /, ^, sqrt):");
                String operation = in.nextLine();
                operationSelection(operation);
            } else if (choice == 0) {
                System.out.println(history);
            } else {
                System.out.println("You entered a wrong key");
            }

            System.out.println("Press 1 to continue");
            key = in.nextInt();

        }

        in.close();
    }

    public static boolean checkFirstNumber(){
        Scanner in = new Scanner(System.in);
        System.out.println("The number: ");
        String num = in.nextLine();

        try {
            number1 = Double.parseDouble(num);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("This element isn't a number");
            history.add(num + " isn't a number");
            return false;
        }

    }

    public static  boolean checkSecondNumber(String operation){
        Scanner in = new Scanner(System.in);
        System.out.println("Another one: ");
        String num = in.nextLine();

        try {
            number2 = Double.parseDouble(num);
            return true;
        } catch (NumberFormatException ex) {
            System.out.println("This element isn't a number");
            history.add(num + " isn't a number");
            return false;
        }

    }

    public static void operationSelection(String operation) {
        String result = "";

        switch (operation) {
            case "+":

                if(!checkFirstNumber()) {
                    break;
                }

                if(!checkSecondNumber(operation)) {
                    break;
                }

                result = Calculator.addition(number1, number2);
                System.out.println(result);
                history.add(result);
                break;

            case "-":

                if(!checkFirstNumber()) {
                    break;
                }

                if(!checkSecondNumber(operation)) {
                    break;
                }

                result = Calculator.subtraction(number1, number2);
                System.out.println(result);
                history.add(result);
                break;

            case "*":

                if(!checkFirstNumber()) {
                    break;
                }

                if(!checkSecondNumber(operation)) {
                    break;
                }

                result = Calculator.multiplication(number1, number2);
                System.out.println(result);
                history.add(result);
                break;

            case "^":

                if(!checkFirstNumber()) {
                    break;
                }

                if(!checkSecondNumber(operation)) {
                    break;
                }

                result = Calculator.exponentiation(number1, number2);
                System.out.println(result);
                history.add(result);
                break;

            case "/":

                if(!checkFirstNumber()) {
                    break;
                }

                if(!checkSecondNumber(operation)) {
                    break;
                }

                result = Calculator.division(number1, number2);
                System.out.println(result);
                history.add(result);
                break;

            case "sqrt":

                if(!checkFirstNumber()) {
                    break;
                }

                result = Calculator.sqrt(number1);
                System.out.println(result);
                history.add(result);
                break;

            default:
                System.out.println("You entered a wrong operation sign");
                break;

        }
    }
}
