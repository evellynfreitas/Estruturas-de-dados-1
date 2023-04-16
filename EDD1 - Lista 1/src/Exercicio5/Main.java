package Exercicio5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite a sequencia: ");
		String s = scanner.next();
		Pilha pilha = new Pilha(s.length());
		
		if(pilha.verificaSequencia(s))
			System.out.println("A sequencia esta balenceada");
		else
			System.out.println("A sequencia nao esta balanceada");
		
		scanner.close();
	}

}
