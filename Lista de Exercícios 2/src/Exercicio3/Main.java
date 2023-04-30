package Exercicio3;

public class Main {

	public static void main(String[] args) {

		FilaDePilhas<Integer> filaDePilhas = new FilaDePilhas<Integer>(10);
	
		PilhaGenerica<Integer> pilha1 = new PilhaGenerica<Integer>(10);
		pilha1.push(1);pilha1.push(2);pilha1.push(3);
		filaDePilhas.insere(pilha1);
		
		PilhaGenerica<Integer> pilhanova = filaDePilhas.remove();

		while(!pilhanova.vazia()) {
			System.out.println(pilhanova.pop());
		}
	}

}
