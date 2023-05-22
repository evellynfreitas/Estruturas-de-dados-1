package Exercicio4;

public class Lista
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	private int tamanho;
	
	protected class Elo
	{
		protected String dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(String elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(String elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista()
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
	public void insere(String novo)
	{
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
		tamanho++;
	}
	
	/* Verifica se um determinado elemento est� na lista. */
	public boolean busca(String elem)
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
	public boolean buscaRecursiva(String elem)
	{
		if(this.vazia())
			return false;
		
		return buscaRecursiva(elem, prim);
	}
	
	private boolean buscaRecursiva(String elem, Elo p)
	{
		if(p == null)
			return false;
		
		if(p.dado.equals(elem))
			return true;
		
		return buscaRecursiva(elem, p.prox);
	}

	/* Remove da lista o primeiro elemento com valor igual a �elem". Ret. true se removeu. */
	public boolean remove(String elem)
	{
		Elo p;
		Elo ant = null; /* Refer�ncia para anterior. */
		
		for(p = prim; ((p != null) && (!p.dado.equals(elem))); p = p.prox)
			ant = p;
		
		/* Se p � null, ent�o n�o encontrou elemento. */
		if (p == null)
			return false;
		
		if (p == prim)
			prim = prim.prox; /* Remove elemento do in�cio. */
		else
			ant.prox = p.prox;  /* Remove elemento do meio. */
		
		
		p = null;
		tamanho --;
		return true;
	}
	
	/* Imprime todos os elementos da lista. */
	public void imprime()
	{
		Elo p;
		
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.println(p.dado + " ");
		}
		
		System.out.println();
	}
	
	public int tamanho()
	{
		return tamanho;
	}

	public void insereFrase(String frase) {
		
		
		String[] palavras = frase.split(" ");
		String pontuacao = "!?,.";

		for(String p: palavras) {
			if(pontuacao.contains("" + p.charAt(p.length()-1))) {
				this.insere(p.substring(0, p.length()-1));
				this.insere("" + p.charAt(p.length()-1));
			}
			else
				this.insere(p);
		}
		
	}
	
	public String retornaFrase() {
		String frase = "";
		
		Elo p;
		
		for(p=prim;p!=null;p=p.prox)
			frase = p.dado + " " + frase;
		
		return frase;
	}
	
}