package Exercicio6;

public class ListaDeArquivos {

	protected Elo prim ;
	private int tamanho;
	
	protected class Elo
	{
		protected Arquivo dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(Arquivo elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(Arquivo elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public ListaDeArquivos()
	{
		prim = null;
		tamanho = 0;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Insere elemento no in�cio da lista. */
	public void insere(Arquivo novo)
	{
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
		tamanho++;
	}
	
	/* Verifica se um determinado elemento est� na lista. */
	public boolean busca(Arquivo elem)
	{
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado.equals(elem))
				return true;
		}
		
		return false;
	}
	
	/* Implementa��o recursiva do m�todo de busca. */
	public boolean buscaRecursiva(Arquivo elem)
	{
		if(this.vazia())
			return false;
		
		return buscaRecursiva(elem, prim);
	}
	
	private boolean buscaRecursiva(Arquivo elem, Elo p)
	{
		if(p == null)
			return false;
		
		if(p.dado.equals(elem))
			return true;
		
		return buscaRecursiva(elem, p.prox);
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(Arquivo elem)
	{
		Elo p;
		Elo ant = null; /* Refer�ncia para anterior. */
		
		for(p = prim; ((p != null) && (!p.dado.equals(elem))); p = p.prox)
			ant = p;
		
		/* Se p � null, ent�o n�o encontrou elemento. */
		if (p == null)
			return false;
		
		if (p.equals(prim))
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		
		p = null;
		tamanho --;
		return true;
	}
	
	public void imprimeArquivos()
	{
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.println("\t" + p.dado.getNome());
		}
		
		System.out.println();
	}
	
	/* Implementa��o recursiva da fun��o de impress�o. */
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
		if(p == null)
			return;
		
		System.out.print(p.dado + " ");
		
		imprimeRecursivo(p.prox);
	}
	
	public int tamanho()
	{
		return tamanho;
	}
}
