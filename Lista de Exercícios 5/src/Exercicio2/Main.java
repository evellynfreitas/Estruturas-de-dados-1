package Exercicio2;

public class Main {

	public static void main(String[] args) {

		ListaOrdenada l1 = new ListaOrdenada();
		l1.insere(1);l1.insere(4);l1.insere(5);l1.insere(6);l1.insere(10);
		
		ListaOrdenada l2 = new ListaOrdenada();
		l2.insere(2);l2.insere(3);l2.insere(5);l2.insere(7);l2.insere(10);
		
		ListaOrdenada l3 = ListaOrdenada.concatena(l1,l2);
		
		l3.imprime();
	}

}
