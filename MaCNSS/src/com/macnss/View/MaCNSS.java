package com.macnss.View;

import com.macnss.Controller.AdminController;
import com.macnss.Controller.AgentController;
import com.macnss.Controller.CnssFormController;
import com.macnss.Controller.PatientController;
import com.macnss.helpers.ValidationHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class MaCNSS {
    private static Scanner scanner = new Scanner(System.in);

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
                    System.out.println("Exiting the program");
                    System.exit(0);
                default:
                    System.out.println("Please enter a valid option");
                    break;
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
                    break;
            }
        }
    }

    private static void displayPatientDashboard() {
        PatientController.displayHistory();
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

    private static boolean loginAsAdmin() {
        return AdminController.login();
    }

    private static boolean loginAsAgent() {
//        return AgentController.login();
        return true;
    }
}
