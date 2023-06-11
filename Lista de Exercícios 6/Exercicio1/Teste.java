package Exercicio1;
public class Teste {

	public static void main(String args[])
	{
		ConjGenerico<Integer> c1;
		
		c1 = new ConjGenerico<Integer>();

		c1.insere(3); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
		c1.insere(2); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
		c1.insere(1); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
		c1.insere(4); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
		c1.insere(5); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());

		System.out.println("Imprimindo c1");
		c1.imprime();
		
		c1.remove(5); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
		c1.remove(1); System.out.println("Prim: "+c1.primeiro()+" Ult: "+c1.ultimo());
	}
}