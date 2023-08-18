package org.example;

import java.util.Iterator;

public class MyIteratorDouble<T> implements Iterator<T> {

   private NodeDouble<T> cursor;

   public MyIteratorDouble(NodeDouble<T> first){
      this.cursor = first;
   }

   @Override
   public boolean hasNext() {
      return cursor != null;
   }

   @Override
   public T next() {
      T info = cursor.getInfo();
      cursor = cursor.getNext();
      return info;
   }
}
