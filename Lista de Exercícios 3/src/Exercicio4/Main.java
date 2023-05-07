package Exercicio4;

public class Main {

	public static void main(String args[]) {
		
		Pilha pilha = new Pilha(5);
		System.out.println(pilha.contaPares()); // tem 0 pares
		
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.push(4);
		pilha.push(5);
		
		System.out.println(pilha.contaPares()); // pilha: 5 4 3 2 1 --> 2 pares
		
		pilha.pop();
		pilha.pop();
		pilha.pop();
		
		System.out.println(pilha.contaPares()); // pilha: 2 1 --> 1 par
		
		pilha.push(6);
		pilha.push(8);
		pilha.push(10);
		
		System.out.println(pilha.contaPares()); // pilha: 10 8 6 2 1 --> 4 pares
	}
}
