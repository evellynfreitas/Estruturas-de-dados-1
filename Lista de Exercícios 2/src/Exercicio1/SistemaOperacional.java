package Exercicio1;

public class SistemaOperacional{
	
	private FilaDeProcessos fila;

	public SistemaOperacional(int n) {
		fila = new FilaDeProcessos(n);
	}
	
	public boolean inserirProcesso(Processo p) {
		return fila.insere((p));
	}
	
	public Processo removerProcesso() {
		return fila.remove();
	}
	
	public void listarProcessos() {
		fila.imprime();
	}
	
	
}
