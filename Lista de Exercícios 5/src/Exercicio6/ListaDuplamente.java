package Exercicio6;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	protected int tamanho;
	protected int id;
	protected class Elo
	{
		protected Chamada dado;
		protected Elo ant;
		protected Elo prox;
		
		public Elo()
		{
			ant = null;
			prox = null;
		}
		
		public Elo(Chamada elem)
		{
			dado = elem;
			ant = null;
			prox = null;
		}
		
		public Elo(Chamada elem, Elo antElem, Elo proxElem)
		{
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}
	}
	
	public ListaDuplamente()
	{
		prim = null;
		tamanho = 0;
		id = 0;
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no início da lista. */
	public void insere(int novo)
	{
		/*
		Elo p;
		
		p = new Elo(novo);
		
		p.prox = prim;
		
		p.ant = null;
		
		if (prim != null)
			prim.ant = p;
		
		prim = p;
		*/
		
		Chamada c = new Chamada(novo, ++id);
		Elo p;
		p = new Elo(c);
		
		Elo q, ant=null, post=null;
		
		for(q = prim;(q!=null && q.dado.getCusto() >= p.dado.getCusto()); q = q.prox) {
			ant = q;
			post = q.prox;
		}
			
		if(prim == null) { //lista vazia
			p.prox = null;
			p.ant = null;
			prim = p;
		}
		else if(ant == null) { // inserir no inicio
			post = prim;
			p.prox = post;
			p.ant = null;
			prim = p;
		}
		else if(post == null) { //inserir no final
			p.ant = ant;
			p.prox = null;
			ant.prox = p;
		}
		else { // inserir no meio
		ant.prox = p;
		p.ant = ant;
		
		post.ant = p;
		p.prox = post;
		}
		
		tamanho++;
	}
	
	/* Método auxiliar para busca. */
	private Elo busca(Chamada elem)
	{
		Elo p = null;
		
		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;      
	}
	
	/* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
	public boolean remove(Chamada elem)
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
		tamanho--;
		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.println("Id: " + p.dado.getId() + " Custo: " + p.dado.getCusto());
		}
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		ListaDuplamente l1 = new ListaDuplamente();
		l1.insere(2);l1.insere(10);l1.insere(5);l1.insere(11);l1.insere(10);l1.insere(2);
		l1.imprime();
	}
}