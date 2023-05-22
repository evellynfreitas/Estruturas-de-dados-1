package Exercicio6;

public class ListaDePastas{

	protected Elo prim ;
	private int tamanho;

	protected class Elo{
		protected Pasta dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(Pasta elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(Pasta elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public ListaDePastas()
	{
		prim = null;
		tamanho = 0;
	}
	
	public boolean vazia()
	{
		return prim == null;
	}
	
	public void insere(Pasta novo) {
		Elo p = new Elo(novo);
		p.prox = prim;
		prim = p;
		tamanho++;
	}
	
	public int tamanho()
	{
		return tamanho;
	}
	
	public void imprime(String diretorio) {
		Elo p;
		for(p=prim; p!=null; p=p.prox) {
			
			if(diretorio.contains(p.dado.getNome())) {
				p.dado.imprime();
				break;
			}
			
		}
	}
	
	public void imprimeSubpastas(){
		Elo p;
		for(p=prim; p!=null; p=p.prox) {
			p.dado.imprime();
		}
	}
	
	public static void main(String[] args) {
		Pasta p = new Pasta("Jogos");
 		Arquivo a = new Arquivo("Stardew Valley");
 		Arquivo b = new Arquivo("Overwatch");
 		Arquivo c = new Arquivo("Haunted Chocolatier");
 		p.insereArquivo(a);
 		p.insereArquivo(b);
 		p.insereArquivo(c);
 		
 		Pasta p2 = new Pasta("Terror");
 		Arquivo a2 = new Arquivo("Five Nights at Freddys");
 		p2.insereArquivo(a2);
 		p.insereSubpasta(p2);
 		
 		Pasta p3 = new Pasta("Nitendo");
 		Arquivo a3 = new Arquivo("Super Mario");
 		Arquivo b3 = new Arquivo("Donkey Kong");
 		Arquivo c3 = new Arquivo("Mario Kart");
 		p3.insereArquivo(a3);
 		p3.insereArquivo(b3);
 		p3.insereArquivo(c3);
 		p.insereSubpasta(p3);
 		
 		
 		Pasta q = new Pasta("Filmes");
 		Arquivo q1 = new Arquivo("Star Wars");
 		Arquivo q2 = new Arquivo("Harry Potter");
 		Arquivo q3 = new Arquivo("Senhor dos aneis");
 		q.insereArquivo(q1);
 		q.insereArquivo(q2);
 		q.insereArquivo(q3);
 		
 		
 		ListaDePastas lista = new ListaDePastas();
 		lista.insere(p);
 		lista.insere(q);
 		
 		lista.imprime("Jogos");
 		
	}

}