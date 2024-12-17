package com.example.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ProfesseurDAOImpl implements IProfesseurDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_professeurs";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    public List<Professeur> listAll() {
    List<Professeur> professeurs = new ArrayList<>();
    String query = "SELECT * FROM professeur";

    try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {

        while (resultSet.next()) {
            Professeur professeur = new Professeur(
                    resultSet.getInt("id"),
                    resultSet.getString("nom"),
                    resultSet.getString("specialite")
            );
            professeurs.add(professeur);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    System.out.println("Nombre de professeurs trouvés : " + professeurs.size());
    return professeurs;
}


    @Override
    public Professeur findById(int id) {
        String query = "SELECT * FROM professeur WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Professeur(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("specialite")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean add(Professeur professeur) {
        String query = "INSERT INTO professeur (nom, specialite) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, professeur.getNom());
            preparedStatement.setString(2, professeur.getSpecialite());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Professeur professeur) {
        String query = "UPDATE professeur SET nom = ?, specialite = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, professeur.getNom());
            preparedStatement.setString(2, professeur.getSpecialite());
            preparedStatement.setInt(3, professeur.getId());
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String query = "DELETE FROM professeur WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
