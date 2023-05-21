package Exercicio5;

public class InverteFrase extends Lista<Character>{
	
	public InverteFrase() {
		
	}
	
	public String inverte(String frase) {
		for(int i = 0; i < frase.length(); i++)
			this.insere(frase.charAt(i));
	
		String invertida = "";
		for(Elo p = prim; p!=null; p = p.prox)
			invertida+=p.dado;
		
		return invertida;
	}
	
	public static void main(String[] args) {
		InverteFrase obj = new InverteFrase();
		String frase = "Oi, meus amiguinhos lindos. Amo vocês!!!";
		System.out.println(obj.inverte(frase));
	}
}
