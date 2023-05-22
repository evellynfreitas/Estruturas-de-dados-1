package Exercicio3;

public class Main {

	public static void main(String[] args) {
		ListaOrdenada lista = new ListaOrdenada();
		
		lista.insere("Julia");
		lista.insere("Laura");
		lista.insere("Beah");
		lista.insere("Ana");
		lista.insere("Anna");
		lista.insere("Daniela");
		
		lista.imprime();
		
		lista.remove("Anna");
		
		lista.imprime();
		
		System.out.println(lista.busca("Anna"));
	}

}
