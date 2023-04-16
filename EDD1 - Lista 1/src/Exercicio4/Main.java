package Exercicio4;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PilhaGenerica<Character> pilha = new PilhaGenerica<Character>(10);
		char opcao = '0';
		
		do {
			System.out.println("\nMenu Pilha:");
			System.out.println("1- Inserir na Pilha");
			System.out.println("2- Remover da Pilha");
			System.out.println("3- Remover um item especifico da Pilha");
			System.out.println("4- Listar itens da Pilha");
			System.out.println("0- Sair");
			
			opcao = scanner.next().charAt(0);
			char saida, entrada;
			
			switch(opcao) {
			case '1':
				System.out.print("Digite para inserir na pilha: ");
				entrada = scanner.next().charAt(0);
				pilha.push(entrada);
				break;
				
			case '2':
				saida = pilha.pop();
				if(saida != '\0')
					System.out.println("Item "+saida+" removido da Pilha");
				break;
				
			case '3':
				System.out.print("Digite o item que deseja remover: ");
				entrada = scanner.next().charAt(0);
				
				if(pilha.removerElemento(entrada))
					System.out.println("Item "+entrada+" removido da Pilha");
				else
					System.out.println("Erro ao remover um elemento");
				break;
				
			case '4':
				pilha.listarPilhas();
				break;
				
			case '0': break;
			
			default:
				System.out.println("Escolha outra opcao");
			}
			
		}while(opcao!='0');
			
		scanner.close();
	}

}
