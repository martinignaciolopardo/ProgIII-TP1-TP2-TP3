package org.example;

import java.util.ArrayList;

public class BubbleSortAlgorithm {
   public static ArrayList<Integer> bubbleSort(ArrayList<Integer> arr){
      int aux = 0;
      for (int i = 0; i < arr.size() -1; i++) {
         for (int j = 1; j < arr.size() - 1; j++) {
            if (arr.get(i) > arr.get(j)){
               aux = arr.get(j);
               arr.set(j, arr.get(i));
               arr.set(i, aux);
            }
         }
      }

      return arr;
   }
}
