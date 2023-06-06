import java.util.Deque;
import java.util.ArrayDeque;

public class Main
{
	public static void main(String[] args)
	{
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				// (raiz, subárvore a esquerda, subárvore a direita)
				a4 = new Arvbin<Integer>(28),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(11,a5,a6),
				a8 = new Arvbin<Integer>(8),
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10,a8,a9);

				a4.defineEsq(a3);
				a4.defineDir(a7);
				a4.mostra();
				System.out.println();
				
				System.out.println("Numero de nos: " + a4.contaNos());
				
				System.out.println("Altura da arvore: " + a4.calculaAltura());
				
				Deque<Integer> caminhos = new ArrayDeque<Integer>();
				
				a4.imprimeTodosCaminhos(caminhos);
				
				if(Arvbin.verificaArvoreSoma(a4) != Integer.MIN_VALUE)
					System.out.println("A arvore corresponde a uma arvore soma.");
				else
					System.out.println("A arvore não corresponde a uma arvore soma.");
				
				Arvbin<Integer> a11 = a4.busca(3);
				if (a11 != null)
				{
					a11.defineVal(11);
					a11.defineEsq(a10);
				}
				a4.mostra();
				System.out.println();
	}
}
