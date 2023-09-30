package com.macnss.View;

import com.macnss.Controller.AdminController;
import com.macnss.Controller.AgentController;
import com.macnss.Controller.CnssFormController;
import com.macnss.Controller.PatientController;
import com.macnss.helpers.ValidationHelper;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.zip.Deflater;

public class MaCNSS {
    public static void startProject() {
        int choice = displayDashboards();
        switch (choice) {
            case 1:
                if(loginAsAdmin())
                    displayAdminDashboard();
                break;
            case 2:
                if(loginAsAgent())
                    displayAgentDashboard();
                break;
            case 3:
                displayPatientDashboard();
                break;
            case 4:
                displayCompanyDashboard();
                break;
            case 0:
                System.out.println("Exiting the program");
                System.exit(0);
            default:
                System.out.println("Invalid option");
        }
    }

    private static int displayDashboards() {
        System.out.println("1. Display Admin Dashboard");
        System.out.println("2. Display Agent Dashboard");
        System.out.println("3. Display Patient Dashboard");
        System.out.println("4. Display Company Dashboard");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static void displayAdminDashboard() {
        while (true) {
            switch (adminMenu()) {
                case 1:
                     AgentController.saveAgent();
                    break;
                case 2:
                    AgentController.deleteAgent();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }

    private static void displayAgentDashboard() {
        while (true) {
            switch (agentMenu()) {
                case 1:
                    CnssFormController.saveCnssForm();
                    break;
                case 2:
                    CnssFormController.updateCnssFormStatus();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }

    private static void displayPatientDashboard() {
        while (true) {
            switch (patientMenu()) {
                case 1: {
                    PatientController.displayHistory();
                    break;
                }
                case 2: {
                    System.out.println("You want to display your disengagement status");
                    break;
                }
                case 0:
                    System.exit(1);
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        }
    }

    private static void displayCompanyDashboard() {
        while (true) {
            switch (companyMenu()) {
                case 1:
                    System.out.println("You want to create a company account");
                    break;
                case 2:
                    System.out.println("You want to login to company account");
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("Please enter a valid option");
            }
        }
    }

    private static int adminMenu() {
        System.out.println("Welcome Mr Admin");
        System.out.println("1. Create new agent account");
        System.out.println("2. Delete old agent account");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static int agentMenu() {
        System.out.println("You want to display agent dashboard");
        System.out.println("1. Create new Reimbursement folder");
        System.out.println("2. Update Reimbursement folder status");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static int patientMenu() {
        System.out.println("You want to display agent dashboard");
        System.out.println("1. Display historique");
        System.out.println("2. Display disengagement status");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static int companyMenu() {
        System.out.println("You want to display company dashboard");
        System.out.println("1. Create an account");
        System.out.println("2. Login");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static boolean loginAsAdmin() {
        return AdminController.login();
    }

    private static boolean loginAsAgent() {
        return AgentController.login();
    }
}
