package Exercicio6;
public class Pasta {
	
	private String diretorio;
	ListaDeArquivos lista;
	
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
	}

	public Pasta(String diretorio) {
		this.diretorio = diretorio;
		lista = null;
	}
	
	public void insere(Arquivo a) {
		lista.insere(a);
	}
	
	public boolean remove(Arquivo a) {
		return lista.remove(a);
	}
	
	public void imprime() {
		System.out.println("Pasta: "+ diretorio);
		if(lista == null)
			System.out.println("(Pasta vazia)");
		
	}

	public String getDiretorio() {
		return diretorio;
	}
}