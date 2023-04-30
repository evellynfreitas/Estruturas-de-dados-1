package Exercicio6;

public class Main {

	public static void main(String[] args) {
		int n = 10;
		
		CalculadoraBinaria calculadora = new CalculadoraBinaria(n);

		for(String binario: calculadora.retornarBinarios())
			System.out.print(binario+" ");
	}

}
