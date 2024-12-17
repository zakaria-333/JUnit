package exercice1;

import org.junit.jupiter.api.Test;

import com.example.exercice1.Factorial;

import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    @Test
    public void testFactorielPositive() {
        assertEquals(120, Factorial.factoriel(5), "Le factoriel de 5 doit être 120");
        assertEquals(1, Factorial.factoriel(0), "Le factoriel de 0 doit être 1");
    }

    @Test
    public void testFactorielNegative() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factoriel(-1), "Un nombre négatif doit lever une IllegalArgumentException");
    }

    @Test
    public void testFactorielTooLarge() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factoriel(21), "Un nombre trop grand doit lever une IllegalArgumentException");
    }
}


