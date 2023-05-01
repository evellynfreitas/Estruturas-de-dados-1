package Exercicio5;

	public class FilaDeClientes {
	
	private int tamanho;				/* Tamanho do vetor */
	//private Vector<Cliente> vetor;		/* Vetor de clientes */
	private Cliente vetor[];
	private int inicio;					/* Posicao do proximo cliente a ser atendido */
	private int n;						/* Numero de clientes na fila */
	private int qtdIdosos;
	private int qtdAdultos;
	
	public FilaDeClientes(int tam)
	{
		tamanho = tam;
		vetor = new Cliente[tamanho];
		inicio = 0;
		n = 0;
		qtdIdosos = 0;
		qtdAdultos = 0;
	}
	
	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	
	public boolean insereCliente(Cliente c)
	{
		if(c.eIdoso()) {
			if(insereIdoso(c)) { //idoso entra na frente dos adultos
				qtdIdosos++;
				return true;
			}
			else
				return false;
		}
		
		else { //adulto sempre entra no final
			if(insereFinal(c)) {
				qtdAdultos++;
				return true;
			}
			else
				return false;
		}
	}
	
	private boolean insereIdoso(Cliente c) {
		
		if(qtdIdosos==0) {
			return insereInicio(c);
		}
		else if(qtdAdultos==0) {
			return insereFinal(c);
		}
		else {
			
			if(this.cheia())
				return false;
			
			int i=inicio, j;
			insereInicio(vetor[inicio]);
			
			for (int k = 1; k < qtdIdosos; k++) {
				j = (i + 1 + tamanho) % tamanho;
				vetor[i] = vetor[j];
				i = j;
			}
			
			vetor[i] = c;
			return true;
			
		}
	}
	
	//Inserimos o cliente no inicio da fila
	private boolean insereInicio(Cliente c)
	{
		int prec;
		
		if (!cheia())
		{
			/* Insere na posição precedente ao início */
			prec = (inicio - 1 + tamanho) % tamanho;
			vetor[prec] = c;
			inicio = prec; /* Atualiza índice para início */
			n++;
			return true;
		} 
		else
			return false;
	}
	
	//Inserimos o cliente no final da fila
	private boolean insereFinal(Cliente c)
	{
		int fim;
		  
		if (!cheia()) {
		  fim = (inicio + n) % tamanho;
		  vetor[fim] = c;
		  n++;
		  return true;
		} 
		 else
		   return false;
	}
	
	//Retiramos o cliente no início da fila
	public Cliente remove()
	{
		Cliente c = null;
		
		if (!this.vazia())
		{
			c = vetor[inicio];
			inicio = (inicio + 1) % tamanho;
			n--;
		} 

		return c;
	}

	
	public void imprime() {
		
		int i, j;
		
		if (vazia())
			System.out.println("Fila está vazia.");
		else
			for (i = inicio, j = 1; j <= n; j = j + 1, i = (i + 1) % tamanho)
				System.out.println(j + "° Idade: " + vetor[i].retornaIdade());
		}
	
}
