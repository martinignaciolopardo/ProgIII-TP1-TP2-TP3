package org.example;

public class Pila<T> {

   private MySimpleLinkedList<T> list;

   public void push(T o){
      this.list.insertFront(o);
   }

   public T pop(){
      return this.list.extractFront();
   }

   public T top(){
      return this.list.get(0);
   }

   public void reverse(){
      Pila p = new Pila<>();
      while(!list.isEmpty()){
         p.push(this.pop());
      }
   }

}
