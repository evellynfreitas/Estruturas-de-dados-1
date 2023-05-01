package Exercicio6;

public class Main {

	public static void main(String[] args) {
		int n = 16;
		
		CalculadoraBinaria calculadora = new CalculadoraBinaria(n);

		for(String binario: calculadora.retornarBinarios())
			System.out.println(binario);
	}

}
