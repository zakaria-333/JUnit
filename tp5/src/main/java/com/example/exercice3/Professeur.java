package com.example.exercice3;

import java.util.Objects;

public class Professeur {
    private int id;
    private String nom;
    private String specialite;

    // Constructeur par défaut
    public Professeur() {}

    // Constructeur avec arguments
    public Professeur(int id, String nom, String specialite) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    // Méthode toString
    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }

    // Méthode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professeur that = (Professeur) o;
        return id == that.id && Objects.equals(nom, that.nom) && Objects.equals(specialite, that.specialite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, specialite);
    }
}