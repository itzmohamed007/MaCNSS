package com.macnss.Model.DAOimplementation;

import com.macnss.Model.DAO.DAO;
import com.macnss.Model.Database.DBConnection;
import com.macnss.Model.Models.DTO.CnssForm;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CnssFormDAO implements DAO<CnssForm> {
    @Override
    public List<CnssForm> get() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(CnssForm form) {
        String query = "INSERT INTO cnss_form (total_price, attachements_number, patient_number) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(query);
            preparedStatement.setFloat(1, form.getTotalPrice());
            preparedStatement.setInt(2, form.getAttachmentsNumber());
            preparedStatement.setInt(3, form.getPatientNumber());
            int rowCount = preparedStatement.executeUpdate();
            if(rowCount > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong while inserting new cnss form record");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Boolean update(CnssForm o) throws SQLException {
        return null;
    }

    @Override
    public Boolean delete(int id) throws SQLException {
        return null;
    }
}
