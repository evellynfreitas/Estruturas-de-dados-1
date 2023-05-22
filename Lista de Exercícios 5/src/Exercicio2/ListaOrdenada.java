package Exercicio2;

public class ListaOrdenada extends Lista
{
	/* Insere elemento na lista na posição adequada, mantendo-a ordenada. */
	public void insere(int novo)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(novo);
		
		for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
	public boolean remove(int elem)
	{
		Elo p;
		Elo ant = null; /* referência para anterior */
		
		for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
			ant = p;
		
		/* Se p é null ou p.dado != elem, então não encontrou elemento. */
		if ((p == null) || (p.dado != elem))
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do início. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a última referência para o elo a ser removido. Dessa forma,
		 * o Garbage Collector irá liberar essa memória. */
		p = null;
		
		return true;
	}

	public static ListaOrdenada concatena(ListaOrdenada l1, ListaOrdenada l2) {
		ListaOrdenada nova = new ListaOrdenada();
		
		Elo p1 = l1.prim;
		Elo p2 = l2.prim;
		
		while(p1!=null || p2!=null) {
			if(p1!=null && p2!= null) {
				if(p1.dado < p2.dado) {
					nova.insere(p1.dado);
					p1 = p1.prox;
				}
				else if(p1.dado > p2.dado) {
					nova.insere(p2.dado);
					p2 = p2.prox;
				}
				else {
					nova.insere(p1.dado);
					p1 = p1.prox;
					p2 = p2.prox;
				}
			}
			else if(p1==null) {
				nova.insere(p2.dado);
				p2 = p2.prox;
			}
			else if(p2==null) {
				nova.insere(p1.dado);
				p1 = p1.prox;
			}
		}
		
		return nova;
	}

}