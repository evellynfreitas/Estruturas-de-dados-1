package Exercicio6;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	protected int tamanho;
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
	}
	
	/* Testa se a lista está vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	public void insere(Chamada novo)
	{
		Elo p = new Elo(novo);
		
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
			post.ant = p;
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
		Elo p = busca(elem);
		
		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim) 
			prim = prim.prox;
		
		/* Retira elemento do meio */
		else
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
		//apenas para teste
		ListaDuplamente l1 = new ListaDuplamente();
		int id = 0;
		Chamada c1 = new Chamada(10,++id);
		Chamada c2 = new Chamada(5,++id);
		Chamada c3 = new Chamada(11,++id);
		Chamada c4 = new Chamada(10,++id);
		Chamada c5 = new Chamada(12,++id);
		
		l1.insere(c1);
		l1.insere(c2);
		l1.insere(c3);
		l1.insere(c4);
		l1.insere(c5);
		l1.imprime();
		
		l1.remove(c1);
		
		l1.imprime();
		
	}
}