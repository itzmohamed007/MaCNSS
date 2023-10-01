package com.macnss.helpers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidationHelper {
    private static Scanner stringScanner = new Scanner(System.in);
    private static Scanner otherScanner = new Scanner(System.in);
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$"; // email pattern

    public static int scannInt(){
        boolean validInput = false;
        int num = 0;
        do {
            String stringNum = otherScanner.next();
            // is integer
            if (isInteger(stringNum)) {
                num = Integer.parseInt(stringNum);
                return num;
            } else {
                System.out.println("Please enter a number:");
            }
        } while (!validInput);

        return num;
    }

    public static float scannFloat(){
        boolean validInput = false;
        float num = 0;
        do {
            String stringNum = otherScanner.next();
            // is float
            if (isFloat(stringNum)) {
                num = Float.parseFloat(stringNum);
                return num;
            } else {
                System.out.println("Please enter a number:");
            }
        } while (!validInput);

        return num;
    }

    public static int scannInt(int min, int max){
        boolean validInput = false;
        int num = 0;
        do {
            String stringNum = otherScanner.next();
            // is integer
            if (isInteger(stringNum)) {
                num = Integer.parseInt(stringNum);
                // is number fit inside available range
                if(num > max || num < min) {
                    System.out.println("Number out of range");
                    validInput = false;
                } else {
                    validInput = true;
                }
                return num;
            } else {
                System.out.println("Enter a valid number:");
            }
        } while (!validInput);

        return num;
    }

    public static String scannString () {
        return stringScanner.nextLine();
    }

    public static String scannEmail() {
        boolean validInput = false;
        String email = "";
        do {
            String input = stringScanner.next();
            if (isEmail(input)) {
                email = input;
                validInput = true;
            } else {
                System.out.println("Enter a valid email address");
            }
        } while (!validInput);

        return email;
    }

    public static LocalDate scannDate() {
        boolean validInput = false;
        LocalDate date = null;
        do {
            String dateString = otherScanner.next();
            try {
                date = LocalDate.parse(dateString);
                validInput = true;
            } catch (DateTimeParseException e) {
                System.out.println("Enter a valid date (yyyy-mm-dd)");
            }
        } while (!validInput);

        return date;
    }

    private static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isFloat(String string) {
        try {
            Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }
}


