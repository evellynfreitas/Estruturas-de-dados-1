package Exercicio6;

public class Pasta {
	
	protected String nome;
	protected ListaDeArquivos arquivos;
	protected ListaDePastas subpastas;
	
	/*
	public class ListaDeArquivos extends Lista<Arquivo>{
	
		public void imprime() {
			Elo p;
			
			System.out.println("Arquivos:");
			
			for(p = prim; p != null; p = p.prox)
			{
				System.out.print(p.dado.getArquivo() + " ");
			}
			
			System.out.println();
		}
	}*/

	public Pasta(String nome) {
		this.nome = nome;
		arquivos = new ListaDeArquivos();
		subpastas = new ListaDePastas();
	}
	
	public void insereArquivo(Arquivo a) {
		arquivos.insere(a);
	}
	
	public boolean removeArquivo(Arquivo a) {
		return arquivos.remove(a);
	}
	
	public void insereSubpasta(Pasta p) {
		subpastas.insere(p);
	}
	
 	public String getNome() {
		return nome;
	}

 	public void imprime() {
 		System.out.println(nome);
 		if(!arquivos.vazia()) {
 			arquivos.imprimeArquivos();
 		}
 		
 		if(!subpastas.vazia()) {
 			subpastas.imprimeSubpastas();
 		}
 	}
 	
}