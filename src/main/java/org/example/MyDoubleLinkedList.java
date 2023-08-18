package org.example;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

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
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
