package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Company;
import com.macnss.Model.Models.DTO.CompanyType;
import com.macnss.helpers.LocalStorage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class CompanyDAO implements DAO<Company> {
    @Override
    public List<Company> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(Company company) {
        String query = "INSERT INTO company (registration_number, name, type) VALUES (?, ?, ?)";
        UUID uuid = UUID.randomUUID();
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getType().toString());
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                LocalStorage.getProperties().setProperty("UUID", uuid.toString());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while inserting new company record");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Company company) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }

    public Boolean login(Company company) {
        String query = "SELECT * FROM company WHERE registration_number = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, company.getRegistrationNumber());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                if(resultSet.getString("name").equals(company.getName())) {
                    // if authentication is successfull, store UUID in local storage
                    LocalStorage.getProperties().setProperty("UUID", company.getRegistrationNumber());
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while company authentication process");
            System.out.println(e.getMessage());
        }
        return false;
    }
}
