package com.macnss.Controller;

import com.macnss.Controller.Services.CnssFormService;
import com.macnss.Model.DAOimplementation.CnssFormDAO;
import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.Models.DTO.CnssForm;
import com.macnss.Model.Models.DTO.Patient;
import com.macnss.Model.Models.DoctorType;
import com.macnss.Model.Models.MedicalSummary;

import java.util.*;

public class CnssFormController extends CnssFormDAO {
    private static Scanner scanner = new Scanner(System.in);
    private static CnssFormDAO formOp = new CnssFormDAO(); // formOperations
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
            form.setTotalPrice(Float.parseFloat(scanner.next()));
            // Scanning medicines
            System.out.println("Enter attached medicines number: ");
            int medicinesCount = scanner.nextInt();
            ArrayList<String> medicineCodes = new ArrayList<>();
            for (int i = 0; i < medicinesCount; i++) {
                System.out.print("Enter medicine EAN code: ");
                medicineCodes.add(scanner.next());
            }
             // Scanning attachments
            System.out.print("Enter attachments number: ");
            form.setAttachmentsNumber(Integer.parseInt(scanner.next()));
            MedicalSummary[] attachments = new MedicalSummary[form.getAttachmentsNumber()]; // creating an array based on the number of documents entered by the agent
            for(int i = 0; i < form.getAttachmentsNumber(); i++) {
                MedicalSummary attachment = new MedicalSummary();
                System.out.println("Enter doctor's type: ");
                System.out.println("1. Generalist");
                System.out.println("2. Specialist");
                int doctorType = Integer.parseInt(scanner.next());
                if(doctorType == 2) {
                    attachment.setDoctorType(DoctorType.SPECIALIST);
                } else {
                    attachment.setDoctorType(DoctorType.GENERALIST);
                }
                System.out.print("Enter visit price: ");
                float price = Float.parseFloat(scanner.next());
                attachment.setPrice(price);
                attachments[i] = attachment;
            }
            if(formOp.save(form)) {
                float reimbursementPrice = CnssFormService.calcRefundAmount(medicineCodes, attachments);
                System.out.println("Reimbursement folder created successfully");
                System.out.println("Base Reimbursement price: " + reimbursementPrice);
            } else {
                System.out.println("Reimbursement folder creation failed");
            }
        } else {
            System.out.println("Patient account not found");
        }

    }
}
