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

    public static void updateStatus() {
        System.out.println("You want to update an employee status");
    }
}
