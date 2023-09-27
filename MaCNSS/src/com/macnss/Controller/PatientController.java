package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.PatientDAO;
import com.macnss.Model.Models.DTO.CnssForm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PatientController extends PatientDAO {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayHistory() {
        System.out.println("Enter your registration number: ");
        int registrationNumber = Integer.parseInt(scanner.next());
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
}