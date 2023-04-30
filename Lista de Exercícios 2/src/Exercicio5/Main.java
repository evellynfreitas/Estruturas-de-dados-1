package Exercicio5;

public class Main {

	public static void main(String[] args) {
		
		FilaDeClientes fila = new FilaDeClientes(10);
		
		Cliente c1 = new Cliente(14);
		fila.insereCliente(c1);
		
		Cliente c2 = new Cliente(61);
		fila.insereCliente(c2);
		
		Cliente c3 = new Cliente(10);
		fila.insereCliente(c3);
		
		Cliente c4 = new Cliente(55);
		fila.insereCliente(c4);
		
		Cliente c5 = new Cliente(70);
		fila.insereCliente(c5);
		
		Cliente c6 = new Cliente(89);
		fila.insereCliente(c6);
		
		fila.imprime();
		
	}

}
