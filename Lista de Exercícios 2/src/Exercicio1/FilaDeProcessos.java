package Exercicio1;

import java.util.Vector;

public class FilaDeProcessos {

	private int tamanho;				/* Tamanho do vetor */
	private Vector<Processo> vetor;		/* Vetor de elementos */
	private int ini;					/* Posicao do proximo elemento a ser retirado */
	private int n;						/* Numero de elementos na fila */
	
	public FilaDeProcessos(int tam)
	{
		tamanho = tam;
		vetor = new Vector<Processo>(tamanho);
		ini = 0;
		n = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	//Retiramos o elemento do início da fila
	public Processo remove()
	{
		Processo elemento = null;
		
		if (!this.vazia())
		{
			elemento = vetor.get(ini);
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(Processo elemento)
	{
	  int fim;
	  
	  if (!cheia()) {
	    fim = (ini + n) % tamanho;
	    vetor.add(fim,elemento);
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}
	
	public void imprime() {
		int i, j;
		
		if (vazia())
			System.out.println("Fila está vazia.");
		else
			for (i = ini, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.println(j + "° Processo -> identificador " + vetor.get(i).retornaIdentificador());
	}


}
