package Exercicio1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada;
		
		System.out.print("Digite a String: ");
		entrada = scanner.next();
		
		Pilha pilha = new Pilha(entrada.length());
		
		if(pilha.verificaString(entrada))
			System.out.println("As Strings s�o inversas");
		else
			System.out.println("A String est� no formato incorreto");
		
		scanner.close();
	}

}
