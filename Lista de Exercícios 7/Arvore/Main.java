package Arvore;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
		/*
		// Teste ex 1
		Arvbin<Character> a1 = new Arvbin<Character>('3'),
		a2 = new Arvbin<Character>('6'),
		a3 = new Arvbin<Character>('+',a1,a2),
		a4 = new Arvbin<Character>('4'),
		a5 = new Arvbin<Character>('1'),
		a6 = new Arvbin<Character>('-',a4,a5),
		a7 = new Arvbin<Character>('*', a3, a6),
		a8 = new Arvbin<Character>('5'),
		raiz = new Arvbin<Character>('+', a7, a8);
				
		raiz.imprimePreOrdem();
		System.out.println();
		raiz.imprimePosOrdem();
		System.out.println();
		raiz.imprimeEmOrdem();
		*/
		
		/*
		// Teste ex 2
		Arvbin<Integer> n1 = new Arvbin<Integer>(10);
		Arvbin<Integer> n2 = new Arvbin<Integer>(9,n1,null);
		Arvbin<Integer> n3 = new Arvbin<Integer>(8);
		Arvbin<Integer> n4 = new Arvbin<Integer>(7,n3,n2);
		Arvbin<Integer> n5 = new Arvbin<Integer>(6);
		Arvbin<Integer> n6 = new Arvbin<Integer>(5,n5,n4);
		Arvbin<Integer> n7 = new Arvbin<Integer>(4);
		Arvbin<Integer> n8 = new Arvbin<Integer>(3);
		Arvbin<Integer> n9 = new Arvbin<Integer>(2,n8,n7);
		Arvbin<Integer> raiz = new Arvbin<Integer>(1,n9,n6);
		
		raiz.mostra();
		System.out.println("\nSoma: "+Arvbin.retornaSomaSubArvore(raiz));
		*/
		
		// Teste ex 3
		Arvbin<Integer> n1 = new Arvbin<Integer>(3);
		Arvbin<Integer> n2 = new Arvbin<Integer>(4);
		Arvbin<Integer> n3 = new Arvbin<Integer>(2,n1,n2);
		Arvbin<Integer> n4 = new Arvbin<Integer>(6);
		Arvbin<Integer> n5 = new Arvbin<Integer>(7);
		Arvbin<Integer> n6 = new Arvbin<Integer>(5,n4,n5);
		
		System.out.println("É similar? "+ n3.eSimilar(n6));

		
		
	}
}
