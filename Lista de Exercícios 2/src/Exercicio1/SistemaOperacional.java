package Exercicio1;

public class SistemaOperacional {
	private FilaGenerica<Processo> filaDeProcessos;
	private int qtdMaximaProcessos;
	private int qtdAtualProcessos;

	public SistemaOperacional(int n) {
		filaDeProcessos = new FilaGenerica<Processo>(n);
		qtdMaximaProcessos = n;
		qtdAtualProcessos = 0;
	}
	
	public boolean inserirProcesso() {
		
		if(!filaDeProcessos.cheia()) {
			Processo p = new Processo(++qtdAtualProcessos);
			return filaDeProcessos.insere(p);
		}
		else
			return false;
		
	}
	
	public Processo removerProcesso() {
		return filaDeProcessos.remove();
	}
	
	
	
	
}
