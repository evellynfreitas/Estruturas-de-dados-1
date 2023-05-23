package Exercicio5;

public class InverteFrase extends Lista<Character>{
	
	public InverteFrase() {
		
	}
	
	public void insere(String frase) {
		for(int i = 0; i < frase.length(); i++)
			this.insere(frase.charAt(i)); // chamo o método herdado de Lista que insere caracteres
	}
	
	public String inverte() {
		String invertida = "";
		for(Elo p = prim; p!=null; p = p.prox)
			invertida+=p.dado;
		
		return invertida;
	}
	
	public static void main(String[] args) {
		InverteFrase obj = new InverteFrase();
		String frase = "Oi, tudo? Estou bem!";
		obj.insere(frase);
		System.out.println(obj.inverte());
	}
}
