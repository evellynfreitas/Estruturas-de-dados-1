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
	
	public int retornaPeloIndice(int indice) {
		return vetor[indice];
	}
	
	public boolean verificaSubProprio() {
		for(int i = 0; i < tamanho; i++) {
			if(vetor[i] == 0)
				return true;
		}
		return false;
	}
	
	public VetorCaracteristico uniao(VetorCaracteristico c1) {
		
		for(int i = 0; i < tamanho; i++) {
			if(this.vetor[i] + c1.vetor[i] > 0)
				this.vetor[i] = 1;
		}
		
		return this;
	}
	
	public VetorCaracteristico intersecao(VetorCaracteristico c1) {
		
		for(int i = 0; i < tamanho; i++) {
			if(this.vetor[i] * c1.vetor[i] == 1)
				this.vetor[i] = 1;
			else
				this.vetor[i] = 0;
		}
		
		return this;
	}

	public int retornaMenor() {
		for(int i=0; i<tamanho; i++)
			if(vetor[i]==1)
				return vetor[i];
		
		return Integer.MIN_VALUE;
	}
	
	
}