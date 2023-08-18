package org.example;

import java.util.Iterator;

public class MyDoubleLinkedList<T> implements Iterable<T> {
   private NodeDouble<T> first;
   private int size;

   public MyDoubleLinkedList() {
      this.first = null;
      this.size = 0;
   }

   public void insertFront(T info) {
      NodeDouble<T> tmp = new NodeDouble<T>(info, null, null);
      if (this.first != null){
         this.first.setPrev(tmp);
         tmp.setNext(this.first);
      }
      this.first = tmp;
      this.size += 1;
   }

   public T extractFront() {
      NodeDouble<T> extractedNode = this.first;
      this.first = extractedNode.getNext();
      if (this.first != null){
         this.first.setPrev(null);
      }
      this.size -= 1;
      return extractedNode.getInfo();
   }

   public boolean isEmpty() {
      return (this.first == null);
   }

   public T get(int index) {
      if (index < 0 || index >= this.size()) {
         throw new IndexOutOfBoundsException("Index is out of bounds");
      }
      int currentIndex = 0;
      NodeDouble<T> currentNode  = this.first;

      while (currentIndex < index) {
         currentNode = currentNode.getNext();
         currentIndex++;
      }
      return currentNode.getInfo();
   }

   public int size() {
      return this.size;
   }

   @Override
   public String toString() {
      if (this.first != null) {
         String response = "";
         NodeDouble<T> temp = this.first;
         while (temp.getNext() != null) {
            response += temp.getInfo() + " - ";
            temp = temp.getNext();
         }
         response += temp.getInfo();
         return response;
      }
      return "Lista vacia";
   }

   @Override
   public Iterator<T> iterator() {
      return new MyIteratorDouble<T>(this.first);
   }

   public int indexOf(T info) {
      NodeDouble<T> temp = this.first;
      for (int i = 0; i < this.size(); i++) {
         if (temp.getInfo() == info) {
            return i;
         }
         else {
            temp = temp.getNext();
         }
      }
      return -1;
   }

   public static <T> MyDoubleLinkedList<T> findCommonElements(MyDoubleLinkedList<T> list1, MyDoubleLinkedList<T> list2) {
      MyDoubleLinkedList<T> commonList = new MyDoubleLinkedList<>();

      for (T element : list1) {
         if (list2.contains(element)) {
            commonList.insertFront(element);
         }
      }

      return commonList;
   }
   // 2 3 7 9
   // 7 9 11 15
   public boolean contains(T element) {
      NodeDouble<T> current = this.first;
      while (current != null) {
         if (current.getInfo().equals(element)) {
            return true;
         }
         current = current.getNext();
      }
      return false;
   }

   public <T extends Comparable<T>> MyDoubleLinkedList<T> mergeCommonElements(MyDoubleLinkedList<T> list1, MyDoubleLinkedList<T> list2) {
      MyDoubleLinkedList<T> commonList = new MyDoubleLinkedList<>();

      Iterator<T> iterator1 = list1.iterator();
      Iterator<T> iterator2 = list2.iterator();

      T element1 = null;
      T element2 = null;

      if (iterator1.hasNext()) {
         element1 = iterator1.next();
      }

      if (iterator2.hasNext()) {
         element2 = iterator2.next();
      }
      // 2 3 7 9
      // 7 9 11 15
      while (element1 != null && element2 != null) {
         int comparison = element1.compareTo(element2);

         if (comparison == 0) {
            commonList.insertFront(element1);
            element1 = iterator1.hasNext() ? iterator1.next() : null;
            element2 = iterator2.hasNext() ? iterator2.next() : null;
         } else if (comparison < 0) {
            element1 = iterator1.hasNext() ? iterator1.next() : null;
         } else {
            element2 = iterator2.hasNext() ? iterator2.next() : null;
         }
      }

      return commonList;
   }

   public static <T> MyDoubleLinkedList<T> findDifferentElements(MyDoubleLinkedList<T> list1, MyDoubleLinkedList<T> list2) {
      MyDoubleLinkedList<T> resultList = new MyDoubleLinkedList<>();

      for (T element : list1) {
         if (list2.notContains(element)) {
            resultList.insertFront(element);
         }
      }

      return resultList;
   }
   // 2 3 7 9
   // 7 9 11 15
   public boolean notContains(T element) {
      NodeDouble<T> current = this.first;
      while (current != null) {
         if (current.getInfo().equals(element)) {
            return false;
         }
         current = current.getNext();
      }
      return true;
   }


}
