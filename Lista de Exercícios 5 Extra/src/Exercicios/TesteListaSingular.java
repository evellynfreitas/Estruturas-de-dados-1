package Exercicios;
import java.util.Scanner;

public class TesteListaSingular
{
	private int apresentaMenu()
	{
		int escolha;

		Scanner scanner = new Scanner(System.in);

		System.out.println("--------------------------\n");
		System.out.println("Selecione uma opcao:\n");
		System.out.println("1. Insere elemento (no. inteiro) na lista\n");
		System.out.println("2. Remove elemento (no. inteiro) da lista\n");
		System.out.println("3. Imprime elementos da lista.\n");
		System.out.println("4. Imprime o maior elemento da lista.\n");
		System.out.println("5. Imprime o menor elemento da lista.\n");
		System.out.println("6. Divide a lista\n");
		System.out.println("7. Concatena duas listas\n");
		System.out.println("0. Fim.\n");
		System.out.print("Sua opcao: ");

		escolha = scanner.nextInt();
		
		return escolha;
	}
	
	public void valida(Lista lista)
	{
		int escolha, elem;

		Scanner scanner = new Scanner(System.in);

		do
		{
			escolha = apresentaMenu();

			switch(escolha)
			{
			case 0: /* Não faz nada. */
				break;
			case 1:
				System.out.println("--------------------------\n");
				System.out.println("Entre com elemento para inserir: ");
				elem = scanner.nextInt();
				lista.insere(elem);
				break;
			case 2:
				System.out.println("--------------------------\n");
				System.out.println("Entre com elemento para remover: ");
				elem = scanner.nextInt();
				if (lista.remove(elem))
					System.out.println("Elemento " + elem + " removido.\n");
				else
					System.out.println("Elemento não existe!\n");
				break;
			case 3:
				System.out.println("--------------------------\n");
				System.out.println("Conteúdo da lista:\n");
				lista.imprimeRecursivo();
				break;
			case 4:
				System.out.println("--------------------------\n");
				System.out.println("Elemento Máximo: "+lista.maxRecursivo()+"\n");
				break;
			case 5:
				System.out.println("--------------------------\n");
				System.out.println("Elemento Mínimo: "+lista.minRecursivo()+"\n");
				break;
			case 6:
				System.out.println("--------------------------\n");
				System.out.println("Dividir listas: \n");
				System.out.println("Entre com o N: ");
				int n = scanner.nextInt();
				Lista lista2 = lista.separa(n);
				System.out.println("\nLista 1: "); lista.imprimeRecursivo();
				System.out.println("\nLista 2: "); lista2.imprimeRecursivo();
				break;
			case 7:
				System.out.println("--------------------------\n");
				System.out.println("Concatenar listas: \n");
				
				lista2 = new Lista();
				lista2.insere(9);lista2.insere(8);lista2.insere(7);lista2.insere(6);
				lista = Lista.concatena(lista,lista2);
				System.out.println("Lista nova: "); lista.imprimeRecursivo();
				break;
			case 8:
				System.out.println("--------------------------\n");
				System.out.println("Concatenar listas: \n");
				
				lista2 = new Lista();
				lista2.insere(9);lista2.insere(8);lista2.insere(7);lista2.insere(6);
				lista = Lista.concatena(lista,lista2);
				System.out.println("Lista nova: "); lista.imprimeRecursivo();
				break;
			}

		}while(escolha != 0);
				
		scanner.close();
	}
}