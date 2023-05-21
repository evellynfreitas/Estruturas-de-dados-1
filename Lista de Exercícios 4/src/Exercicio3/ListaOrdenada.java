package Exercicio3;

public class ListaOrdenada extends Lista<String>
{
	/* Insere elemento na lista na posi��o adequada, mantendo-a ordenada. */
	public void insere(String nome)
	{
		Elo p, q;
		Elo ant = null;
		
		q = new Elo(nome);
		
		for (p = prim; ((p != null) && (p.dado.compareTo(nome) < 0)); p = p.prox)
			ant = p;
		
		if (ant == null)
			prim = q;
		else
			ant.prox = q;
		
		q.prox = p;
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(String nome)
	{
		Elo p;
		Elo ant = null; /* refer�ncia para anterior */
		
		for(p = prim; ((p != null) && (p.dado.compareTo(nome) < 0)); p = p.prox)
			ant = p;
		
		/* Se p � null ou p.dado != elem, ent�o n�o encontrou elemento. */
		if ((p == null) || (!p.dado.equals(nome)))
			return false;
		
		if (p.equals(prim))
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		/* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
		 * o Garbage Collector ir� liberar essa mem�ria. */
		p = null;
		
		return true;
	}

}