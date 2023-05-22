package Exercicio7;

public class ListaDeInimigos {
	
	protected Elo prim;
	private int quantidade;
	
	protected class Elo
	{
		protected Inimigo inimigo;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(Inimigo ini)
		{
			inimigo = ini;
			prox = null;
		}
		
		public Elo(Inimigo ini, Elo proxIni)
		{
			inimigo = ini;
			prox = proxIni;
		}
	}
	
	public ListaDeInimigos()
	{
		prim = null;
		quantidade = 0;
	}
	
	public boolean vazia()
	{
		return prim == null;
	}
	
	public void inserir(Inimigo inimigo) {
		Elo p = new Elo(inimigo);
		p.prox = prim;
		prim = p;
		quantidade++;
	}
	
	public Inimigo localizar(Inimigo inimigo) {
		Elo p;
		for(p = prim; p!= null; p = p.prox) {
			if(inimigo.getVida() == p.inimigo.getVida() && inimigo.getDanoPorSegundo() == p.inimigo.getDanoPorSegundo())
				return p.inimigo;
		}
		
		return null;
	}
	
	public int efetuarDano(Inimigo inimigo, double dano) {
		Inimigo ini = localizar(inimigo);
		
		if(ini == null)
			return Integer.MIN_VALUE;
		else {
			int vida = (int) (ini.getVida() - dano);
			if(vida > 0)
				ini.setVida(vida);
			else {
				Elo p, ant=null;
				for(p = prim; (p!= null) && ini != p.inimigo; p = p.prox)
					ant = p;
				
				if(p == prim)
					prim = prim.prox;
				
				else
				ant.prox = p.prox;
				
				quantidade--;
			}
			return vida;
		}
	}

	public void imprime()
	{
		Elo p;
		int i=0;
		System.out.println("Elementos da lista:");
		
		for(p = prim; p != null; p = p.prox)
		{
			System.out.println(++i + " " + p.inimigo.getVida()+ " " + p.inimigo.getDanoPorSegundo());
		}
		
		System.out.println();
	}
	
	public int quantidade() {
		return quantidade;
	}
	
	public static void main(String[] args) {
		ListaDeInimigos lista = new ListaDeInimigos();
		Inimigo a = new Inimigo(20,2.5);
		Inimigo b = new Inimigo(30,1.4);
		Inimigo c = new Inimigo(30, 1.0);
		
		lista.inserir(a);
		lista.inserir(b);
		
		lista.imprime();
		
		lista.efetuarDano(b, 20);
		lista.imprime();
		
		lista.efetuarDano(c, 20);
		lista.imprime();
	}

}