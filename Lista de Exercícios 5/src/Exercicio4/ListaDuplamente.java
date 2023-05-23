package Exercicio4;

public class ListaDuplamente
{
	/* Referência para primeiro elemento */
	protected Elo prim;
	protected int tamanho;
	
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
		tamanho = 0;
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
		tamanho++;
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
	
	public void trocaElos(int indiceElo1, int indiceElo2) {
		Elo p = prim;
		
		Elo elo1=new Elo(), ant1=null, pos1=null;
		Elo elo2=new Elo(), ant2=null, pos2=null;
		
		if(this.vazia())
			return;
		else if(indiceElo1 >= tamanho || indiceElo2 >= tamanho)
			return;
		
		
		for(int i=0; p!=null;i++) {
			
			if(i<indiceElo1)
				ant1 = p;
			else if(i==indiceElo1) {
				elo1 = p;
				pos1 = p.prox;
			}
			
			if(i<indiceElo2)
				ant2 = p;
			else if(i==indiceElo2) {
				elo2 = p;
				pos2 = p.prox;
			}
			
			if(i>=indiceElo2 && i>=indiceElo1)
				break;
			
			p = p.prox;
		}
		
		imprime();
		
		elo2.prox = pos1;
		elo2.ant = ant1;
		elo1.prox = pos2;
		elo1.ant = ant2;
		
		imprime();
		
		if(ant1!=null)
			ant1.prox = elo2;
		else
			prim = elo2;
		
		if(ant2!=null)
			ant2.prox = elo1;
		else
			prim = elo1;
		
		if(pos1!=null)
			pos1.ant = elo2;
		
		if(pos2!=null)
			pos2.ant = elo1;
		
	}


	public static void main(String[] args) {
		ListaDuplamente l1 = new ListaDuplamente();
		l1.insere(5); l1.insere(4); l1.insere(3); l1.insere(2); l1.insere(1); l1.insere(0);
		l1.imprime();
		l1.trocaElos(5,0);
		l1.imprime();
	}
}