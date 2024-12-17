package exercice3;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import com.example.exercice3.Professeur;
import com.example.exercice3.ProfesseurDAO;
import com.example.exercice3.ProfesseurService;
import com.example.exercice3.ProfesseurServiceImpl;

import java.util.Arrays;
import java.util.List;

public class ProfesseurServiceImplTest {

    @Mock
    private ProfesseurDAO professeurDAO;

    private ProfesseurService professeurService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        professeurService = new ProfesseurServiceImpl(professeurDAO);
    }

    @Test
    public void testEnregistrerNouveauProfesseur() {
        Professeur professeur = new Professeur();
        professeur.setNom("Pierre Dupont");
        professeur.setSpecialite("Informatique");

        
        professeurService.enregistrer(0, "Pierre Dupont", "Informatique");

       
        verify(professeurDAO).addProfesseur(any(Professeur.class));
    }

    @Test
    public void testModifierProfesseurExistante() {
       
        Professeur professeur = new Professeur();
        professeur.setId(1);
        professeur.setNom("Marie Curie");
        professeur.setSpecialite("Physique");

    
        professeurService.enregistrer(1, "Marie Curie", "Physique");

      
        verify(professeurDAO).updateProfesseur(any(Professeur.class));
    }

    @Test
    public void testChercherParNom() {

        Professeur professeur1 = new Professeur();
        professeur1.setNom("Alice Johnson");
        Professeur professeur2 = new Professeur();
        professeur2.setNom("Alice Williams");

        when(professeurDAO.findByNom("Alice")).thenReturn(Arrays.asList(professeur1, professeur2));
        List<Professeur> result = professeurService.chercherParNom("Alice");
        assertEquals(2, result.size());
        verify(professeurDAO).findByNom("Alice");
    }

    @Test
    public void testChercherParSpecialite() {
        
        Professeur professeur1 = new Professeur();
        professeur1.setSpecialite("Mathématiques");
        Professeur professeur2 = new Professeur();
        professeur2.setSpecialite("Informatique");

        when(professeurDAO.findBySpecialite("Informatique")).thenReturn(Arrays.asList(professeur2));
        List<Professeur> result = professeurService.chercherParSpecialite("Informatique");

        
        assertEquals(1, result.size());
        verify(professeurDAO).findBySpecialite("Informatique");
    }

    @Test
    public void testGetAll() {
        
        Professeur professeur1 = new Professeur();
        professeur1.setNom("John Doe");

        when(professeurDAO.listAll()).thenReturn(Arrays.asList(professeur1));

        List<Professeur> result = professeurService.getAll();

        assertEquals(1, result.size());
        verify(professeurDAO).listAll();
    }

    @Test
    public void testSupprimer() {
        
        professeurService.supprimer(2);
        verify(professeurDAO).deleteProfesseur(2);
    }
}

