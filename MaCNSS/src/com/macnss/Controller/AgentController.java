package com.macnss.Controller;

import com.macnss.Controller.Services.EmailService;
import com.macnss.Model.DAOimplementation.AgentDAO;
import com.macnss.Model.Models.DTO.Agent;
import com.macnss.helpers.VerificationHelper;
import java.util.Random;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentController {
    private static Scanner scanner = new Scanner(System.in);
    private  static  AgentDAO agent=new AgentDAO();

    public  static boolean login() throws SQLException {
        System.out.println("enter your email");
        String email = scanner.nextLine();
        System.out.println("enter your password");
        String password = scanner.nextLine();
        if (agent.login(email,password)!= null) {
            String code = "2121";
            EmailService.sendEmail(code,"your code",email);
            System.out.println("chek your email");
            System.out.println("insert code");
            String codeFromAgent=scanner.nextLine();
            System.out.println("condition result below: ");
            if(codeFromAgent.equals(code)){
                System.out.println("welcome agent");
                return  true;
            } else {
                System.out.println("code entred is not correct");
            }
        }else {
            System.out.println("try again");
        }
        return  false;
    }


    public static void saveAgent() throws SQLException {
        System.out.println("enter the email of agent");
        String email=scanner.nextLine();
        System.out.println("enter the password of agent");
        String password=scanner.nextLine();
        Agent agent=new Agent();
        agent.setEmail(email);
        agent.setPassword(password);
        AgentDAO agentDAO=new AgentDAO();
        if (agentDAO.save(agent)){
            System.out.println("Agent is added");
        }else {
            System.out.println("something was worng");
        }
    }

    public static void deleteAgent() throws SQLException {
        AgentDAO agentDAO=new AgentDAO();
        System.out.println("enter the id of agent");
        int id= VerificationHelper.checkInt();
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
