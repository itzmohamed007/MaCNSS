package com.macnss.helpers;

import java.util.Scanner;

public class ValidationHelper {
    private static Scanner scanner = new Scanner(System.in);

    public static int scannInt(){
        boolean validInput = false;
        int num = 0;
        do {
            String stringNum = scanner.next();
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
            String stringNum = scanner.next();
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
            String stringNum = scanner.next();
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
        return "";
    }

    public static String scannEmail() {
        return "";
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







}


