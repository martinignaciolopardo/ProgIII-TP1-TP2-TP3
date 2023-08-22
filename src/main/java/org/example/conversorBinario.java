package org.example;

public class conversorBinario {

   private int numeroDecimal;

   public String convertirBinario(){
      String binario = "";
      int numero = this.numeroDecimal; // 26
      return recursividadBinario(binario, numero);
   }

   private String recursividadBinario(String binario, int numero){
      if (numero == 0){
         return "0";
      }
      if (numero == 1){
         return binario += "1";
      }
      else if (numero%2 == 0){
         binario += "0";
         return recursividadBinario(binario, numero/2);
      }
      else {
         binario += "1";
         return recursividadBinario(binario, numero/2);
      }
   }
}
