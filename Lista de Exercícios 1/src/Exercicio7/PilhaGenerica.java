package Exercicio7;
import java.util.Vector;

public class PilhaGenerica<T>
{
	private int n;
	private Vector<T> vetor;
	private int topo;
	
	public PilhaGenerica(int tamanho)
	{		
		n = tamanho;
		vetor = new Vector<T>(tamanho);
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
	
	public T pop()
	{
		T elemento;
		
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
	
	public boolean push(T elemento)
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
	
	public boolean retornaTopo(T elemento)
	{
	     if(!this.vazia()){
	        elemento = vetor.get(topo);         
	        return true;
	     }
	     else
	    	 return false;
	}	

	public boolean removerElemento(T elemento)
	{
		PilhaGenerica<T> aux = new PilhaGenerica<T>(n);
		
		while (!this.vazia())
		{
			T p = this.pop();
				
			if(p.equals(elemento))
			{
				while(!aux.vazia())
					this.push(aux.pop());
					
				return true;
			}
			
			else
				aux.push(p);
				
		}
			
		if(!aux.vazia()) {
			while(!aux.vazia())
				this.push(aux.pop());
		}
		
		return false;
	}

	public void listarPilhas() {
		
		if(this.vazia())
			System.out.println("Pilha vazia");
		else {
			System.out.println("\nPilha:");
			for(int i=0; i<=topo;i++)
				System.out.println(vetor.get(i));
		}
	}

}