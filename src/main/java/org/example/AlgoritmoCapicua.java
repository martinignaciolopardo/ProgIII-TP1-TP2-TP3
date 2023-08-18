package org.example;

/**
 * Ejercicio 9.
 * Implemente un algoritmo recursivo que verifique si una cadena de texto es palindroma
 * (capicua).
 */
public class AlgoritmoCapicua {
    private String palabra;

    public AlgoritmoCapicua(String palabra) {
        this.palabra = palabra;
    }

    public boolean esCapicua() {
        if (this.palabra.length() == 0) {
            return false;
        }

        return recursividad(this.palabra, 0, palabra.length()-1);
    }

    private boolean recursividad(String palabra, int indexInicio, int indexFin) {
        if (indexInicio >= indexFin) {
            return true;
        }
        if (palabra.charAt(indexInicio) != palabra.charAt(indexFin)) {
            return false;
        }
        return recursividad(palabra, indexInicio + 1, indexFin - 1);
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
