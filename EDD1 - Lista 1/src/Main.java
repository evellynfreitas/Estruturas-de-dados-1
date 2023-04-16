import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String entrada;

		
		System.out.println("Lista de Exercicios de EDD1");
		System.out.print("Digite o número do exercício para conferir: ");
		char opcao = scanner.next().charAt(0);
		
		switch(opcao) {
		
		case '1':
			
			System.out.print("Digite a String: ");
			entrada = scanner.next();
			
			Ex1 exercicio1 = new Ex1(entrada);
			
			if(exercicio1.enchePilha()) {
				
				if(exercicio1.verificaStrings())
					System.out.println("As Strings são inversas");
				else
					System.out.println("As Strings não são inversas");
			}
			else
				System.out.println("A String está no formato incorreto");
			
			break;
			
		
		case '2':
			System.out.print("Digite a String: ");
			entrada = scanner.next();
			
			Ex2 exercicio2  = new Ex2(entrada);
			
			if(exercicio2.verificaString())
				System.out.println("A String está no formato correto");
			else
				System.out.println("A String está no formato incorreto");
			break;
		
		default:
			System.out.println("Opção não encontrada!"); break;
	
		
		case '3':
			
			
			
		}
		
		
		scanner.close();
	}

}
