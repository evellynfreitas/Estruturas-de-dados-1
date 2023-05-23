package Exercicio5;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected int dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(int elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(int elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no início da lista. */
	public void insere(int novo)
	{
		Elo p;
		
		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;
	}
	
	/* Método auxiliar para busca. */
	private Elo busca(int elem)
	{
		Elo p = null;
		
		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim) 
			prim = prim.prox;
		else 
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se é ultimo elemento */  
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	/* Imprime todos os elementos da lista em ordem reversa. */
	public void imprimeReversa()
	{
		Elo p;
		Elo ult = null;
		
		System.out.println("Elementos da lista em ordem reversa:");
		
		p = prim;
		
		while(p != null)
		{
			ult = p;
			p = p.prox;
		}
		
		for(p = ult; p != null; p = p.ant)
		{
			System.out.print(p.dado + " ");
		}
		
		System.out.println();
	}
	
	
	public boolean verificaIgualdade(ListaDuplamente lista2) {
		/*
		Para a classe ListaDuplamente, crie um método que use recursão para verificar se a
		lista corrente, isto é, para a qual o método é chamado, é igual a uma lista lista2 passada
		como parâmetro. Note que você pode criar um ou mais métodos auxiliares.
		*/
		
		return comparaElos(this.prim, lista2.prim);
	}


	private boolean comparaElos(Elo e1, Elo e2) {
		
		if(e1 == null && e2 == null)
			return true;
		else if(e1 == null || e2 == null)
			return false;
		else if (e1.dado == e2.dado)
			return comparaElos(e1.prox, e2.prox);
		else
			return false;
	}
	
	public static void main(String[] args) {
		ListaDuplamente l1 = new ListaDuplamente();
		l1.insere(1);l1.insere(2);l1.insere(3);l1.insere(4);
		
		ListaDuplamente l2 = new ListaDuplamente();
		l2.insere(1);l2.insere(2);l2.insere(3);l2.insere(4);
		
		ListaDuplamente l3 = new ListaDuplamente();
		l3.insere(1);l3.insere(2);l3.insere(3);
		
		ListaDuplamente l4 = new ListaDuplamente();
		
		ListaDuplamente l5 = new ListaDuplamente();
		
		System.out.println(l1.verificaIgualdade(l2));
		System.out.println(l1.verificaIgualdade(l3));
		System.out.println(l1.verificaIgualdade(l4));
		System.out.println(l4.verificaIgualdade(l5));
	}
}