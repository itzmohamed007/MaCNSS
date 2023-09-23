package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.CnssFormDAO;
import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.Models.DTO.CnssForm;
import com.macnss.Model.Models.DTO.Patient;

import java.util.Scanner;

public class CnssFormController extends CnssFormDAO {
    private static Scanner scanner = new Scanner(System.in);
    private static CnssFormDAO formOp = new CnssFormDAO();
    public static void saveCnssForm() {
        System.out.println("Enter patient registration number: ");
        int registrationNumber = Integer.parseInt(scanner.next());
        Patient patient = PatientDAO.get(registrationNumber);
        if(patient != null) {
            CnssForm form = new CnssForm();
            form.setPatientNumber(patient.getRegistrationNumber()); // setting patient registration number from newly fetched record
            System.out.println("Patient account found: ");
            System.out.println(patient.toString()); // displaying patient data
            System.out.print("Enter total price: ");
            form.setTotalPrice(scanner.nextFloat());
            System.out.print("Enter attachments number: ");
            form.setAttachmentsNumber(scanner.nextInt());
            if(formOp.save(form)) {
                System.out.println("Reimbursement folder created successfully (for now, i'm not getting attachments data in order to calculate the final reimbursement price, later i'll do it, now i'm sleepy)");
            } else {
                System.out.println("Reimbursement folder creation failed");
            }
        } else {
            System.out.println("Patient account not found");
        }

    }
}
