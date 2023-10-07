package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.Models.DTO.CnssForm;
import com.macnss.Model.Models.DTO.Patient;
import com.macnss.helpers.LocalStorage;
import com.macnss.helpers.ValidationHelper;

import java.util.ArrayList;
import java.util.List;

public class PatientController extends PatientDAO {
    private static Patient patient = new Patient();
    private static PatientDAO patientOp = new PatientDAO();

    public static void save() {
        System.out.println("You want to create new patient account");
        System.out.print("Enter patient full name: ");
        patient.setFullName(ValidationHelper.scannString());
        System.out.print("Enter patient cin: ");
        patient.setCin(ValidationHelper.scannString());
        System.out.print("Enter patient email address: ");
        patient.setAddress(ValidationHelper.scannEmail());
        System.out.print("Enter patient birth date: ");
        patient.setBirthDate(ValidationHelper.scannDate());

        if(patientOp.save(patient)) {
            System.out.println("Patient created successfully");
        } else {
            System.out.println("Patient creation failed");
        }
    }

    public static void displayHistory() {
        int registrationNumber = Integer.valueOf((String) LocalStorage.getProperties().get("patient_registration_number"));
        List<CnssForm> forms = new ArrayList<>();
        forms = PatientDAO.getRefundFiles(registrationNumber);
        if(forms.size() != 0) {
            System.out.println("Refund files found: ");
            for(CnssForm form : forms) {
                System.out.println("Id: " + form.getId());
                System.out.println("Attachments number: " + form.getAttachmentsNumber());
                System.out.println("Total price: " + form.getTotalPrice() + " DH");
                System.out.println("Status: " + form.getStatus());
                if(forms.size() > 1)
                    System.out.println("============================");
            }
        } else {
            System.out.println("You have no refund files");
        }
    }

    public static void displayAll() {
        System.out.println("You want to display all employees");
        List<Patient> employees = patientOp.getAllEmployees((String) LocalStorage.getProperties().get("UUID"));
        for(Patient employee : employees) {
            System.out.println("Registration number: " + employee.getRegistrationNumber());
            System.out.println("Full name: " + employee.getFullName());
            System.out.println("Cin: " + employee.getCin());
            System.out.println("Address: " + employee.getAddress());
            System.out.println("Birth date: " + employee.getBirthDate());
            System.out.println("==================================");
        }
    }

    public static boolean login() {
        System.out.print("Enter your cin: ");
        String cin = ValidationHelper.scannString();
        Patient patient = patientOp.get(cin);
        if(patient != null) {
            LocalStorage.getProperties().setProperty("patient_cin", cin);
            LocalStorage.getProperties().setProperty("patient_registration_number", String.valueOf(patient.getRegistrationNumber()));
            LocalStorage.getProperties().setProperty("patient_birth_date", String.valueOf(patient.getBirthDate()));
            return true;
        } else {
            System.out.print("Account not found, please enter 1 to try again: ");
            int choice = ValidationHelper.scannInt();
            if(choice == 1) {
                return login();
            } else {
                System.out.println("Exit");
            }
        }
        return false;
    }
}