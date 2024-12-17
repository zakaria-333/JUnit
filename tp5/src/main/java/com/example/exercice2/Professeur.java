package com.example.exercice2;

import java.util.Objects;

public class Professeur {
    private int id;
    private String nom;
    private String specialite;

    public Professeur() {}

    public Professeur(int id, String nom, String specialite) {
        if (id < 0) {
            throw new IllegalArgumentException("L'ID ne peut pas être négatif.");
        }
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("L'ID ne peut pas être négatif.");
        }
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

    @Override
    public String toString() {
        return "Professeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", specialite='" + specialite + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professeur that = (Professeur) o;
        return id == that.id &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(specialite, that.specialite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, specialite);
    }
}