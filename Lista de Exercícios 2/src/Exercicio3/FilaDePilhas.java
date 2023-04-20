package Exercicio3;

import java.util.Vector;

	public class FilaDePilhas<T> {

	private int tamanho;			/* Tamanho do vetor */
	private Vector<T> vetor;		/* Vetor de elementos */
	private int ini;				/* Posicao do proximo elemento a ser retirado */
	private int n;					/* Numero de elementos na fila */
	
	public FilaDePilhas(int tam)
	{
		tamanho = tam;
		vetor = new Vector<T>(tamanho);
		ini = 0;
		n = 0;
	}
}
