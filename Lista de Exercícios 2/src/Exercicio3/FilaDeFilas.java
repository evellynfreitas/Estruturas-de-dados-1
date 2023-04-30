package Exercicio3;

import java.util.Vector;

	public class FilaDeFilas<T>{
	
		private int tamanho;						/* Tamanho do vetor */
		private Vector<Fila<T>> filas;				/* Vetor de elementos */
		private int ini;							/* Posicao do proximo elemento a ser retirado */
		private int n;								/* Numero de elementos na fila */
		
		public FilaDeFilas(int tam)
		{
			tamanho = tam;
			filas = new Vector<Fila<T>>(tamanho);
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
		
		public boolean insere(Fila<T> fila)
		{
		  int fim;
		  
		  if (!cheia()) {
		    fim = (ini + n) % tamanho;
		    filas.add(fim, fila);
		    n++;
		    return true;
		  } 
		  else
		    return false;
		}
		
		public Fila<T> remove()
		{
			Fila<T> elemento = null;
			
			if (!this.vazia())
			{
				elemento = filas.get(ini);
				ini = (ini + 1) % tamanho;
				n--;
			} 

			return elemento;
		}
	
}
