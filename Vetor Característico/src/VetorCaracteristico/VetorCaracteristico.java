package VetorCaracteristico;

public class VetorCaracteristico {

	private boolean[] vetor;
	private int tamanho;
	private int cardinalidade;
	
	public VetorCaracteristico(int n) {
		tamanho = n;
		vetor = new boolean[tamanho+1];
		cardinalidade = 0;
		esvaziarConjunto();
	}
	
	public boolean inserirElemento(int n) {
		if(n > tamanho || n <= 0)
			return false;
		else {
			vetor[n] = true;
			cardinalidade++;
			return true;
		}
	}
	
	public boolean removerElemento(int n) {
		if(n > tamanho || n <= 0)
			return false;
		else {
			vetor[n] = false;
			cardinalidade--;
			return true;
		}
	}
	
	public boolean verificarPertinencia(int n) {
		if(n > tamanho || n <= 0)
			return false;
		else
			return vetor[n];
		
	}
	
	public void esvaziarConjunto() {
		for(int i = 1; i <= tamanho; i++)
			vetor[i] = false;
	}
	
	public int retornaCardinalidade() {
		return cardinalidade;
	}
	
	public boolean verificaVazio() {
		for(int i = 1; i <= tamanho; i++) {
			if(vetor[i])
				return false;
		}
		return true;
	}
	
	public boolean verificaUniverso() {
		for(int i = 1; i <= tamanho; i++) {
			if(!vetor[i])
				return false;
		}
		return true;
	}
		
	public boolean verificaSubConjunto(VetorCaracteristico v) {
		
		for(int i=1; i <= v.tamanho; i++) {
			
			if(i<=this.tamanho) {
				
				if(!vetor[i] && v.vetor[i])
					return false;
			}
			else {
				//se for um conj com mais elementos e tiver alguma posição "true" ele deixa de ser subconjunto
				if(v.vetor[i])
					return false;
			}
			
		}
		return true;
	}
	
	public boolean verificaSubProprio(VetorCaracteristico v) {
		
		int a = 0;
		
		for(int i=1; i <= v.tamanho || i<=this.tamanho; i++) {
			
			if(i<=this.tamanho && i <= v.tamanho) {
				
				if(!this.vetor[i] && v.vetor[i])
					return false;
				
				else if(this.vetor[i] && !v.vetor[i])
					a++;
			}
			else if(i<=this.tamanho) {
				if(this.vetor[i])
					a++;
			}
			else if(i<=v.tamanho) {
				if(v.vetor[i])
					return false;
			}
			
		}
		
		if(a>0)
			return true;
		else
			return false;
	}

	public VetorCaracteristico uniao(VetorCaracteristico v) {
		
		int tam;
		
		if(v.tamanho > this.tamanho)
			tam = v.tamanho;
		else
			tam = this.tamanho;
		
		VetorCaracteristico uniao = new VetorCaracteristico(tam);
		
		for(int i = 1; i <= tam; i++) {
			
			if(i <= this.tamanho && i <= v.tamanho)
				uniao.vetor[i] = (this.vetor[i] || v.vetor[i]);
			
			else if (i <= this.tamanho)
				uniao.vetor[i] = this.vetor[i];
			
			else if (i <= v.tamanho)
				uniao.vetor[i] = v.vetor[i];
			
		}
		
		return uniao;
	}

	public VetorCaracteristico intersecao(VetorCaracteristico v) {
		
		int tam;
		
		if(v.tamanho > this.tamanho)
			tam = v.tamanho;
		else
			tam = this.tamanho;
		
		VetorCaracteristico inter = new VetorCaracteristico(tam);
		
		for(int i = 1; i <= tam; i++) {
			
			if(i <= this.tamanho && i <= v.tamanho)
				inter.vetor[i] = (this.vetor[i] && v.vetor[i]);
			else
				break;
		}
		
		return inter;
		
	}

	public int retornaMenor() {
		for(int i=1; i<=tamanho; i++)
			if(vetor[i])
				return i;
		
		return Integer.MIN_VALUE;
	}
	
	public int retornaMaior() {
		for(int i=tamanho; i>=1; i--)
			if(vetor[i])
				return i;
		
		return Integer.MAX_VALUE;
	}
	

}