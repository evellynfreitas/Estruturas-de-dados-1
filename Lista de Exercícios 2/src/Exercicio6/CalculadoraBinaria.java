package Exercicio6;

public class CalculadoraBinaria {
	
	private Fila fila;
	private String[] numerosBinarios;
	private int tamanho;

	public CalculadoraBinaria(int n) {
		fila = new Fila(n);
		numerosBinarios = new String[n];
		tamanho = n;
	}
	
	private void calcular() {
		fila.insere("1");
		
		for(int i = 0; i<tamanho; i++) {
			String aux= fila.remove();
			numerosBinarios[i] = aux;
			fila.insere(aux+"0");
			fila.insere(aux+"1");
		}
	}
	
	public String[] retornarBinarios() {
		calcular();
		return numerosBinarios;
	}
}
