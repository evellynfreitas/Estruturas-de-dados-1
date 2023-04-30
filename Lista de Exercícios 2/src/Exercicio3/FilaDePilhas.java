package Exercicio3;

import java.util.Vector;

	public class FilaDePilhas<T> {

	private int tamanho;						/* Tamanho do vetor */
	private Vector<PilhaGenerica<T>> pilhas;	/* Vetor de elementos */
	private int ini;							/* Posicao do proximo elemento a ser retirado */
	private int n;								/* Numero de elementos na fila */
	
	public FilaDePilhas(int tam)
	{
		tamanho = tam;
		pilhas = new Vector<PilhaGenerica<T>>(tamanho);
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
	
	public boolean insere(PilhaGenerica<T> pilha)
	{
	  int fim;
	  
	  if (!cheia()) {
	    fim = (ini + n) % tamanho;
	    pilhas.add(fim, pilha);
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}
	
	public PilhaGenerica<T> remove()
	{
		PilhaGenerica<T> elemento = null;
		
		if (!this.vazia())
		{
			elemento = pilhas.get(ini);
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elemento;
	}
	
}