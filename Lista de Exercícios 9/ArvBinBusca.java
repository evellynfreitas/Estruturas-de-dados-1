import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> 
{
	private No raiz; /* Raiz da árvore. */
	
	private class No
	{
		private Chave chave; /* Chave usada nas comparações. */
		private Valor valor; /* Informação armazenada. */
		private No esq, dir; /* Referências para subárvores esquerda e direita. */

		/* Cria um nó com chave e valor fornecidos e esq = dir = null. */
		public No(Chave chave, Valor valor)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = null;
			this.dir = null;
		}
		
		public No(Chave chave)
		{
			this.chave = chave;
			this.valor = null;
			this.esq = null;
			this.dir = null;
		}
		
		
		/* Cria um nó com chave e valor fornecidos. As subárvores esq e dir são
		 * passadas por parâmetro. */
		public No(Chave chave, Valor valor, No esq, No dir)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	/**
	 *  Criação de uma árvore vazia. 
	 */
	public ArvBinBusca()
	{
		raiz = null;
	}
	
	/** 
	 * Verifica se a árvore está vazia.
	 * 
	 * @return se a árvore está vazia ou possui algum elemento
	 */
	public boolean vazia()
	{
		return (raiz == null);
	}
	
	/**
	 * Apresenta o conteúdo da árvore em ordem simétrica.
	 */
	public void mostra()
	{
		mostra(raiz);
	}
	
	private void mostra(No x)
	{
		/* Caso base (critério de parada). */
		if(x == null)
			return;
		
		System.out.print("[");
		
		/* Chamada recursiva para a esquerda. */
		mostra(x.esq);
		
		/* Imprime a chave do nó corrente. */
		System.out.print("<" + x.chave + ">");
		
		/* Chamada recursiva para a direita. */
		mostra(x.dir);
		
		System.out.print("]");
	}
	
    /**
     * Retorna a menor chave da árvore.
     *
     * @return a menor chave da árvore
     * @throws NoSuchElementException se a árvore está vazia
     */
    public Chave min()
    {
        if(vazia()) 
        	throw new NoSuchElementException("Árvore está vazia!");
        
        return min(raiz).chave;
    } 

    private No min(No x) { 
        if (x.esq == null) 
        	return x; 
        else
        	return min(x.esq); 
    }
    
    /**
     * Retorna o maior elemento da árvore.
     *
     * @return o maior elemento da árvore
     * @throws NoSuchElementException se a árvore está vazia
     */
    public Chave max() {
        if(vazia()) 
        	throw new NoSuchElementException("A árvore está vazia!");
        
        return max(raiz).chave;
    } 

    private No max(No x) {
        if (x.dir == null)
        	return x; 
        else
        	return max(x.dir); 
    }
    
    /**
     * Retorna o número de nós, isto é, pares (chave, valor), contidos na árvore 
     * binária de busca.
     * 
     * @return o número de nós da árvore
     */
    public int tamanho()
    {
    	return tamanho(raiz);
    }
    
    private int tamanho(No x)
    {
    	/* Caso base (critério de parada). */
    	if(x == null)
    		return 0;
    	
    	/* Chamada recursiva para subárvores esquerda e direita. */
    	return 1 + tamanho(x.esq) + tamanho(x.dir);
    }
    
    
    /**
     * Retorna a altura da árvore binária de busca.
     *
     * @return a altura da árvore (uma árvore de um único nó possui altura 0)
     */
    public int altura()
    {
    	return altura(raiz);
    }
    
    private int altura(No x)
    {
    	if(x == null)
    		return -1;
    	
    	int maxAltura = Math.max(altura(x.esq), altura(x.dir));
    	
    	return 1 + maxAltura;
    }
    
    
    /**
     * Essa árvore binária de busca contém a chave fornecida?
     *
     * @param  chave a chave fornecida
     * @return {@code true} se a árvore contém a chave {@code chave} e
     *         {@code false} caso contrário
     * @throws IllegalArgumentException se {@code key} é {@code null}
     */
    public boolean contem(Chave chave) {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida é null!");
        
        return get(chave) != null;
    }
	
    /**
     * Retorna o valor associado à chave fornecida.
     *
     * @param  chave a chave a ser buscada
     * @return o valor associado à chave fornecida se tal chave se encontra na árvore
     *         e {@code null} se a chave não está na árvore
     * @throws IllegalArgumentException if {@code chave} is {@code null}
     */
    public Valor get(Chave chave) 
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave) 
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida é null!");
        
        /* A chave não se encontra na árvore. */
        if(x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	return get(x.dir, chave);
        else /* Chave encontrada. */
        	return x.valor;
    }
    
    /**
     * Insere na árvore binária de busca o par (chave, valor) fornecido. Caso a árvore
     * já possua a chave especificada, o valor antigo é sobrescrito com o novo valor 
     * fornecido. Remove o nó de chave igual à chave fornecida caso o valor especificado
     * seja {@code null}.
     *
     * @param  chave a chave fornecida
     * @param  valor o valor fornecido
     * @throws IllegalArgumentException se {@code chave} é {@code null}
     */
    public void put(Chave chave, Valor valor)
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida é null!");
        
        if(valor == null) {
            delete(chave);
            return;
        }
        
        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
    	/* Caso base: encontrou a posição de inserção. */
        if (x == null)
        	return new No(chave, valor);
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado nó de mesma chave. */
        	x.valor = valor;
        
        return x;
    }
	
    /**
     * Remove o nó de menor chave da árvore.
     *
     * @throws NoSuchElementException se a árvore está vazia
     */
    public void deleteMin() 
    {
        if(vazia())
        	throw new NoSuchElementException("A árvore está vazia!");
        
        raiz = deleteMin(raiz);
    }

    /* Método recursivo que anda sempre para a esquerda, procurando o nó
     * de menor chave a ser removido. */
    private No deleteMin(No x) 
    {
    	/* Caso não haja filho à esquerda, o nó corrente possui a menor chave. */
        if(x.esq == null) 
        	return x.dir;
        
        x.esq = deleteMin(x.esq);
        
        return x;
    }

    /**
     * Remove o nó de maior chave da árvore.
     *
     * @throws NoSuchElementException se a árvore está vazia
     */
    public void deleteMax()
    {
        if(vazia())
        	throw new NoSuchElementException("A árvore está vazia!");
        
        raiz = deleteMax(raiz);
    }

    /* Método recursivo que anda sempre para a direita, procurando o nó
     * de maior chave a ser removido. */
    private No deleteMax(No x) 
    {
        if(x.dir == null)
        	return x.esq;
        
        x.dir = deleteMax(x.dir);
        
        return x;
    }
    
    /**
     * Remove o nó cuja chave seja igual à {@code chave} fornecida.
     * 
     * @param chave a chave fornecida
     * @return {@code true} se foi possível remover o nó de chave {@code chave} e
     *         {@code false} caso contrário
     */
    public void delete(Chave chave)
    {    	
    	raiz = delete(raiz, chave);    	
    }
    
    /* Remove o nó com o valor "val" da "árvore" a partir do nó para o qual está sendo chamada a função. Obs: "ref_no" é o ponteiro que referencia o nó para o qual está sendo chamada a função, o qual pode ter que ser modificado. Retorna false se o valor não pertencer à "árvore".
    */
    private No delete(No x, Chave chave)
    {
    	if (x == null)
    		return null;

    	int cmp = chave.compareTo(x.chave);
    	
    	if(cmp < 0)
    		x.esq = delete(x.esq, chave);
    	else if(cmp > 0)
    		x.dir = delete(x.dir, chave);
    	else
    	{ 
    		if(x.dir == null)
    			return x.esq;
    		if(x.esq  == null)
    			return x.dir;
    		
    		No t = x;

    		/* Pega o menor da subárvore direita (mais à esquerda). */
    		x = min(t.dir);

    		/* Remove o menor. */
    		x.dir = deleteMin(t.dir);

    		/* A subárvore esquerda se mantém a mesma. */
    		x.esq = t.esq;
    	}

    	return x;
    }
    
    
    /**
     * Retorna a maior chave na árvore que é menor ou igual à {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a maior chave na árvore menor ou igual à {@code chave}
     * @throws NoSuchElementException se a árvore está vazia
     * @throws IllegalArgumentException se a {@code chave} é {@code null}
     */
    public Chave piso(Chave chave)
    {
        if (chave == null)
        	throw new IllegalArgumentException("A chave fornecida é null!");
        
        if (vazia()) 
        	throw new NoSuchElementException("A árvore está vazia!");
        
        No x = piso(raiz, chave);
        
        if (x == null)
        	return null;
        else
        	return x.chave;
    } 

    private No piso(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp <  0)
        	return piso(x.esq, chave);
        
        No t = piso(x.dir, chave);

        if (t != null) 
        	return t;
        else
        	return x; 
    }

    
    /**
     * Retorna a menor chave na árvore que é maior ou igual à {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a menor chave na árvore maior ou igual à {@code chave}
     * @throws NoSuchElementException se a árvore está vazia
     * @throws IllegalArgumentException se a {@code chave} é {@code null}
     */
    public Chave topo(Chave chave)
    {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida é null!");

        if (vazia())
        	throw new NoSuchElementException("A árvore está vazia!");
        
        No x = topo(raiz, chave);
        
        if (x == null)
        	return null;
        else 
        	return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp < 0)
        { 
            No t = topo(x.esq, chave);
            
            if (t != null)
            	return t;
            else
            	return x; 
        } 
        
        return topo(x.dir, chave); 
    } 
    
    
    /**
     * Retorna o número de nós na árvore cujas chaves são estritamente menores do que {@code chave}.
     *
     * @param  chave a chave fornecida
     * @return o número de nós na árvore cujas chaves são estritamente menores do que {@code chave}
     * @throws IllegalArgumentException se {@code chave} é {@code null}
     */
    public int rank(Chave chave) {
    	/* O aluno deve fazer como exercício. */
    	return 0;
    } 

    // Número de chaves na subárvore que são estritamente menores do que chave.
    private int rank(Chave chave, No x) {
    	/* O aluno deve fazer como exercício. */
    	return 0;
    } 

    
    // exercicio 3
    
    public void transformaArvBinBusca(Arvbin<Chave> arvoreBinaria) {
    	raiz = andaPelaArvore(arvoreBinaria);
    }
    
    private No andaPelaArvore(Arvbin<Chave> arvore) {
    	System.out.println();
    	raiz = transformaArvBinBusca(raiz, arvore);
    	this.mostra();
    	Arvbin<Chave> esq = arvore.retornaEsq();
    	Arvbin<Chave> dir = arvore.retornaDir();
    	
    	if(esq != null)
    		raiz = andaPelaArvore(esq);
    	
    	if(dir != null)
    		raiz = andaPelaArvore(dir);
    	
    	return raiz;
    }
    
    private No transformaArvBinBusca(No x, Arvbin<Chave> arvore) {
    	if(x == null)
    		return new No(arvore.retornaVal());
    	
    	if(arvore.retornaVal().compareTo(x.chave) < 0)
    		x.esq = transformaArvBinBusca(x.esq, arvore);
    	
    	else if(arvore.retornaVal().compareTo(x.chave) > 0)
    		x.dir = transformaArvBinBusca(x.dir, arvore);
    	
    	return x;
    }
    
    // exercicio 4
    
    public boolean removeForaIntervalo(Chave chaveMin, Chave chaveMax) {
    	int tamOriginal = tamanho();
    	raiz = removeForaIntervalo(chaveMin, chaveMax, raiz);
    	
    	if(tamOriginal == tamanho())
    		return false;
    	else
    	return true;
    }
    
    private No removeForaIntervalo(Chave chaveMin, Chave chaveMax, No no) {
    	if(no == null)
    		return null;
    	
    	else {
    		
    		if(no.chave.compareTo(chaveMax)<0)
    			no.dir = removeForaIntervalo(chaveMin, chaveMax, no.dir);
    		
    		if(no.chave.compareTo(chaveMin)>0)
    			no.esq = removeForaIntervalo(chaveMin, chaveMax, no.esq);
    		
    		if(no.chave.compareTo(chaveMin)>=0 && no.chave.compareTo(chaveMax)<=0) {

    			if(no.dir == null && no.esq == null)
    				return null;
    			
    			else if(no.esq  == null)
        			return no.dir;
    			
    			else if(no.dir == null)
        			return no.esq;
    			
    			else
    				return no.esq;
    		}
    		
    		return no;
    	}
    	
    }
    
    // exercicio 5
    
    
}