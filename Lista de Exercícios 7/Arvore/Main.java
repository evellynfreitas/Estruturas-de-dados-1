package Arvore;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
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
	}
}
