package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Disengagement;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DisengagementDAO implements DAO<Disengagement> {
    @Override
    public List<Disengagement> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(Disengagement disengagement) {
        String query = "INSERT INTO disengagement (patient_number, company_number, worked_days, salary, salary_contribution) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, disengagement.getPatientNumber());
            preparedStatement.setString(2, disengagement.getCompanyNumber());
            preparedStatement.setInt(3, disengagement.getWorkedDays());
            preparedStatement.setFloat(4, disengagement.getSalary());
            preparedStatement.setInt(5, disengagement.getSalaryContribution());
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("somthing went wrong while inserting new disengagement record");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(Disengagement disengagement) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }
}
