package Exercicio3;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		char opcao='\0';
		Scanner scanner = new Scanner(System.in);
		PilhaDupla pilha = new PilhaDupla();

		do {
			System.out.println("\nMenu Pilha Dupla");
			System.out.println("1- Add na Pilha 1");
			System.out.println("2- Add na Pilha 2");
			System.out.println("3- Remover da Pilha 1");
			System.out.println("4- Remover da Pilha 2");
			System.out.println("5- Listar as duas Pilhas");
			System.out.println("0- Sair");
			
			opcao = scanner.next().charAt(0);
			char item;
			
			switch(opcao) {
			case '1':
				System.out.print("Digite para inserir na pilha 1: ");
				item = scanner.next().charAt(0);
				pilha.pushPilha1(item);
				break;
				
			case '2':
				System.out.print("Digite para inserir na pilha 2: ");
				item = scanner.next().charAt(0);
				pilha.pushPilha2(item);
				break;
				
			case '3':
				item = pilha.popPilha1();
				if(item != '\0')
					System.out.println("Item "+item+" removido da Pilha 1");
				break;
				
			case '4':
				item = pilha.popPilha2();
				if(item != '\0')
					System.out.println("Item "+item+" removido da Pilha 2");
				break;
				
			case '5':
				pilha.listarPilhas();
				break;
				
			case '0':
				break;
			}
			
		}while(opcao!=0);
		
		scanner.close();

	}

}
