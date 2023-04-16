package Exercicio3;

public class PilhaDupla
{
	private int n;
	private char vetor[];
	private int topo1;
	private int topo2;
	
	public PilhaDupla()
	{
		n = 10;
		vetor = new char[n];
		topo1 = -1;
		topo2 = n;
	}
	
	public PilhaDupla(int tamanho)
	{
		n = tamanho;
		vetor = new char[tamanho];
		topo1 = -1;
		topo2 = n;
	}
	
	
	public boolean pilha1Vazia()
	{
		return topo1 == -1 ? true : false;
	}
	
	public char retornaTopoPilha1()
	{
		char elemento = '\0';

		if(!this.pilha1Vazia())
		{
			elemento = vetor[topo1];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}
	
	
	public boolean pilha2Vazia()
	{
		return topo2 == n ? true : false;
	}
	
	public char retornaTopoPilha2()
	{
		char elemento = '\0';

		if(!this.pilha2Vazia())
		{
			elemento = vetor[topo2];         
		}
		else
		{
			System.out.println("Pilha vazia.");
		}

		return elemento;
	}
	
	
	public boolean pilhasCheias()
	{
		return topo1 == (topo2-1) ? true : false;
	}
	
	
	public char popPilha1()
	{
		char c = '\0';
		System.out.println(topo1);
		System.out.println(vetor[topo1]);
		
		
		if (!this.pilha1Vazia())
		{
			c = vetor[topo1];
			topo1--;
		}
		
		else
		System.out.println("Pilha vazia: pop nao funcionou.");
		
		return c;
	}
	
	public char popPilha2()
	{
		char c = '\0';
		
		if (!this.pilha2Vazia())
		{
			c = vetor[topo2];
			topo2++;
		}
		
		else
		System.out.println("Pilha vazia: pop nao funcionou.");
		
		
		return c;
	}

	
	public boolean pushPilha1(char elemento)
	{
		if (!this.pilhasCheias())
		{
			vetor[++topo1] = elemento;
			System.out.println(vetor[topo1]);
			System.out.println(topo1);
			return true;
		}
		else
		{
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}
	
	public boolean pushPilha2(char elemento)
	{
		if (!this.pilhasCheias())
		{
			vetor[--topo2] = elemento;
			return true;
		}
		else
		{
			//Impressao para fins didaticos
			System.out.println("Pilha cheia: push nao funcionou.\n");
			return false;
		}
	}

	
	public void listarPilhas() {
		
		
		if(this.pilha1Vazia())
			System.out.println("Pilha 1 vazia");
		else {
			System.out.println("\nPilha 1:");
			for(int i=0; i<=topo1;i++)
				System.out.println(vetor[i]);
		}
		
		if(this.pilha2Vazia())
			System.out.println("Pilha 2 vazia");
		else {
			System.out.println("\nPilha 2:");
			for(int i=n-1; i>=topo2;i--)
				System.out.println(vetor[i]);
		}
	}
}