package Exercicio6;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entre com uma frase: ");
		String s = scanner.nextLine();
		Pilha pilha = new Pilha(s.length());
		
		System.out.println("Frase invertida: "+pilha.inverteFrase(s));
		scanner.close();
	}

}
