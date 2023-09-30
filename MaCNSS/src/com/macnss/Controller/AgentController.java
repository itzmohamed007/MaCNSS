package com.macnss.Controller;

import com.macnss.Controller.Services.EmailService;
import com.macnss.Model.DAOimplementation.AgentDAO;
import com.macnss.Model.Models.DTO.Agent;
import com.macnss.helpers.ValidationHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentController {
    private static Scanner scanner = new Scanner(System.in);
    private static AgentDAO agentOp = new AgentDAO();

    public static boolean login() {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (agentOp.login(email, password) != null) {
            String code = "2121"; // you'd better find a proper way for generating this code
            EmailService.sendEmail(code,"Authentication Code", email);
            System.out.print("An email has been sent to your email address, please enter recieved code: ");
            String codeFromAgent = scanner.nextLine();
            if(codeFromAgent.equals(code)){
                System.out.println("Welcome mr agent");
                return  true;
            } else {
                System.out.println("code entred is not correct");
            }
        } else {
            System.out.print("Wrong credentials, please enter 1 in order to repeat process: ");
            if(ValidationHelper.scannInt() == 1)
                return login();
            else
                System.out.println("Exiting");

        }
        return  false;
    }

    public static void saveAgent() {
        System.out.println("enter the email of agent");
        String email=scanner.nextLine();
        System.out.println("enter the password of agent");
        String password=scanner.nextLine();
        Agent agent = new Agent();
        agent.setEmail(email);
        agent.setPassword(password);
        AgentDAO agentDAO=new AgentDAO();
        if (agentDAO.save(agent)){
            System.out.println("Agent is added");
        }else {
            System.out.println("something was worng");
        }
    }

    public static void deleteAgent() {
        AgentDAO agentDAO=new AgentDAO();
        System.out.println("enter the id of agent");
        int id= ValidationHelper.scannInt();
        if (agentDAO.get(id) != null){
            if ( agentDAO.delete(id)){
                System.out.println("agent deleted");
            } else {
                System.out.println("something was wrong");
            }
        } else {
            System.out.println("no Agent with this id: " + id);
        }
    }
}
