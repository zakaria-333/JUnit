package com.example.exercice2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créer une instance de ProfesseurDAOImpl
        ProfesseurDAOImpl dao = new ProfesseurDAOImpl();

        // Tester la méthode listAll
        List<Professeur> professeurs = dao.listAll();

        // Vérifier et afficher les résultats
        if (professeurs.isEmpty()) {
            System.out.println("Aucun professeur trouvé dans la base de données.");
        } else {
            System.out.println("Liste des professeurs :");
            for (Professeur professeur : professeurs) {
                System.out.println(professeur);
            }
        }
    }
}

