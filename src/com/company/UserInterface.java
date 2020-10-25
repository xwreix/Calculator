package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private static ArrayList<String> history = new ArrayList<String>();

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
            } else if (choice == 0)
                System.out.println(history);
            else
                System.out.println("You entered a wrong key");
            System.out.println("Do you wanna continue? (1-yes, 0 - no)");
            key = in.nextInt();
        }
        in.close();
    }

    public static void operationSelection(String operation) {

        Scanner in = new Scanner(System.in);

        switch (operation) {
            case "+":
            case "-":
            case "*":
            case "^":
            case "/":
                System.out.println("The first number: ");
                String number1 = in.nextLine();
                System.out.println("The second number: ");
                String number2 = in.nextLine();

                try {
                    Calculator.dataStandardInput(number1, number2);
                } catch (NotNumberException ex) {
                    System.out.println(ex.getMessage());
                    history.add(number1 + operation + number2 + "=" + ex.getMessage());
                    break;
                }

                double num1, num2;
                num1 = Double.parseDouble(number1);
                num2 = Double.parseDouble(number2);
                String result = "";

                switch (operation) {
                    case "+":
                        result = Calculator.addition(num1, num2);
                        break;
                    case "-":
                        result = Calculator.subtraction(num1, num2);
                        break;
                    case "*":
                        result = Calculator.multiplication(num1, num2);
                        break;
                    case "^":
                        result = Calculator.exponentiation(num1, num2);
                        break;
                    case "/":
                        try {
                            Calculator.divisionCheck(num2);
                            result = Calculator.division(num1, num2);
                        } catch (ArithmeticException ex) {
                            System.out.println(ex.getMessage());
                            result = number1 + "/" + number2 + "=" + ex.getMessage();
                        }
                        break;
                }
                history.add(result);
                break;
            case "sqrt":
                System.out.println("Enter the number: ");
                String number = in.nextLine();
                try {
                    Calculator.sqrtCheck(number);
                } catch (NotNumberException ex) {
                    System.out.println(ex.getMessage());
                    history.add("sqrt of"+number+"="+ex.getMessage());
                    break;
                } catch (ArithmeticException ex) {
                    System.out.println(ex.getMessage());
                    history.add("sqrt of "+number+"="+ex.getMessage());
                    break;
                }
                history.add(Calculator.sqrt(number));
                break;
            default:
                System.out.println("You entered a wrong operation sign");
                break;
        }
    }
}
