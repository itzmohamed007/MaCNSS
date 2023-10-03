package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.DisengagementDAO;
import com.macnss.Model.Models.DTO.Disengagement;
import com.macnss.Model.Models.DTO.EmployeeStatus;
import com.macnss.helpers.LocalStorage;
import com.macnss.helpers.ValidationHelper;

public class DisengagementController extends DisengagementDAO {
    private static Disengagement disengagement = new Disengagement();
    private static DisengagementDAO disengagementOp = new DisengagementDAO();

    public static void createDisengagement() {
        disengagement.setPatientNumber(Integer.valueOf((String) LocalStorage.getProperties().get("patient_id")));
        disengagement.setCompanyNumber(LocalStorage.getProperties().get("UUID").toString());
        System.out.println("Enter employee current salary: ");
        disengagement.setSalary(ValidationHelper.scannFloat());
        System.out.println("Enter employee salary contribution: ");
        disengagement.setSalaryContribution(ValidationHelper.scannInt());

        if(disengagementOp.save(disengagement)) {
            System.out.println("Employee disengagement informations saved successfully");
        }
    }

    public static void retireEmployee() {
        System.out.println("You want to retire an employee");
    }

    public static void updateWorkDays() {
        System.out.println("You want to update employee work days");
        System.out.println("Choose how you want to update employee work days: ");
        System.out.println("1. Increment");
        System.out.println("2. Decrement");
        int daysCount = 0;
        switch (ValidationHelper.scannInt(1, 2)) {
            case 1:
                System.out.print("Enter how many days you want to add: ");
                daysCount = ValidationHelper.scannInt(1, 10);
                break;
            case 2:
                System.out.print("Enter how many days you want to remove: ");
                daysCount = ValidationHelper.scannInt(1, 10);
                break;
        }

    }

    public static void offbordEmployee() {
        System.out.println("You want to offboard an employee");
    }
}