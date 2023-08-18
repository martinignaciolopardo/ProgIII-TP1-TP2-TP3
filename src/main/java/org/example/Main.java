package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static org.example.BubbleSortAlgorithm.bubbleSort;
import static org.example.SelectionAlgorithm.quickselect;

public class Main {
   public static void main(String[] args) {

      MySimpleLinkedList list = new MySimpleLinkedList<>();
      list.insertFront(1);
      list.insertFront(2);
      list.insertFront(3);

      Iterator<Integer> iterator = list.iterator();

      while(iterator.hasNext()){
         System.out.println(iterator.next());
      }

      //Pila p = new Pila();
      //p.push(1);
      //p.push(2);
      //p.push(3);
      //p.toString();

      ArrayList<Integer> arr = new ArrayList<Integer>();
      arr.add(3);
      arr.add(5);
      arr.add(1);
      arr.add(2);
      arr.add(6);
      arr.add(8);
      arr.add(7);
      arr.add(4);
      System.out.println("original array:");
      System.out.println(arr);
      System.out.println("Selection sort:");

      int n = arr.size();
      for (int k = 1; k <= n; k++) {
         int kthSmallest = quickselect(arr, k);
         ArrayList<Integer> sorted = new ArrayList<Integer>(arr);
         sorted.sort(null);
         System.out.println("k = " + k + ": " + Arrays.toString(sorted.toArray()) + " -> " + kthSmallest);
      }

      System.out.println("---");
      System.out.println("Bubble sort:");

      System.out.println(bubbleSort(arr));

   }
}
