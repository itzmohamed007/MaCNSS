package com.macnss.View;

import com.macnss.Controller.*;
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
                if(loginAsCompany())
                    displayCompanyDashboard();
                break;
            case 4:
                displayPatientDashboard();
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
        System.out.println("3. Display Company Dashboard");
        System.out.println("4. Display Patient Dashboard");
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
                case 3:
                    CompanyController.createCompanyAccount();
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
                    PatientController.save(); // Creating new employee, should be updated to check if employee is already registred in CNSS
                    DisengagementController.createDisengagement(); // Linking disengagement informations to newly created employee
                    break;
                case 2:
                    DisengagementController.updateStatus();
                    break;
                case 3:
                    PatientController.displayAll();
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
        System.out.println("3. Create Company account");
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
        System.out.println("1. Create an account for an employee");
        System.out.println("2. Update employee status");
        System.out.println("3. Display all imployees");
        System.out.println("0. Exit");

        return ValidationHelper.scannInt();
    }

    private static boolean loginAsAdmin() {
        return AdminController.login();
    }

    private static boolean loginAsAgent() {
//        return AgentController.login();
        return true;
    }

    private static boolean loginAsCompany() {
        return CompanyController.login();
    }
}
