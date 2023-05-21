package Exercicio4;

public class Main {

	public static void main(String[] args) {
		String frase = "Oi, meus amiguinhos!";
		Lista lista = new Lista();
		lista.insereFrase(frase);
		
		System.out.println(lista.retornaFrase());
	}

}
