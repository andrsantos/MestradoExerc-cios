package ListaEncadeada;

import java.util.LinkedList;
import java.util.List;


public class ListaEncadeadaApp {
	
	// INTERCALANDO AS LISTAS
	public static LinkedList<Double> mergeList(LinkedList<Double> l1, LinkedList<Double> l2) {
		List<Double> novaLista = new LinkedList<Double>();
		int lista = 1;
		int posicao = 0;
	    	for(int i = 0; i < l1.size() + l2.size(); i++) {
	    		//Se for a primeira lista
	    		if(lista == 1) {
	    			//Se a primeira lista já foi toda percorrida
	    			if(posicao >= l1.size()) {
		    			novaLista.add(l2.get(posicao));
		    			}
	    			else {
	    			novaLista.add(l1.get(posicao));
	    			lista = 2;
	    			}
	    			
	    		}
	    		//Se for a segunda lista
	    		else {
	    			//Se a segunda lista foi toda percorrida
	    			if(posicao >= l2.size()) {
	    		    posicao++;
	    			novaLista.add(l1.get(posicao));
	    			} else {
	    				novaLista.add(l2.get(posicao));
		    			lista = 1;
		    			posicao++;
	    			}
	    		}    	
	    	}
	    	System.out.println(novaLista);
	    	return (LinkedList<Double>) novaLista;    	
	}
	//REVERTENDO A LISTA
	public static void reverseList(LinkedList<Double> l) {
	LinkedList<Double> aux = new LinkedList<Double>();
	int fim = l.size()-1;
	for(int i = 0; i < l.size(); i++) {
	//Adiciona a lista invertida à lista auxiliar
	aux.add(l.get(fim));
	fim--;
	}	
	//Limpa a lista na ordem antiga
	l.clear();
	//Adiciona os itens da lista auxiliar
	aux.forEach(numero -> {	
		l.add(numero);
	});
	System.out.println(l);
	}
		
	public static void main(String[] args) {
    
	LinkedList<Double> l1 = new LinkedList<Double>();
	LinkedList<Double> l2 = new LinkedList<Double>();
	LinkedList<Double> l3 = new LinkedList<Double>();
	l1.add(3.1);
	l1.add(9.8);
	l1.add(4.5);
	l1.add(1.0);	
	l2.add(7.2);
	l2.add(9.8);
	l2.add(9.2);
	l3 = mergeList(l1,l2);
	reverseList(l3);
	

}
}
