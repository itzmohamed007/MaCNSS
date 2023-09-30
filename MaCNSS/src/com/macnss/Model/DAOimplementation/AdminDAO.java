package com.macnss.Model.DAOimplementation;

import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Admin;
import com.macnss.Model.Models.DTO.Agent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDAO {

    public Admin login(String email ,String password) {
        Admin admin=null;
        String query = "select * from admin where email=? and password=?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2,password.hashCode());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                admin=new Admin(resultSet.getInt("admin_id"),resultSet.getString("email"),resultSet.getString("password"));
                return admin;
            }
            else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while login authentication process");
            System.out.println(e.getMessage());
        }
        return null;
    }



}
