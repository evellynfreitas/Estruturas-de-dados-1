package Exercicio1;

public class Main {

	public static void main(String[] args) {
		SistemaOperacional so = new SistemaOperacional(10);
		
		so.inserirProcesso();
		so.inserirProcesso();
		so.inserirProcesso();

		//so.listarProcessos();
	}

}
