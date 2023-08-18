package org.example;

import java.util.ArrayList;

/**
 * Ejercicio 10.
 * Implemente un algoritmo recursivo que determine si un arreglo de tamaño N está ordenado.
 *      1. ¿Qué complejidad big O tiene? (La complejidad en el peor caso) --> O(N)
 *      2. ¿Trae algún problema hacerlo recursivo? ¿Cuál? --> Ocupa mucho espacio en memoria
 *      3. ¿Qué cambiaría si la estructura fuera una lista en lugar de un arreglo? -->
 */
public class AlgoritmoArrayEstaOrdenado {

    private ArrayList<Integer> arr; // [1, 2, 3, 4]

    public AlgoritmoArrayEstaOrdenado(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public boolean estaOrdenado() {
        if (arr.isEmpty() || arr.size() == 1) {
            return true;
        }
        return recursividad(0);
    }

    // no estás retornando el valor de la llamada recursiva
    //
    //private boolean recursividad(int indexActual, int indexSiguiente) {
    //    if (indexActual < arr.size() - 2){
    //        if (arr.get(indexActual) < arr.get(indexSiguiente)){
    //            return recursividad(indexActual+1, indexSiguiente+1);
    //        }
    //        else{
    //            return false;
    //        }
    //    }
    //    return true;
    //}

    private boolean recursividad(int index) {
        if (index == arr.size() - 1) {
            return true;
        }
        if (arr.get(index) > arr.get(index + 1)) {
            return false;
        }
        return recursividad(index + 1);
    }
}