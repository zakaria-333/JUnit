package exercice2;

import org.junit.jupiter.api.Test;

import com.example.exercice2.Professeur;

import static org.junit.jupiter.api.Assertions.*;

public class ProfesseurTest {

    @Test
    public void testProfesseurWithNegativeId() {
        assertThrows(IllegalArgumentException.class, () -> new Professeur(-1, "Dupont", "Mathématiques"), 
                     "L'ID ne peut pas être négatif.");
    }

    @Test
    public void testSetIdWithNegativeValue() {
        Professeur professeur = new Professeur(1, "Durand", "Physique");
        assertThrows(IllegalArgumentException.class, () -> professeur.setId(-5), 
                     "L'ID ne peut pas être négatif.");
    }

    @Test
    public void testGettersAndSetters() {
        Professeur professeur = new Professeur();
        professeur.setId(1);
        professeur.setNom("Dupont");
        professeur.setSpecialite("Mathématiques");

        assertEquals(1, professeur.getId());
        assertEquals("Dupont", professeur.getNom());
        assertEquals("Mathématiques", professeur.getSpecialite());
    }

    @Test
    public void testDefaultConstructor() {
        Professeur professeur = new Professeur();
        assertNotNull(professeur);
        assertEquals(0, professeur.getId());
        assertNull(professeur.getNom());
        assertNull(professeur.getSpecialite());
    }

    @Test
    public void testConstructorWithArguments() {
        Professeur professeur = new Professeur(1, "Dupont", "Mathématiques");
        assertEquals(1, professeur.getId());
        assertEquals("Dupont", professeur.getNom());
        assertEquals("Mathématiques", professeur.getSpecialite());
    }

    @Test
    public void testEqualsAndHashCode() {
        Professeur p1 = new Professeur(1, "John Doe", "Mathématiques");
        Professeur p2 = new Professeur(1, "John Doe", "Mathématiques");
        Professeur p3 = new Professeur(2, "Jane Doe", "Informatique");

        assertEquals(p1, p2, "Les deux professeurs doivent être égaux");
        assertNotEquals(p1, p3, "Les professeurs doivent être différents");

        assertEquals(p1.hashCode(), p2.hashCode(), "Les hashcodes doivent être égaux pour les objets égaux");
        assertNotEquals(p1.hashCode(), p3.hashCode(), "Les hashcodes doivent être différents pour les objets différents");
    }

    @Test
    public void testToString() {
        Professeur professeur = new Professeur(1, "Dupont", "Mathématiques");
        String expected = "Professeur{id=1, nom='Dupont', specialite='Mathématiques'}";
        assertEquals(expected, professeur.toString());
    }
}
