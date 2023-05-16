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
}
