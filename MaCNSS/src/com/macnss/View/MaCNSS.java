package com.macnss.View;

import java.util.Scanner;

public class MaCNSS {
    public static void startProject() {
        System.out.println("Welcome to MaCNSS");
        int choice;
        do {
            choice = displayMenu();
            switch (choice) {
                case 1:
                    System.out.println("You want to display admin dashboard");
                    break;
                case 2:
                    System.out.println("You want to display agent dashboard");
                    break;
                case 3:
                    System.out.println("You want to display patient history");
                    break;
                case 4:
                    System.out.println("You want to exit");
                default:
                    System.out.println("Please enter a available option");
                    break;
            }
        } while (choice != 4);
    }

    private static int displayMenu() {
        System.out.println("1. Display Admin Dashboard");
        System.out.println("2. Display Agent Dashboard");
        System.out.println("3. Display Patient History");
        System.out.println("4. Exit");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if(!isInteger(choice)) {
            System.out.println("Please enter a number");
            return displayMenu();
        }
        return Integer.parseInt(choice);
    }

    private static boolean isInteger(String string) {
        boolean res = false;
        try {
            Integer.parseInt(string);
            res = true;
        } catch (NumberFormatException e) {
            res = false;
        }
        return res;
    }
}
