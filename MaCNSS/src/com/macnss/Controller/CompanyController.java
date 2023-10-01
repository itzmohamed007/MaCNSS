package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.CompanyDAO;
import com.macnss.Model.Models.DTO.Company;
import com.macnss.Model.Models.DTO.CompanyType;
import com.macnss.helpers.LocalStorage;
import com.macnss.helpers.ValidationHelper;

public class CompanyController extends CompanyDAO {
    private static CompanyDAO companyOp = new CompanyDAO();
    private static Company company = new Company();

    public static void createCompanyAccount() {
        System.out.println("You want to create a company account");
        System.out.print("Enter company name: ");
        company.setName(ValidationHelper.scannString());
        System.out.println("Choose company type: ");
        System.out.println("1. Partnership");
        System.out.println("2. LLC");
        System.out.println("3. Corporation");
        int choice = ValidationHelper.scannInt(1, 3);
        if(choice == 1)
            company.setType(CompanyType.Partnership);
        else if(choice == 2)
            company.setType(CompanyType.LLC);
        else
            company.setType(CompanyType.Corporation);
        if(companyOp.save(company)) {
            System.out.println("Company account created successfully!");
        }
    }

    public static boolean login() {
        System.out.println("You want to login as a company");
        System.out.print("Enter company name: ");
        company.setName(ValidationHelper.scannString());
        System.out.print("Enter company registration number: ");
        company.setRegistrationNumber(ValidationHelper.scannString());
        if(companyOp.login(company)) {
            System.out.println("Loged in successfully");
            return true;
        } else {
            System.out.println("Wrong credentials, please enter 1 to try again");
            int choice = ValidationHelper.scannInt();
            if(choice == 1) {
                return login();
            }
        }
        return false;
    }
}
