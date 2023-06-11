package Exercicio3;

public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Refer�ncia para primeiro elemento. */
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

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
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

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	public void apaga()
	{
		for (Elo p = prim; p != null; p = prim)
		{
			prim = prim.prox;
			p.prox = null;
		}
	}

	/* Simula uma sobrecarga do operador de atribui��o. */
	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
		if (this != conj2)
		{
			apaga();
			copia(conj2);
		}
		
		return this;
	}

	/* Testa se o conjunto est� vazio. */
	public boolean vazio()
	{
		return prim == null;
	}

	/* Teste de pertin�ncia. Usa fato de estar ordenado. */
	public boolean pertence(T valor)
	{
		Elo p;
		
		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;	  

		return true;
	}

	/* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento j� estava l�. */
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

	/* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
	   Retorna false se elemento n�o estava l�. */
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

		// se a �ltima posi��o for removida
		if(p.prox == null)
			ultimo = ant;
		
		p = null;
		
		return true;
	}

	/* M�todo para uni�o de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a uni�o. 
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

	/* M�todo para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao. 
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
	
	public boolean eIgual(ConjGenerico<T> conj2) {
		
		Elo p,q;
		
		for(p = prim, q = conj2.prim; p!= null && q!= null ;p = p.prox, q = q.prox)
			if(p.dado.compareTo(q.dado) != 0)
				return false;
		
		if(p == null && q == null)
			return true;
		else
			return false;
	}
	// 0 1 2 3 4 5 6 7 8 9
	// 2 5 8
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception{
		ConjGenerico<T> comp = new ConjGenerico<T>();
		
		Elo c = prim,u = universo.prim;
		
		while(c!=null || u!=null) {
			
			if(c != null && u!=null) {
				System.out.println(u.dado +" "+c.dado);
				if(c.dado.compareTo(universo.ultimo.dado)>0)
					throw new Exception("O conjunto possui elementos de fora do universo!");

				else if(u.dado.compareTo(c.dado)<0) {
					comp.insere(u.dado);
					u = u.prox;
				}
				else if(u.dado.compareTo(c.dado)>0) {
					c = c.prox;
				}
				else {
					u = u.prox;
					c = c.prox;
				}
			}
			
			else if(c == null) {
				comp.insere(u.dado);
				u = u.prox;
			}
			
			else if(u == null) {
				if(c.dado.compareTo(universo.ultimo.dado)>0)
					throw new Exception("O conjunto possui elementos de fora do universo!");
			}
		}
		
		return comp;
	}
	
	public static void main(String[] args) {
		ConjGenerico<Integer> c1,c2,c3;
		
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
		
		c2.insere(2); 
		c2.insere(5); 
		c2.insere(8);
		c2.insere(10);
		//c2.imprime();
		
		try {
			c3 = c2.complementar(c1);
			c3.imprime();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
}