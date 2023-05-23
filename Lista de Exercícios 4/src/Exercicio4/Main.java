package Exercicio4;

public class Main {

	public static void main(String[] args) {
		String frase = "Oi, meus amiguinhos!";
		Lista lista = new Lista();
		lista.insereFrase(frase);
		lista.imprime();
		System.out.println(lista.retornaFrase());
	}

}
