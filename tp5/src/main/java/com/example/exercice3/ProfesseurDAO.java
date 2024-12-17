package com.example.exercice3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesseurDAO {

    private static Connection con;

    // Initialisation de la connexion
    static {
        try {
            String dbUrl = "jdbc:mysql://localhost:3306/your_database_name";
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, "root", "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Ajouter un professeur
    public void addProfesseur(Professeur professeur) {
        String sql = "INSERT INTO tblProfesseur(nom, specialite) VALUES(?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getSpecialite());
            ps.executeUpdate();

            // Récupérer l'ID généré
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                professeur.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Mettre à jour un professeur
    public void updateProfesseur(Professeur professeur) {
        String sql = "UPDATE tblProfesseur SET nom=?, specialite=? WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, professeur.getNom());
            ps.setString(2, professeur.getSpecialite());
            ps.setInt(3, professeur.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Supprimer un professeur
    public void deleteProfesseur(int id) {
        String sql = "DELETE FROM tblProfesseur WHERE id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Trouver un professeur par nom
    public List<Professeur> findByNom(String nom) {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM tblProfesseur WHERE nom LIKE ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nom + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNom(rs.getString("nom"));
                professeur.setSpecialite(rs.getString("specialite"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    // Trouver un professeur par spécialité
    public List<Professeur> findBySpecialite(String specialite) {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM tblProfesseur WHERE specialite LIKE ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + specialite + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNom(rs.getString("nom"));
                professeur.setSpecialite(rs.getString("specialite"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }

    // Récupérer tous les professeurs
    public List<Professeur> listAll() {
        List<Professeur> professeurs = new ArrayList<>();
        String sql = "SELECT * FROM tblProfesseur";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Professeur professeur = new Professeur();
                professeur.setId(rs.getInt("id"));
                professeur.setNom(rs.getString("nom"));
                professeur.setSpecialite(rs.getString("specialite"));
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }
}
