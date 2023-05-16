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
	
	public static VetorCaracteristico uniao(VetorCaracteristico c1, VetorCaracteristico c2, int tamanhoUniverso) {
		VetorCaracteristico v = new VetorCaracteristico(tamanhoUniverso);
		
		for(int i = 0; i < tamanhoUniverso; i++) {
			if(c1.retornaPeloIndice(i) + c2.retornaPeloIndice(i) != 0)
				v.inserirElemento(i);
		}
		
		return v;
	}
}
