package VetorCaracteristico;

public class VetorCaracteristico {

	private int[] vetor;
	private int tamanho;
	
	public VetorCaracteristico(int n) {
		tamanho = n;
		vetor = new int[tamanho];
		esvaziarConjunto();
	}
	
	public boolean inserirElemento(int x) {
		if(x > tamanho || x <= 0)
			return false;
		else {
			vetor[x-1] = 1;
			return true;
		}
	}
	
	public boolean removerElemento(int x) {
		if(x > tamanho || x <= 0)
			return false;
		else {
			vetor[x-1] = 0;
			return true;
		}
	}
	
	public boolean verificarPertinencia(int x) {
		if(x > tamanho || x <= 0)
			return false;
		else {
			if(vetor[x-1] == 0)
				return false;
			else
				return true;
		}
	}
	
	public void esvaziarConjunto() {
		for(int i = 0; i < tamanho; i++)
			vetor[i] = 0;
	}
	
	public int retornaCardinalidade() {
		return tamanho;
	}
	
	public boolean verificaVazio() {
		for(int i = 0; i < tamanho; i++) {
			if(vetor[i] == 1)
				return false;
		}
		return true;
	}
	
	public boolean verificaUniverso() {
		for(int i = 0; i < tamanho; i++) {
			if(vetor[i] == 0)
				return false;
		}
		return true;
	}
		
	public boolean verificaSubConjunto(VetorCaracteristico v) {
		
		for(int i=0; i < v.tamanho; i++) {
			
			if(i<this.tamanho) {
				
				if(this.vetor[i]==0 && v.vetor[i]==1)
					return false;
			}
			else {
				
				if(v.vetor[i]==1)
					return false;
			}
			
		}
		return true;
	}
	
	public boolean verificaSubProprio(VetorCaracteristico v) {
		
		int a = 0;
		
		for(int i=0; i < v.tamanho||i<this.tamanho; i++) {
			
			if(i<this.tamanho && i< v.tamanho) {
				
				if(this.vetor[i]==0 && v.vetor[i]==1)
					return false;
				
				else if(this.vetor[i]==1 && v.vetor[i]==0)
					a++;
			}
			else if(i<this.tamanho) {
				if(this.vetor[i]==1)
					a++;
			}
			else if(i<v.tamanho) {
				if(v.vetor[i]==1)
					return false;
			}
			
		}
		
		if(a>0)
			return true;
		else
			return false;
	}
	
	public VetorCaracteristico uniao(VetorCaracteristico c1) {
		
		int tam;
		
		if(c1.tamanho > this.tamanho)
			tam = c1.tamanho;
		else
			tam = this.tamanho;
		
		VetorCaracteristico v = new VetorCaracteristico(tam);
		
		for(int i = 0; i < tam; i++) {
			
			if(i < this.tamanho && i < c1.tamanho) {
				if(this.vetor[i] + c1.vetor[i] > 0)
					v.vetor[i] = 1;

			}
			else if (i < this.tamanho && this.vetor[i] == 1)
				v.vetor[i] = 1;
			
			else if (i < c1.tamanho && c1.vetor[i] == 1)
				v.vetor[i] = 1;
			
		}
		
		return v;
	}
	
	public VetorCaracteristico intersecao(VetorCaracteristico c1) {
		
		int tam;
		
		if(c1.tamanho > this.tamanho)
			tam = c1.tamanho;
		else
			tam = this.tamanho;
		
		VetorCaracteristico v = new VetorCaracteristico(tam);
		
		for(int i = 0; i < tam; i++) {
			
			if(i < this.tamanho && i < c1.tamanho) {
				if(this.vetor[i] * c1.vetor[i] == 1)
					v.vetor[i] = 1;
			}
		}
		
		return v;
		
	}

	public int retornaMenor() {
		for(int i=0; i<tamanho; i++)
			if(vetor[i]==1)
				return vetor[i];
		
		return Integer.MIN_VALUE;
	}
	
	public int retornaMaior() {
		for(int i=tamanho-1; i>=0; i--)
			if(vetor[i]==1)
				return vetor[i];
		
		return Integer.MAX_VALUE;
	}
	

}