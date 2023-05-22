package Exercicio6;

public class Arquivo {
	private String nome;
	private String diretorio;
	
	public Arquivo(String s) {
		nome = s;
	}
	
	public void setNome(String s) {
		nome = s;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDiretorio(String s) {
		diretorio = s;
	}
	
	public String getDiretorio() {
		return diretorio;
	}
}
