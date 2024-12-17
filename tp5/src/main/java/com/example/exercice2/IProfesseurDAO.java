package com.example.exercice2;

import java.util.List;

public interface IProfesseurDAO {
    List<Professeur> listAll();
    Professeur findById(int id);
    boolean add(Professeur professeur);
    boolean update(Professeur professeur);
    boolean delete(int id);
}

