package com.macnss.Controller;

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
            int medicinesCount = scanner.nextInt(), i = 0;
            Map<String, Float> medicines = new HashMap();
            while (medicinesCount > i) {
                System.out.print("Enter medicine EAN code: ");
                String code = scanner.next();
                System.out.print("Enter medicine price: ");
                float price = Float.parseFloat(scanner.next());
                medicines.put(code, price);
                i++;
            }
            System.out.println("Medicines inserted successfully!");
             // Scanning attachments
            System.out.print("Enter attachments number: ");
            form.setAttachmentsNumber(Integer.parseInt(scanner.next()));
            MedicalSummary[] attachments = new MedicalSummary[form.getAttachmentsNumber()]; // creating an array based on the number of documents entered by the agent
            i = 0; // re-initializing loop counter to 0
            while (form.getAttachmentsNumber() > i) {
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
                i++;
            }
            System.out.println("Attachments inserted successfully!");
            System.out.println("Here are all the inserted medicines");
//            for (Map.Entry<String, Float> entry : medicines.entrySet()) {
//                String key = entry.getKey();
//                float value = entry.getValue();
//                System.out.println(key + ": " + value);
//            }
//            System.out.println("Here are all the attached documents");
//            for(MedicalSummary document : attachments) {
//                System.out.println("Doctor type: " + document.getDoctorType());
//                System.out.println("Price: " + document.getPrice());
//            }
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
