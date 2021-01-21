// Criação de uma calculadora em Java sem necessidade de selecionar a operação em um Menu

// Nome do projeto: Calculadora em Java
// Linguagem: Java
// Utilizações: Variáveis, Repetições, Listas e Vetores
// Autor: Rafael Lua - rafaellua13

import java.util.Scanner;   // Importar Input do usuário (Scanner)
import java.util.ArrayList; // Permitir operação com Listas

class Main {
  public static void main(String[] args) {
    // Concatenar strings/variaveis funciona no println
    

    System.out.println("\n\n\nDigite as operações como desejar, mantendo um espaço entre elas \n\nPossiveis : %  /  *  +  -\n\n");
    System.out.println("Exemplo: 2 + 3 * 8 / 4 \n\n");

    // Realizar input do usuário
    Scanner operation = new Scanner(System.in);
    String calc = operation.nextLine();       // A proxima linha digitada sera considerada como Input
    String calcularTemp[] = calc.split(" ");  // Dividir math e salvar em um Vetor
    operation.close();                        // Fechar Scanner
    
    // Criar uma Lista e salvar nela os valores do Vetor anterior
    ArrayList<String> calcular = new ArrayList(); 
    for (int i = 0; i < calcularTemp.length; i++) {
      calcular.add(calcularTemp[i]);          // Adicionar cada valor do vetor
    }

    // função de mostrar a lista para testes
    // for (int i = 0; i < calcular.size(); i++) {
    //    System.out.println(calcular.get(i));
    // }

     // Forma de converter uma string para Int ou Float
          // Integer.parseInt(string)
          // Float.parseFloat(String)
    
    int var = 0;  // Variavel de controle do While
    
    // Operadores a serem utilizados:
    String operators[] = {"%","/","*","+","-"}; 
    // É possivel adicionar mais operadores no vetor, porém é necessário alterar a seção de "ifs" dentro da repetição

    // Variavel de controle dos operadores
    int helper = -1;    // Começar no -1 pois iniciara o While com uma soma, se tornando 0
    while (var == 0){
      helper += 1;      // Controlar o operador 
      for (int i = 0; i < calcular.size(); i++) {
        if (calcular.get(i).equals(operators[helper])){ // Se o valor no momento for um dos operadores do vetor
          
         
          
          
          float mult1 = Float.parseFloat(calcular.get(i-1)); // Salvar valor anterior a i
          float mult2 = Float.parseFloat(calcular.get(i+1)); // Salvar valor posterior a i          
          
          float fimMult = 0; 

          // Adicionar mais "ifs" aqui com os novos operadores desejados

          if (calcular.get(i).equals("%")){
              fimMult = mult1 % mult2;                      // Operação Resto
          }
          if (calcular.get(i).equals("/")){
              fimMult = mult1 / mult2;                      // Operação Divisão
          }
          if (calcular.get(i).equals("*")){
              fimMult = mult1 * mult2;                      // Operação Multiplicação
          }
          if (calcular.get(i).equals("+")){
              fimMult = mult1 + mult2;                      // Operação Soma
          }
          if (calcular.get(i).equals("-")){
              fimMult = mult1 - mult2;                      // Operação Subtração
          }
   
          
          
          // Converter o valor float em fimMult para string   
          String fimMultStr = String.valueOf(fimMult); 
          
          calcular.remove(i-1);              // Remover valor da lista
          calcular.remove(i-1);              // Remover operação da lista
          calcular.set(i-1, fimMultStr);     // Substituir valor final da lista pelo valor encontrado


          helper -= 1; // Se encontrar um operador, deve continuar procurando outros até não achar mais nenhum do mesmo tipo, permitindo ir para o proximo operador
          break;

        }
      
      }
      
      if (calcular.size() == 1){ // Finalizar o While quando só houver 1 valor na Lista
        var += 1;

      }

    }

    // Mostrar Valor Final da Lista
    for (int i = 0; i < calcular.size(); i++) {
       System.out.println(calcular.get(i));
    }
    System.out.println("\n\n");
  }
}

// Depois de salvar o código, compilar ele utilizando javac NomePrograma.java no prompt onde ele foi salvo

// Uma pasta da classe Main sera criada no mesmo local, para executar, escrever no Prompt java Main e a calculadora sera executada.





