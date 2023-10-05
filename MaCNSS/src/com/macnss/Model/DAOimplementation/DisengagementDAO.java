package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.Disengagement;
import com.macnss.Model.Models.DTO.EmployeeStatus;
import com.macnss.Model.Models.DTO.RefundStatus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DisengagementDAO implements DAO<Disengagement> {
    public Boolean retireEmployee(String cin, float retirementSalary) {
        String query = "UPDATE disengagement SET company_number = (SELECT registration_number FROM company WHERE name = ?), salary = ?, salary_contritubtion = NULL, status = ? WHERE patient_number = (SELECT registration_number FROM patient WHERE cin = ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, "Country");
            preparedStatement.setFloat(2, retirementSalary);
            preparedStatement.setString(3, "retired");
            preparedStatement.setString(4, cin);
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while updating employee");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Disengagement checkEmployeePresence(String cin) {
        String query = "SELECT * FROM disengagement WHERE patient_number IN (SELECT registration_number FROM patient WHERE cin = ?)";
        Disengagement employee = null;
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, cin);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                employee = new Disengagement();
                employee.setPatientNumber(resultSet.getInt("patient_number"));
                employee.setCompanyNumber(resultSet.getString("company_number"));
                employee.setWorkedDays(resultSet.getInt("work_days"));
                employee.setSalary(resultSet.getFloat("salary"));
                employee.setSalaryContribution(resultSet.getInt("salary_contribution"));
                employee.setStatus(EmployeeStatus.valueOf(resultSet.getString("status")));
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while searching employee");
            System.out.println(e.getMessage());
        }
        return employee;
    }

    public Boolean offboardEmployee(String cin) {
        String query = "UPDATE disengagement SET company_number = (SELECT registration_number FROM company WHERE name = ?), salary = null, salary_contribution = null, status = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setString(1, "Country"); // setting company name to default which is the country
            preparedStatement.setString(2, "pending");
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while updating employee status");
            System.out.println(e.getMessage());
        }
        return false;
    }

    public Boolean updateWorkDays(String employeeCin, int workDays, boolean increment) {
        String query = "UPDATE disengagement JOIN patient ON disengagement.patient_number = patient.registration_number SET disengagement.worked_days = worked_days - ? WHERE patient.cin = ?";
        if(increment)
            query = "UPDATE disengagement JOIN patient ON disengagement.patient_number = patient.registration_number SET disengagement.worked_days = worked_days + ? WHERE patient.cin = ?";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setInt(1, workDays);
            preparedStatement.setString(2, employeeCin);
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while updating employee work days");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Disengagement> getAll() {
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
