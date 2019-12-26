package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FractionCalculator {

    public static void main(String[] args) {
        Fraction[] fractions = new Fraction[2];
        Scanner scanner = new Scanner(System.in);

        fractions[0] = getFraction(scanner);
        fractions[1] = getFraction(scanner);
        String operation = getOperation(scanner);

        handleOperation(operation,fractions[0],fractions[1]);
    }

    private static void handleOperation(String operation, Fraction fraction, Fraction fraction1) {
        if ("+".equals(operation)){
           System.out.println(fraction.add(fraction1));
        }else if ("-".equals(operation)){
            System.out.println(fraction.subtract(fraction1));
        }else if ("*".equals(operation)){
            System.out.println(fraction.multiply(fraction1));
        }else if ("/".equals(operation)){
            System.out.println(fraction.divide(fraction1));
        }else if ("=".equals(operation)){
            System.out.println(fraction.equals(fraction1));
        }else {
            System.out.println("not a valid operation");
        }
    }

    private static Fraction getFraction(Scanner scanner) {
        Fraction fraction = null;
        while (fraction == null){
            System.out.print("please Enter valid fraction (a/b) or integer(a): ");
            String input = scanner.next();
            int[] numbers = parseInput(input);
            if (numbers != null){
                fraction =  makeFraction(numbers);
            }
        }
      return fraction;
    }

    private static Fraction makeFraction(int[] numbers){
        if (numbers[1] == 0){
            return new Fraction(numbers[0]);
        }else {
            return new Fraction(numbers[0], numbers[1]);
        }
    }

    private static int[] parseInput(String input){
        String[] string = input.split("/");
        int [] numbers = new int[2];

        if (string.length > 2 || string.length < 1){
            return null;
        }

        for (int i = 0; i < string.length; i++){
            if (isNumber(string[i])){
                numbers[i] = Integer.parseInt(string[i]);
            }else {
                return null;
            }
        }

        return numbers;
    }
    private static boolean isNumber(String string){
        try {
            Integer.parseInt(string);
            return true;
        }catch ( NumberFormatException e){
            System.err.println(string + " is not a valid number");
            return false;
        }
    }




    private static String getOperation(Scanner scanner){
        String operation = null;
        while (operation == null){
            System.out.print("Please enter an operation (+, -, *, /, = or Q to  quit): ");
            String input = scanner.next();
            operation =  isValidOperation(input.trim());
        }
        return operation;
    }

    public static String isValidOperation(String input){
        String[] validOperations = {"+", "-" , "*", "/", "=", "Q"};
        for (String operation : validOperations){
            if (operation.equals(input)){
                return operation;
            }
        }
        return null;
    }
}
