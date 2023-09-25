package com.macnss.Controller;

import com.macnss.Model.DAOimplementation.AgentDAO;
import com.macnss.Model.Models.DTO.Agent;
import com.macnss.helpers.VerificationHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentController {
    private static Scanner scanner = new Scanner(System.in);

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
        Agent agent=new Agent(agentDAO.getOne(id));
        if (agentDAO.getOne(id)==null){
            if (agentDAO.delete(id)){
                System.out.println("THE agent "+agent.getEmail()+" deleted");
            }else {
                System.out.println("something was worng");
            }

        }else{ System.out.println("no Agent with this id: ");}



    }
}
