package com.example.exercice3;

import java.util.List;

public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurDAO professeurDAO;

    public ProfesseurServiceImpl(ProfesseurDAO professeurDAO) {
        this.professeurDAO = professeurDAO;
    }

    @Override
    public Professeur enregistrer(int id, String nom, String specialite) {
        Professeur professeur = new Professeur();
        professeur.setNom(nom);
        professeur.setSpecialite(specialite);

        if (id == 0) {
            professeurDAO.addProfesseur(professeur);
        } else {
            professeur.setId(id);
            professeurDAO.updateProfesseur(professeur);
        }
        return professeur;
    }

    @Override
    public List<Professeur> chercherParNom(String nom) {
        return professeurDAO.findByNom(nom);
    }

    @Override
    public List<Professeur> chercherParSpecialite(String specialite) {
        return professeurDAO.findBySpecialite(specialite);
    }

    @Override
    public List<Professeur> getAll() {
        return professeurDAO.listAll();
    }

    @Override
    public void supprimer(int id) {
        professeurDAO.deleteProfesseur(id);
    }
}
