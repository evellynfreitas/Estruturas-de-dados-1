package Exercicio2;
import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Fila fila = new Fila(5);
		Scanner scanner = new Scanner(System.in);
		int escolha, item;
		
		do
		{
			System.out.println("--------------------------");
			System.out.println("Selecione a opcao:");
			System.out.println("1. Insere elemento na fila.");
			System.out.println("2. Remove elemento da fila.");
			System.out.println("3. Imprime elementos da fila.");
			System.out.println("4. Testa mistura de filas.");
			System.out.println("0. Fim.");
			System.out.print("Opcao: ");
			escolha = scanner.nextInt();
			
			switch(escolha) {
			case 0:
				//Não faz nada
				break;
			case 1:
				System.out.println("Entre com o item para adicionar: ");
				item = scanner.nextInt();
				if ( ! fila.insere(item) )
					System.out.println("Fila cheia.");
				break;
			case 2:
				item = fila.remove();
				if (item != Integer.MIN_VALUE)
					System.out.println("Item " + item + " removido.");
				else
					System.out.println("Fila vazia.");
				break;
			case 3:
				System.out.println("Conteúdo da fila:");
				fila.imprime();
				break;
			case 4:
				Fila f1 = new Fila(10);
				f1.insere(99);
				Fila f2 = new Fila(5);
				f2.insere(81);f2.insere(82);
				
				fila.combinaFilas(f1,f2);
				break;     
			}
			
		}while(escolha != 0);
	
		scanner.close();
	}
}
