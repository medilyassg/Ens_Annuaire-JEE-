package com.ens.dao;

import com.ens.util.DBUtil;
import com.ens.model.Filiere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FiliereDAO {

    public List<Filiere> getAllFilieres() throws SQLException {
        List<Filiere> filieres = new ArrayList<>();
        String sql = "SELECT * FROM filiere";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Filiere filiere = new Filiere();
                filiere.setId(rs.getInt("id"));
                filiere.setNom(rs.getString("name"));
                filiere.setIdDepartement(rs.getInt("department_id"));
                filieres.add(filiere);
            }
        }

        return filieres;
    }
    
    public void insertFiliere(Filiere filiere) throws SQLException {
        String sql = "INSERT INTO filiere (name, department_id) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filiere.getNom());
            stmt.setInt(2, filiere.getIdDepartement());
            stmt.executeUpdate();
        }
    }

    public void supprimerFiliere(int filiereId) throws SQLException {
        String sql = "DELETE FROM filiere WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, filiereId);
            stmt.executeUpdate();
        }
    }

}
