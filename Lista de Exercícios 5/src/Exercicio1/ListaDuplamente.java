package Exercicio1;

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
	
	public static ListaDuplamente intersecao(ListaDuplamente l1, ListaDuplamente l2) {
		ListaDuplamente l3 = new ListaDuplamente();
		//Elo p1 = l1.prim;
		//Elo p2 = l2.prim;
		
		for(Elo p1 = l1.prim; p1!=null; p1 = p1.prox) {
			for(Elo p2 = l2.prim; p2!=null; p2 = p2.prox) {
				if(p1.dado == p2.dado)
					l3.insere(p1.dado);
			}
		}
		
		
		/*
		while(p1!=null && p2!=null) {
			
			if(p1.dado < p2.dado)
				p1 = p1.prox;
			
			else if(p1.dado > p2.dado)
				p2 = p2.prox;
			else {
				l3.insere(p1.dado);
				p1 = p1.prox;
				p2 = p2.prox;
			}
		}*/
		return l3;
	}
	
	public static void main(String[] args) {
		ListaDuplamente l1 = new ListaDuplamente();
		l1.insere(2);l1.insere(10);l1.insere(5);l1.insere(11);
		
		ListaDuplamente l2 = new ListaDuplamente();
		l2.insere(10);l2.insere(11);l2.insere(1);l2.insere(3);l2.insere(5);
		
		ListaDuplamente l3 = ListaDuplamente.intersecao(l1,l2);
		l3.imprime();
	}
}