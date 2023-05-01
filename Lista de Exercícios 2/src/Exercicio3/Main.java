package Exercicio3;

public class Main {

	public static void main(String[] args) {

		//Filas e pilhas que serão utilizadas no teste
		
		Fila<Integer> f1 = new Fila<Integer>(3);
		f1.insere(1);f1.insere(2);f1.insere(3);
		
		Fila<Integer> f2 = new Fila<Integer>(3);
		f2.insere(4);f2.insere(5);f2.insere(6);
		
		Fila<Integer> f3 = new Fila<Integer>(3);
		f3.insere(1);f3.insere(2);f3.insere(3);
		
		Fila<Integer> f4 = new Fila<Integer>(3);
		f4.insere(4);f4.insere(5);f4.insere(6);
		
		PilhaGenerica<Integer> p1 = new PilhaGenerica<Integer>(3);
		p1.push(1);p1.push(2);p1.push(3);
		
		PilhaGenerica<Integer> p2 = new PilhaGenerica<Integer>(3);
		p2.push(4);p2.push(5);p2.push(6);
		
		
		//Teste Fila de Pilhas
		
		FilaDePilhas<Integer> filaDePilhas = new FilaDePilhas<Integer>(2);
		filaDePilhas.insere(p1);
		filaDePilhas.insere(p2);
		
		
		System.out.println("Fila de Pilhas:");
		
		PilhaGenerica<Integer> teste1 = filaDePilhas.remove();
		while(!teste1.vazia())
			System.out.println(teste1.pop());
		
		teste1 = filaDePilhas.remove(); 
		while(!teste1.vazia())
			System.out.println(teste1.pop());
		
		
		//Teste Fila de Filas
		
		FilaDeFilas<Integer> filaDeFilas = new FilaDeFilas<Integer>(2);
		filaDeFilas.insere(f1);
		filaDeFilas.insere(f2);
		
		
		System.out.println("Fila de Filas:");

		Fila<Integer> teste2 = filaDeFilas.remove();
		while(!teste2.vazia())
			System.out.println(teste2.remove());
		
		teste2 = filaDeFilas.remove();
		while(!teste2.vazia())
			System.out.println(teste2.remove());
		
		
		
		//Teste Pilha de Filas
		
		PilhaDeFilas<Integer> pilhaDeFilas = new PilhaDeFilas<Integer>(3);
		pilhaDeFilas.push(f3);
		pilhaDeFilas.push(f4);
		
		
		System.out.println("Pilha de Filas:");
		
		Fila<Integer> teste3 = pilhaDeFilas.pop();
		while(!teste3.vazia())
			System.out.println(teste3.remove());
		
		teste3 = pilhaDeFilas.pop();
		while(!teste3.vazia())
			System.out.println(teste3.remove());
		
	}

}
