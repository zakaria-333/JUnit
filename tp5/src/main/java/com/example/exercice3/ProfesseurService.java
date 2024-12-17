package com.example.exercice3;

import java.util.List;

public interface ProfesseurService {

    Professeur enregistrer(int id, String nom, String specialite);

    List<Professeur> chercherParNom(String nom);

    List<Professeur> chercherParSpecialite(String specialite);

    List<Professeur> getAll();

    void supprimer(int id);
}

