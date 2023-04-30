package Exercicio5;

public class Cliente {
	
	private int idade;
	
	public Cliente(int idade) {
		this.idade = idade;
	}
	
	public boolean eIdoso() {
		return idade >= 60 ;
	}
	
	public int retornaIdade() {
		return idade;
	}

}
