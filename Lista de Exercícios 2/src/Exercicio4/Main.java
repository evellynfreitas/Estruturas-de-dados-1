package Exercicio4;

public class Main {

	public static void main(String[] args) {
		
		FilaDupla filaDupla;
		Fila fila = new Fila(5);
		
		fila.insere(1);fila.insere(2);fila.insere(3);fila.insere(4);fila.insere(5);
		
		filaDupla = Fila.retornaFilaDupla(fila);
		
		filaDupla.imprime();
		System.out.println();
		
		filaDupla.removeFim();
		filaDupla.remove();
		filaDupla.imprime();

		System.out.println();
		
		filaDupla.insere(9);
		filaDupla.insereInicio(8);
		filaDupla.imprime();
	}

}
