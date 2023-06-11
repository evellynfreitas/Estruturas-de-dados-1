package Exercicio7;

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

	public boolean eIgual(ConjGenerico<T> conj2) {
		return eIgual(prim, conj2.prim);
	}
	
	private boolean eIgual(Elo c1, Elo c2) {
		if(c1 == null && c2 == null)
			return true;
		else if(c1 == null || c2 == null)
			return false;
		else if(c1.dado.compareTo(c2.dado)!=0)
			return false;
		else
			return eIgual(c1.prox, c2.prox);
	}
	
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception{
		ConjGenerico<T> comp = new ConjGenerico<T>();
		
		Elo c = prim,u = universo.prim;
		
		while(c!=null || u!=null) {
			
			if(c != null && u!=null) {
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
	
	public static <T extends Comparable<T>> ConjGenerico<T> aplicaDeMorgan(ConjGenerico<T>
	universo, ConjGenerico<T> conj1, ConjGenerico<T> conj2){
		
		ConjGenerico<T> uniao = conj1.uniao(conj2);
		ConjGenerico<T> morgan=null;
		
		try {
			morgan = uniao.complementar(universo);
		} catch (Exception e) {
			System.out.println(e);
		}

		return morgan;
	}

	public static void main(String[] args) {
		ConjGenerico<Integer> c1,universo,c2;
		
		c1 = new ConjGenerico<Integer>();
		universo = new ConjGenerico<Integer>();
		c2 = new ConjGenerico<Integer>();

		c1.insere(1); 
		c1.insere(2); 
		c1.insere(3); 
		c1.insere(4); 
		c1.insere(5);
		
		c2.insere(2); 
		c2.insere(3);
		c2.insere(5);
		
		universo.insere(1);
		universo.insere(2);
		universo.insere(3);
		universo.insere(4); 
		universo.insere(5); 
		universo.insere(6); 
		universo.insere(7); 
		universo.insere(8); 
		universo.insere(9);
		universo.insere(10);
		
		ConjGenerico<Integer> c4 = ConjGenerico.aplicaDeMorgan(universo,c1,c2);
		c4.imprime();
	}
}
