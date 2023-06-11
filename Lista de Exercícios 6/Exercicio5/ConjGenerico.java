package Exercicio5;

public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Referência para primeiro elemento. */
	private Elo ultimo;
	
	/* Classe auxiliar para guardar cada elemento do conjunto. */
	private class Elo
	{                 
		T dado;
		Elo prox;
		/*
		public Elo()
		{ 
			prox = null;
		}*/

		public Elo(T elem)
		{
			dado = elem;
			prox = null;
		}
		/*
		public Elo(T elem, Elo proxElem)
		{ 
			dado = elem;
			prox = proxElem;
		}*/
	}

	/* Construtor que cria um conjunto vazio. */
	public ConjGenerico()
	{
		prim = null;
		ultimo = null;
	}

	/* Método privado para realizar uma cópia de um outro conjunto. */
	private void copia(ConjGenerico<T> conj2)
	{
		Elo ult = null, q;

		prim = null;
		
		for (Elo p = conj2.prim; p != null; p = p.prox)
		{
			q = new Elo(p.dado);
			
			if (ult == null)
				prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
	}

	/* Método privado para realizar uma cópia de um outro conjunto. */
	public void apaga()
	{
		for (Elo p = prim; p != null; p = prim)
		{
			prim = prim.prox;
			p.prox = null;
		}
	}

	/* Simula uma sobrecarga do operador de atribuição. */
	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
		if (this != conj2)
		{
			apaga();
			copia(conj2);
		}
		
		return this;
	}

	/* Testa se o conjunto está vazio. */
	public boolean vazio()
	{
		return prim == null;
	}

	/* Teste de pertinência. Usa fato de estar ordenado. */
	public boolean pertence(T valor)
	{
		Elo p;
		
		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;	  

		return true;
	}

	/* Inserção de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento já estava lá. */
	public boolean insere(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;
			
			ant = p;
		}
		
		Elo q = new Elo(valor);
		
		if (p == prim)
			prim = q;
		else
			ant.prox = q;
		
		if(p == null)
			ultimo = q;
		
		q.prox = p;
		
		return true;
	}

	/* Remoção de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento não estava lá. */
	public boolean remove(T valor)
	{
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox)
		{
			if (p.dado.compareTo(valor) > 0) return false;
			if (p.dado.compareTo(valor) == 0) break;	 
			
			ant = p;
		}
		
		if (p == null)
			return false;
		
		if (p == prim) 
			prim = prim.prox;
		else
			ant.prox = p.prox;

		// se a última posição for removida
		if(p.prox == null)
			ultimo = ant;
		
		p = null;
		
		return true;
	}

	/* Método para união de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a união. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> uniao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>(); 
		
		while ( (p1 != null) || (p2 != null) )
		{
			if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0)))
			{
				q = new Elo(p1.dado);
				p1 = p1.prox;
			}
			else
			{
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado.compareTo(p2.dado) == 0))
					p1 = p1.prox;
				p2 = p2.prox;
			} 

			if (ult == null) 
				uniao.prim = q;
			else
				ult.prox = q;
			
			ult = q;
		}
		
		return uniao;
	}

	/* Método para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao. 
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> intersecao(ConjGenerico<T> conj2)
	{
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ( (p1 != null) && (p2 != null) )
		{
			if (p1.dado.compareTo(p2.dado) < 0)
			{
				p1 = p1.prox;
			}
			else if(p2.dado.compareTo(p1.dado) < 0)
			{
				p2 = p2.prox;
			}
			else
			{
				q = new Elo(p1.dado);
				
				p1 = p1.prox;
				p2 = p2.prox;
				
				if (ult == null) 
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}

		return inter;
	}

	/* Retorna cardinalidade do conjunto */
	public int tamanho()
	{
		int tam = 0;
		Elo p;

		for(p = prim; p != null; p = p.prox)
			tam++;
		
		return tam;
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos do conjunto");
		
		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");
		
		System.out.println();
	}

	public T ultimo() {
		return ultimo.dado;
	}
	
	public T primeiro() {
		return prim.dado;
	}
	
	public boolean eSubconjunto(ConjGenerico<T> conj2) {
		Elo c1 = prim, c2 = conj2.prim;
		while(c1!=null || c2!=null) {
			if(c1 != null && c2 != null) {
				System.out.println(c2.dado +" "+c1.dado);
				if(c2.dado.compareTo(c1.dado)<0) {
					c2 = c2.prox;
				}
				else if(c2.dado.compareTo(c1.dado)==0) {
					c2 = c2.prox;
					c1 = c1.prox;
				}
				else
					return false;
			}
			else if(c2 == null && c1 != null) {
				return false;
			}
		}
		
		return true;
	}
	
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2){
		ConjGenerico<T> d = new ConjGenerico<T>();
		
		Elo c1 = prim, c2= conj2.prim;
		//tem em c1 mas não tem em c2
		// c1 = 1 3 5 6 7
		// c2 = 1 2 4 5 8 
		
		while(c1!=null || c2!=null) { 
			if(c1!=null && c2!=null) {
				if(c2.dado.compareTo(c1.dado)<0) {
					c2 = c2.prox;
				}
				else if(c2.dado.compareTo(c1.dado)==0) {
					c2 = c2.prox;
					c1 = c1.prox;
				}
				else {
					d.insere(c1.dado);
					c1 = c1.prox;
				}
			}
			else if(c1!=null && c2==null) {
				d.insere(c1.dado);
				c1 = c1.prox;
			}
			else
				break;
		}
		
		return d;
	}
	
	
	public static void main(String[] args) {
		ConjGenerico<Integer> c1,c2;
		
		c1 = new ConjGenerico<Integer>();
		c2 = new ConjGenerico<Integer>();

		c1.insere(1); 
		c1.insere(2);
		c1.insere(3); 
		c1.insere(4);
		c1.insere(5);
		c1.insere(6); 
		c1.insere(7);
		c1.insere(8); 
		c1.insere(9);
		//c1.imprime();
		
		c2.insere(1); 
		c2.insere(2); 
		c2.insere(4);
		c2.insere(7);
		//c2.imprime();
		
		ConjGenerico<Integer> c3 = c1.diferenca(c2);
		c3.imprime();
		
	}
}