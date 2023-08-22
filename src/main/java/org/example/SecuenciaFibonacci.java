package org.example;

import java.util.ArrayList;

public class SecuenciaFibonacci {

   public ArrayList<Integer> secuencia(){
      ArrayList<Integer> arreglo = new ArrayList<>();
      arreglo.add(0);
      arreglo.add(1);
      return armarSecuencia(arreglo);
   }

   private ArrayList<Integer> armarSecuencia(ArrayList<Integer> arreglo){
      int ultimo = arreglo.get(arreglo.size()-1);
      int anteUltimo = arreglo.get(arreglo.size()-2);
      int nuevoNumero = ultimo + anteUltimo;
      if (nuevoNumero <= 5) {
         arreglo.add(ultimo + anteUltimo);
         return armarSecuencia(arreglo);
      }
      else {
         return arreglo;
      }
   }
}
