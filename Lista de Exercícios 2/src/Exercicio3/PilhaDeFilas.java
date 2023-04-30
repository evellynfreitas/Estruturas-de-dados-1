package Exercicio3;

import java.util.Vector;

	public class PilhaDeFilas<T> {

		private int n;
		private Vector<Fila<T>> vetor;
		private int topo;
		
		public PilhaDeFilas(int tamanho)
		{		
			n = tamanho;
			vetor = new Vector<Fila<T>>(tamanho);
			topo = -1;
		}
		
		public boolean vazia()
		{
			return topo == -1 ? true : false; 
		}
		
		public boolean cheia()
		{
			return topo == n - 1 ? true : false;
		}
		

		public Fila<T> pop()
		{
			Fila<T> elemento;
			
			if (!this.vazia())
			{
				elemento = vetor.get(topo--);
				return elemento;
			}
			else
			{
				//Impresso para fins didticos
				System.out.println("Pilha vazia: pop nao funcionou.");
				return null;
			}
		}
		
		public boolean push(Fila<T> elemento)
		{
			if (!this.cheia())
			{
				vetor.add(++topo, elemento);
				return true;
			}
			else
			{
				System.out.println("Pilha cheia: push nao funcionou.\n");
				return false;
			}
		}
		
		public boolean retornaTopo(Fila<T> elemento)
		{
		     if(!this.vazia()){
		        elemento = vetor.get(topo);         
		        return true;
		     }
		     else
		    	 return false;
		}
		
}
