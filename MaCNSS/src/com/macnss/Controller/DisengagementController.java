package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.DisengagementDAO;
import com.macnss.Model.Models.DTO.Disengagement;
import com.macnss.Model.Models.DTO.Patient;
import com.macnss.helpers.LocalStorage;
import com.macnss.helpers.ValidationHelper;

public class DisengagementController extends DisengagementDAO {
    private static Disengagement disengagement = new Disengagement();
    private static DisengagementDAO disengagementOp = new DisengagementDAO();

    public static void createDisengagement() {
        int patientId = Integer.valueOf((String) LocalStorage.getProperties().get("patient_id"));
        disengagement.setPatientNumber(Integer.valueOf(patientId));
        disengagement.setCompanyNumber(LocalStorage.getProperties().get("UUID").toString());
        System.out.println("Enter employee worked days: ");
        disengagement.setWorkedDays(ValidationHelper.scannInt());
        System.out.println("Enter employee current salary: ");
        disengagement.setSalary(ValidationHelper.scannFloat());
        System.out.println("Enter employee salary contribution: ");
        disengagement.setSalaryContribution(ValidationHelper.scannInt());

        if(disengagementOp.save(disengagement)) {
            System.out.println("Employee disengagement informations saved successfully");
        }
    }
}
