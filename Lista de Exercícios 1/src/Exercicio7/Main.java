package Exercicio7;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Entre com uma expressao: ");
		String s = scanner.nextLine();
		Interpretador interpretador = new Interpretador(s);
		
		if(interpretador.interpretaExpressao())
			System.out.println("Resultado: "+interpretador.retornaResultado());
		else
			System.out.println("Expressao invalida!\nCheque os parenteses e os outros caracteres.");
		
		scanner.close();
	}

}
