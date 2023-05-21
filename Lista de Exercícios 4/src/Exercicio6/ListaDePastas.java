package Exercicio6;

public class ListaDePastas extends Lista<Pasta>{
	
	public void imprime(String diretorio) {
		Elo p;
		for(p=prim; p!= null; p = p.prox) {
			if(p.dado.getDiretorio().equals(diretorio)) {
				p.dado.imprime();
			}
		}
	}

}
