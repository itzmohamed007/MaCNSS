package com.macnss.Controller;

import com.macnss.Controller.Services.CnssFormService;
import com.macnss.Controller.Services.EmailService;
import com.macnss.Model.DAOimplementation.CnssFormDAO;
import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.Models.DTO.CnssForm;
import com.macnss.Model.Models.DTO.Patient;
import com.macnss.Model.Models.DTO.RefundStatus;
import com.macnss.Model.Models.DoctorType;
import com.macnss.Model.Models.MedicalSummary;
import com.macnss.helpers.ValidationHelper;

import java.util.*;

public class CnssFormController extends CnssFormDAO {
    private static Scanner scanner = new Scanner(System.in);
    private static CnssFormDAO formOp = new CnssFormDAO(); // op stand for operations

    public static void saveCnssForm() {
        System.out.print("Enter patient registration number: ");
        int registrationNumber = ValidationHelper.scannInt();
        Patient patient = PatientDAO.get(registrationNumber);
        if(patient != null) {
            CnssForm form = new CnssForm();
            form.setPatientNumber(patient.getRegistrationNumber()); // setting patient registration number from newly fetched record
            System.out.print("Enter total price: ");
            form.setTotalPrice(ValidationHelper.scannFloat());
            // Scanning medicines
            System.out.print("Enter attached medicines number: ");
            int medicinesCount = ValidationHelper.scannInt(1, 5);
            ArrayList<String> medicineCodes = new ArrayList<>();
            for (int i = 0; i < medicinesCount; i++) {
                System.out.print("Enter medicine EAN code: ");
                medicineCodes.add(scanner.next());
            }
             // Scanning attachments
            System.out.print("Enter attachments number: ");
            form.setAttachmentsNumber(ValidationHelper.scannInt(1, 5));
            MedicalSummary[] attachments = new MedicalSummary[form.getAttachmentsNumber()]; // creating an array based on the number of documents entered by the agent
            for(int i = 0; i < form.getAttachmentsNumber(); i++) {
                MedicalSummary attachment = new MedicalSummary();
                System.out.println("Enter doctor's type: ");
                System.out.println("1. Generalist");
                System.out.println("2. Specialist");
                int doctorType = ValidationHelper.scannInt(1, 2);
                if(doctorType == 2)
                    attachment.setDoctorType(DoctorType.SPECIALIST);
                else
                    attachment.setDoctorType(DoctorType.GENERALIST);
                System.out.print("Enter visit price: ");
                float price = ValidationHelper.scannFloat();
                attachment.setPrice(price);
                attachments[i] = attachment;
            }
            if(formOp.save(form)) {
                float reimbursementPrice = CnssFormService.calcRefundAmount(medicineCodes, attachments);
                EmailService.sendEmail("Dear client, we would like to inform you that your Refund file was successfully created", "Refund File Creation", "itzmohamed007@gmail.com");
                System.out.println("Reimbursement folder created successfully");
                System.out.println("Base Reimbursement price: " + reimbursementPrice);
            } else {
                System.out.println("Reimbursement folder creation failed");
            }
        } else {
            System.out.println("Patient account not found");
        }
    }

    public static void updateCnssFormStatus() {
        System.out.print("Enter refund file id: ");
        int fileId = ValidationHelper.scannInt();
        CnssForm form = formOp.get(fileId); // Fetching form from db
        if(form != null) {
            Patient patient = PatientDAO.get(form.getPatientNumber()); // Fetching patient for his email address
            System.out.println("refund file found:");
            System.out.println("Patient registration number: " + form.getPatientNumber());
            System.out.println("File total price: " + form.getTotalPrice());
            System.out.println("File status: " + form.getStatus());
            System.out.println("Choose new status: ");
            System.out.println("1. Approved");
            System.out.println("2. Rejected");
            int choice = ValidationHelper.scannInt(1, 2);
            scanner.nextLine(); // Consume \n character
            String message = null;
            if(choice == 1) {
                System.out.print("Enter approval message for the user: ");
                message = scanner.nextLine();
                form.setStatus(RefundStatus.Approved);
            } else if(choice == 2) {
                System.out.println("Enter a rejection message for the patient: ");
                message = scanner.nextLine();
                form.setStatus(RefundStatus.Rejected);
            }
            // Sending email
            EmailService.sendEmail(message, "Refund File Status", patient.getAddress());
            if(formOp.update(form)) {
                System.out.println("Refund file status updated successfully");
            } else {
                System.out.println("Refund file updating failed");
            }
        } else
            System.out.println("Refund file not found");
    }
}
