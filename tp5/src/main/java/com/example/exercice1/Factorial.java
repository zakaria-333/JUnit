package com.example.exercice1;

public class Factorial {
    public static int factoriel(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre doit être positif.");
        }
        if (n > 20) {
            throw new IllegalArgumentException("Le nombre est trop grand pour calculer le factoriel.");
        }
        if (n == 0) {
            return 1;
        }
        return n * factoriel(n - 1);
    }
}

