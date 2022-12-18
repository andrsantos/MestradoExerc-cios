package Algoritmos;

import java.util.Arrays;
import java.util.Random;

public class OrdenacaoApp {
	static int[] array3 = new int[100000];
    static int intervaloInicial = 0;
    static int intervaloFinal = 100000;
    
    static int getRandomNumberRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
    }
    

	// ALGORITMO COUNTING SORT
	static void countSort(int array[], int size) {
	    int[] output = new int[size + 1];

	    
	    // Encontra o maior elemento do array
	    int max = array[0];
	    for (int i = 1; i < size; i++) {
	      if (array[i] > max)
	        max = array[i];
	    }
	    int[] count = new int[max + 1];

	   
	    // Inicializa o array de contagem com todos os zeros
	    for (int i = 0; i < max; ++i) {
	      count[i] = 0;
	    }

	    // Guarda o contador de cada elemento
	    for (int i = 0; i < size; i++) {
	      count[array[i]]++;
	    }

	   
	    // Guarda o contador cumulativo de cada array
	    for (int i = 1; i <= max; i++) {
	      count[i] += count[i - 1];
	    }

	  
	    // Encontra o índice de cada elemento do array original no array de contador
	    // e posiciona os elementos no array de saída
	    for (int i = size - 1; i >= 0; i--) {
	      output[count[array[i]] - 1] = array[i];
	      count[array[i]]--;
	    }

	    
	    //Copia os elementos ordenados para o array original
	    for (int i = 0; i < size; i++) {
	      array[i] = output[i];
	    }
	  }
	///////////////////////////////////////////////
	
	
	//ALGORITMO QUICKSORT E SEU MÉTODO SEPARAR
	private static void quickSort(int[] array3, int inicio, int fim) {
        if (inicio < fim) {
               int posicaoPivo = separar(array3, inicio, fim);
               quickSort(array3, inicio, posicaoPivo - 1);
               quickSort(array3, posicaoPivo + 1, fim);
        }
  }

  private static int separar(int[] array3, int inicio, int fim) {
        int pivo = array3[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
               if (array3[i] <= pivo)
                      i++;
               else if (pivo < array3[f])
                      f--;
               else {
                      int troca = array3[i];
                      array3[i] = array3[f];
                      array3[f] = troca;
                      i++;
                      f--;
               }
        }
        array3[inicio] = array3[f];
        array3[f] = pivo;
        return f;
  }
  ///////////////////////////////////
  
  //MERGE SORT
  private static void mergeSort(int tamanho, int[] array3) {
	    /* Variavel utilizada para percorrer o array3. 
	      Inicializa com 1 para indicar que o array3 tenha pelo menos 1 elemento. */
	    int elementos = 1;
	    /* Variaveis utilizadas para marcar o inicio, meio e fim do array3. */
	    int inicio, meio, fim;
	    
	    /* Percorre os elementos do array3 até chegar no fim do array3. */
	    while(elementos < tamanho) {
	      /* Aponta o inicio do array3. */
	      inicio = 0;
	      
	      /* Percorre o array3 do inicio + quantidade de elementos ja percorrido, 
	        até o tamanho do array3. */
	      while(inicio + elementos < tamanho) {
	        /* Guarda a posição do meio do array3 que será ordenado. */
	        meio = inicio + elementos;
	        /* Guarda a posição final do array3 que será ordenado. */
	        fim = inicio + 2 * elementos;
	        
	        /* Caso o fim fique com um tamanho maior, que o tamanho do array3,
	         então faz o fim ter o mesmo tamanho que o tamanho do array3. */
	        if(fim > tamanho)
	          fim = tamanho;
	        
	        /* Chama o método que faz a intercalação dos valores
	          ordenados do array3. */
	        intercala(array3, inicio, meio, fim);
	        
	        /* Faz o inicio do array3 ser igual ao fim. */
	        inicio = fim;
	      }
	      
	      /* Percorre o array3 dobrando a quantidade de itens ja ordenados. */
	      elementos = elementos * 2;
	    }
	  }
  
  private static void intercala(int[] array3, int inicio, int meio, int fim) {
	    /* array3 utilizado para guardar os valors ordenados. */
	    int novoarray3[] = new int[fim - inicio];
	    /* Variavel utilizada para guardar a posicao do inicio do array3. */
	    int i = inicio;
	    /* Variavel utilizada para guardar a posição do meio do array3. */
	    int m = meio;
	    /* Variavel utilizada para guarda a posição onde os
	      valores serão inseridos no novo array3. */
	    int pos = 0;
	    
	    /* Enquanto o inicio não chegar até o meio do array3, ou o meio do array3
	      não chegar até seu fim, compara os valores entre o inicio e o meio,
	      verificando em qual ordem vai guarda-los ordenado.*/
	    while(i < meio && m < fim) {
	      /* Se o array3[i] for menor que o array3[m], então guarda o valor do
	        array3[i] pois este é menor. */
	      if(array3[i] <= array3[m]) {
	        novoarray3[pos] = array3[i];
	        pos = pos + 1;
	        i = i + 1;
	      // Senão guarda o valor do array3[m] pois este é o menor.
	      } else {
	        novoarray3[pos] = array3[m];
	        pos = pos + 1;
	        m = m + 1;
	      }
	    }
	    
	    // Adicionar no array3 os elementos que estão entre o inicio e meio,
	    // que ainda não foram adicionados no array3.
	    while(i < meio) {
	      novoarray3[pos] = array3[i];
	      pos = pos + 1;
	      i = i + 1;
	    }
	    
	    // Adicionar no array3 os elementos que estão entre o meio e o fim,
	    // que ainda não foram adicionados no array3.
	    while(m < fim) {
	      novoarray3[pos] = array3[m];
	      pos = pos + 1;
	      m = m + 1;
	    }
	    
	    // Coloca no array3 os valores já ordenados.
	    for(pos = 0, i = inicio; i < fim; i++, pos++) {
	      array3[i] = novoarray3[pos];
	    }
	  }
	
  ////////////////////////
  
  
	
	public static void main(String[] args) {
	//Gera vetor gigante e aleatório para testes futuros
		 for (int i = 0; i < array3.length; i++) {
	            array3[i] = getRandomNumberRange(intervaloInicial, intervaloFinal);
	            
	        }	
		 
	//20 posições
	int array1[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};	
	int array1Copia[] = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
	//20 posições
	int array2[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	int array2Copia[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	//24 posições
	int array3[] = {19,12,14,11,10,8,3,1,5,7,21,1,13,24,56,67,89,9,12,34,76,98,45,23};
	int array3Copia[] = {19,12,14,11,10,8,3,1,5,7,21,1,13,24,56,67,89,9,12,34,76,98,45,23};
	
	/// AQUI COMEÇA O COUNTING SORT
	System.out.println("##### Algoritmo CountSort #####");
	System.out.println("Entrada -> Vetor desordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array3));
	long startTime1 = System.nanoTime();
	countSort(array3,24);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array3.length; i++) {
		
		System.out.print( + array3[i] + " ");
		
	}
	long endTime1 = System.nanoTime();
	long timeElapsed1 = endTime1 - startTime1;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed1);
	System.out.println();
	System.out.println("Entrada -> Vetor ordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array2));
	startTime1 = System.nanoTime();
	countSort(array3,24);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array2.length; i++) {
		
		System.out.print( + array2[i] + " ");
		
	}
	endTime1 = System.nanoTime();
	timeElapsed1 = endTime1 - startTime1;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed1);
	System.out.println();
	
	System.out.println();
	System.out.println("Entrada -> Vetor decrescente");
	System.out.println("Vetor de entrada: " + Arrays.toString(array1));
	startTime1 = System.nanoTime();
	countSort(array3,24);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array1.length; i++) {
		
		System.out.print( + array1[i] + " ");
		
	}
	endTime1 = System.nanoTime();
	timeElapsed1 = endTime1 - startTime1;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed1);
	System.out.println();
	
	for(int i = 0; i < array1.length; i++) {
		array1[i] = array1Copia[i];
	}
	for(int i = 0; i < array2.length; i++) {
	array2[i] = array2Copia[i];
	}
	for(int i = 0; i < array3.length; i++) {
	array3[i] = array3Copia[i];
	}
	// FINAL DO COUNTING SORT
	
	// AQUI COMEÇA O QUICKSORT
	System.out.println("##### Algoritmo QuickSort #####");
	System.out.println("Entrada -> Vetor desordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array3));
	long startTime2 = System.nanoTime();
	quickSort(array3,0,23);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array3.length; i++) {
		
		System.out.print( + array3[i] + " ");
		
	}
	long endTime2 = System.nanoTime();
	long timeElapsed2 = endTime2 - startTime2;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed2);
	System.out.println();
	System.out.println("Entrada -> array3 ordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array2));
	startTime2 = System.nanoTime();
	quickSort(array2,0,19);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array2.length; i++) {
		
		System.out.print( + array2[i] + " ");
		
	}
	endTime2 = System.nanoTime();
	timeElapsed2 = endTime2 - startTime2;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed2);
	System.out.println();
	
	System.out.println();
	System.out.println("Entrada -> Vetor decrescente");
	System.out.println("Vetor de entrada: " + Arrays.toString(array1));
	startTime2 = System.nanoTime();
	quickSort(array1,0,19);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array1.length; i++) {
		
		System.out.print( + array1[i] + " ");
		
	}
	endTime2 = System.nanoTime();
	timeElapsed2 = endTime2 - startTime2;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed2);
	System.out.println();
	for(int i = 0; i < array1.length; i++) {
		array1[i] = array1Copia[i];
	}
	for(int i = 0; i < array2.length; i++) {
	array2[i] = array2Copia[i];
	}
	for(int i = 0; i < array3.length; i++) {
	array3[i] = array3Copia[i];
	
	}
	//AQUI TERMINA O QUICKSORT
	
	//AQUI COMEÇA O HEAPSORT
	System.out.println("##### Algoritmo HeapSort #####");
	System.out.println("Entrada -> Vetor desordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array3Copia));
	System.out.println("Vetor ordenado: ");
	Heapsort heapsort = new Heapsort();
	long startTime3 =  System.nanoTime();
	Heapsort.heapsort(array3);
	System.out.print("[");
	for(int i = 0 ; i < array3.length; i++) {		
		System.out.print( + array3[i] + " ");		
	}
	long endTime3 = System.nanoTime();
	long timeElapsed3 = endTime3 - startTime3;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed3);
	System.out.println();
	
	System.out.println("Entrada -> Vetor ordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array2Copia));
	System.out.println("Vetor ordenado: ");
	Heapsort heapsort2 = new Heapsort();
	startTime3 =  System.nanoTime();
	Heapsort.heapsort(array2);
	System.out.print("[");
	for(int i = 0 ; i < array2.length; i++) {		
		System.out.print( + array2[i] + " ");		
	}
	endTime3 = System.nanoTime();
	timeElapsed3 = endTime3 - startTime3;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed3);
	System.out.println();
	
	System.out.println("Entrada -> Vetor decrescente");
	System.out.println("Vetor de entrada: " + Arrays.toString(array1Copia));
	System.out.println("Vetor ordenado: ");
	Heapsort heapsort3 = new Heapsort();
	startTime3 =  System.nanoTime();
	Heapsort.heapsort(array1);
	System.out.print("[");
	for(int i = 0 ; i < array1.length; i++) {		
		System.out.print( + array1[i] + " ");		
	}
	endTime3 = System.nanoTime();
	timeElapsed3 = endTime3 - startTime3;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed3);
	System.out.println();
	for(int i = 0; i < array1.length; i++) {
		array1[i] = array1Copia[i];
	}
	for(int i = 0; i < array2.length; i++) {
	array2[i] = array2Copia[i];
	}
	for(int i = 0; i < array3.length; i++) {
	array3[i] = array3Copia[i];
	
	}
	//AQUI TERMINA O HEAPSORT
	
	//AQUI COMEÇA O MERGE SORT
	System.out.println("##### Algoritmo MergeSort #####");
	System.out.println("Entrada -> Vetor desordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array3));
	long startTime4 = System.nanoTime();
	mergeSort(24,array3);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array3.length; i++) {
		
		System.out.print( + array3[i] + " ");
		
	}
	long endTime4 = System.nanoTime();
	long timeElapsed4 = endTime4 - startTime4;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed4);
	System.out.println();
	System.out.println("Entrada -> Vetor ordenado");
	System.out.println("Vetor de entrada: " + Arrays.toString(array2));
	startTime4 = System.nanoTime();
	mergeSort(20,array2);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array2.length; i++) {
		
		System.out.print( + array2[i] + " ");
		
	}
	endTime4 = System.nanoTime();
	timeElapsed4 = endTime4 - startTime4;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed4);
	System.out.println();
	
	System.out.println();
	System.out.println("Entrada -> vetor decrescente");
	System.out.println("Vetor de entrada: " + Arrays.toString(array1));
	startTime4 = System.nanoTime();
	mergeSort(20,array1);
	System.out.println("Vetor ordenado:");
	System.out.print("[");
	for(int i = 0 ; i < array1.length; i++) {
		
		System.out.print( + array1[i] + " ");
		
	}
	endTime4 = System.nanoTime();
	timeElapsed4 = endTime4 - startTime4;
	System.out.print("]");
	System.out.println();
	System.out.println("Tempo de execução: " + timeElapsed4);
	System.out.println();
	
	for(int i = 0; i < array1.length; i++) {
		array1[i] = array1Copia[i];
	}
	for(int i = 0; i < array2.length; i++) {
	array2[i] = array2Copia[i];
	}
	for(int i = 0; i < array3.length; i++) {
	array3[i] = array3Copia[i];
	}
	
	
	
			
	}


}
