package Exercicio2;

public class ListaCircular extends Lista
{
	/* Imprime todos os elementos da lista */
	public void imprime()
	{
		Elo p;
		System.out.println("Elementos da lista");
		
		p = prim;
		
		if (p != null)
		{
			do
			{
				System.out.print(p.dado + " ");
				p = p.prox;

			} while (p != prim);
		}
		
		System.out.println();
	}
	
	public void imprimeRecursivo()
	{
		System.out.println("Elementos da lista:");
		
		if(this.vazia())
			return;
		
		imprimeRecursivo(prim);
		
		System.out.println();
	}
	
	private void imprimeRecursivo(Elo p)
	{
		System.out.print(p.dado + " ");
		
		if(p.prox == prim)
			return;
		
		imprimeRecursivo(p.prox);
	}

	/* Insere elemento no fim da lista. */
	public void insere(int novo)
	{
		Elo p, q;
		q = new Elo(novo);
		p = prim;

		if (p != null)
		{
			/* Percorre até alcancar o início. */
			while (p.prox != prim)
			{
				p = p.prox;
			}

			p.prox = q;
			q.prox = prim;
		}
		else
		{
			prim = q;
			prim.prox = q;     
		}
	}
	
	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p = null;
		Elo ant = null;

		if (prim == null) return false;

		for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
			ant = p;

		/* Achou */
		if ( p.dado == elem )
		{
			/* É o primeiro */     
			if ( p == prim )
			{
				/* É o único */
				if ( prim == prim.prox )
				{
					prim = null;  
				}
				else
				{
					/* Guarda o anterior ao primeiro */
					for( ant = prim; ( ant.prox != prim ); ant = ant.prox);
					
					ant.prox = prim.prox; 
					prim = prim.prox; 
				}     
			}   
			else
			{
				/* No meio */
				ant.prox = p.prox;     
			} 

			/* Remove a última referência para o elo a ser removido. Dessa forma,
			 * o Garbage Collector irá liberar essa memória. */
			p = null;

			return true;    
		}
		else  
			return false;
	}
	
	/* Resolução da questão 3 da lista auxiliar de Lista Encadeada. */
	public Lista separa(int n)
	{
		Lista l2 = new Lista();
		
		Elo p = prim;
		
		/* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
		do
		{
			/* Encontrou o elemento desejado. */
			if(p.dado == n)
				break;
			
			p = p.prox;
			
		} while (p != prim);
				
		/* Caso tenha percorrido a lista sem encontrar o elemento. */
		if(p.dado != n)
			return null;
		
		/* O "prim" da nova lista é o próximo do elo apontado por p. */
		l2.prim = p.prox;
		
		/* O próximo do elo apontado por p tem que apontar para o prim da
		 * lista original. */
		p.prox = prim;
		
		Elo q;
		
		/* Anda até o último elemento da lista 2. */
		for(q = l2.prim; q.prox != prim; q = q.prox);
		
		/* O próximo do último elemento da lista 2 aponta para o primeiro. */
		q.prox = l2.prim;

		/* Retorna a nova lista construída. */
		return l2;
	}
	
	public ListaCircular merge(ListaCircular lista2) {
		
		ListaCircular lista3 = new ListaCircular();
		Elo p = prim;
		Elo p2 = lista2.prim;
		
		while(true) {
			
			if(p!=null) {
				lista3.insere(p.dado);
				p = p.prox;
				
				if(p == prim)
					p = null;
			}
			
			if(p2!=null) {
				lista3.insere(p2.dado);
				p2 = p2.prox;
				
				if(p2 == lista2.prim)
					p2 = null;
			}
			
			if(p2 == null && p == null)
				break;
		}
		
		return lista3;
	}
	
	public static void main(String[] args) {
		
		//apenas para testar
		ListaCircular l1 = new ListaCircular();
		l1.insere(1); l1.insere(5); l1.insere(9);
		
		ListaCircular l2 = new ListaCircular();
		l2.insere(2); l2.insere(4); l2.insere(6); l2.insere(8);
		
		ListaCircular l3 = l1.merge(l2);
		l3.imprime();
	}

	
}