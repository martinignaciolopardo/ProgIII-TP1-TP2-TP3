package org.example;

import java.util.ArrayList;
import java.util.Random;

public class SelectionAlgorithm {
   public static int quickselect(ArrayList<Integer> arr, int k) {
      if (arr.size() == 1) {
         return arr.get(0);
      } else {
         Random rand = new Random();
         int pivotIndex = rand.nextInt(arr.size());
         int pivot = arr.get(pivotIndex);

         ArrayList<Integer> lows = new ArrayList<Integer>();
         ArrayList<Integer> highs = new ArrayList<Integer>();
         ArrayList<Integer> pivots = new ArrayList<Integer>();

         for (int i = 0; i < arr.size(); i++) {
            int curr = arr.get(i);
            if (curr < pivot) {
               lows.add(curr);
            } else if (curr > pivot) {
               highs.add(curr);
            } else {
               pivots.add(curr);
            }
         }

         if (k < lows.size()) {
            return quickselect(lows, k);
         } else if (k < lows.size() + pivots.size()) {
            return pivots.get(0);
         } else {
            return quickselect(highs, k - lows.size() - pivots.size());
         }
      }
   }
}
