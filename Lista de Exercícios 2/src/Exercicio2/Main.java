package Exercicio2;

public class Main
{
	public static void main(String args[])
	{
		Fila f1 = new Fila(5);
		f1.insere(1);f1.insere(2);f1.insere(3);f1.insere(4);
		Fila f2 = new Fila(5);
		f2.insere(99);f2.insere(98);f2.insere(97);f2.insere(96);f2.insere(95);
				
		Fila filaMista = new Fila(10);
		filaMista.combinaFilas(f1,f2);
		filaMista.imprime();
	}
}
