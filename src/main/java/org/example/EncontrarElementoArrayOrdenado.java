package org.example;

import java.util.ArrayList;

public class EncontrarElementoArrayOrdenado {
   private ArrayList<Integer> arr; // 1 2 3 4 5 6   2,0

   public Integer encontrarElemento(){
      int inicio = 0;
      int fin = arr.size();
      int valor = 5;

      return encontrar(valor, inicio, fin);

   }

   private Integer encontrar(Integer valor, int inicio, int fin){
      if (inicio > fin){
         return -1;
      }
      int medio = (inicio + fin) / 2;
      if (arr.get(medio) == valor){
         return arr.get(medio);
      }
      else if (arr.get(medio) < valor){
         return encontrar(valor, medio +1, fin);
      }
      else {
         return encontrar(valor, inicio, medio-1);
      }
   }

   public Integer findElement(int valor, int index){
      int medio = (arr.size()/2)+1;

      if(valor<=medio){
         return findElementIzq(valor, medio);
      }else{
         return findElementDer(valor, medio);
      }
   }

   private Integer findElementIzq(int valor, int index){

      if (arr.get(index) == valor){
         return index;
      }

      if (arr.get(index) != valor && index>=0){
         return findElementIzq(valor, index--);
      }

      return null;
   }

   private Integer findElementDer(int valor, int index){

      if (arr.get(index) == valor){
         return index;
      }

      if (arr.get(index) != valor && index< arr.size()){
         return findElementIzq(valor, index++);
      }

      return null;
   }

}
