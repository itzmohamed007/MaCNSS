package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.AdminDAO;
import com.macnss.Model.Models.DTO.Admin;
import com.macnss.helpers.ValidationHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminController {
   private static AdminDAO adminOp = new AdminDAO(); // op stand for operations, in this case, just authentification

    public static boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (adminOp.login(email, password) != null) {
            return true;
        } else {
            System.out.println("Wrong credentials, enter 1 to repeat process");
            int choice = ValidationHelper.scannInt();
            if(choice == 1)
                return login();
            else
                System.out.println("Exiting");
            return false;
        }
    }
}
