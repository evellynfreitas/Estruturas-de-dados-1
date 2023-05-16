package VetorCaracteristico;

public class VetorCaracteristico {

	private int[] vetor;
	private int tamanho;
	
	public VetorCaracteristico(int n) {
		tamanho = n;
		vetor = new int[tamanho];
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
	
}
