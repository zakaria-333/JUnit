package exercice2;

import org.junit.jupiter.api.Test;

import com.example.exercice2.Professeur;
import com.example.exercice2.ProfesseurDAOImpl;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProfesseurDAOImplTest {

    private final ProfesseurDAOImpl dao = new ProfesseurDAOImpl();

    @Test
    public void testListAll() {
        List<Professeur> professeurs = dao.listAll();
        assertNotNull(professeurs);
        assertTrue(professeurs.size() > 0);
    }

    @Test
    public void testFindById() {
        Professeur professeur = dao.findById(3);
        assertNotNull(professeur);
        assertEquals(3, professeur.getId());
    }

    @Test
    public void testAdd() {
        Professeur professeur = new Professeur(0, "Test Nom", "Test Specialite");
        boolean result = dao.add(professeur);
        assertTrue(result);
    }

    @Test
    public void testUpdate() {
        Professeur professeur = dao.findById(4);
        assertNotNull(professeur);
        professeur.setNom("Nom Modifie");
        boolean result = dao.update(professeur);
        assertTrue(result);
    }

    @Test
    public void testDelete() {
        boolean result = dao.delete(2);
        assertTrue(result);
    }
}
