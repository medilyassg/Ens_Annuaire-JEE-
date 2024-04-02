package com.ens.dao;

import com.ens.model.Departement;
import com.ens.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementDAO {

    public List<Departement> getAllDepartements() throws SQLException {
        List<Departement> departements = new ArrayList<>();
        String sql = "SELECT * FROM departement";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Departement departement = new Departement();
                departement.setId(rs.getInt("id"));
                departement.setNom(rs.getString("name"));
                departements.add(departement);
            }
        }

        return departements;
    }
    
    public void insertDepartement(Departement filiere) throws SQLException {
        String sql = "INSERT INTO departement (name, id) VALUES (?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, filiere.getNom());
            stmt.setInt(2, filiere.getId());
            stmt.executeUpdate();
        }
    }

    public void supprimerDepartement(int filiereId) throws SQLException {
        String sql = "DELETE FROM filiere WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, filiereId);
            stmt.executeUpdate();
        }
    }

}
