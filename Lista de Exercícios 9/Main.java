
public class Main
{
	public static void main(String args[])
	{
		// teste ex 4
		
		ArvBinBusca<Integer, String> arvoreBinaria = new ArvBinBusca<>();
		
		arvoreBinaria.put(10, "Teste1");
		arvoreBinaria.put(20, "Teste2");
		arvoreBinaria.put(5, "Teste3");
		arvoreBinaria.put(2, "Teste4");
		arvoreBinaria.put(4, "Teste5");
		arvoreBinaria.put(18, "Teste6");
		arvoreBinaria.put(22, "Teste6");
		arvoreBinaria.put(21, "Teste7");
		arvoreBinaria.put(19, "Teste8");
		arvoreBinaria.put(24, "Teste10");
		arvoreBinaria.put(23, "Teste11");
		arvoreBinaria.put(25, "Teste12");
		arvoreBinaria.put(28, "Teste13");
		arvoreBinaria.put(30, "Teste14");
		arvoreBinaria.put(17, "Teste15");

		arvoreBinaria.mostra();
		System.out.println();
		
		System.out.println(arvoreBinaria.removeForaIntervalo(31,40));
		arvoreBinaria.mostra();
		
		System.out.println();
		System.out.println(arvoreBinaria.obtemAncestralComum(28,30));
		
		// teste ex 3
		
		/*
		Arvbin<Integer> a1 = new Arvbin<Integer>(1),
				a2 = new Arvbin<Integer>(2),
				a3 = new Arvbin<Integer>(3,a1,a2),
				a4 = new Arvbin<Integer>(28),
				a5 = new Arvbin<Integer>(5),
				a6 = new Arvbin<Integer>(6),
				a7 = new Arvbin<Integer>(11,a5,a6),
				a8 = new Arvbin<Integer>(8),
				a9 = new Arvbin<Integer>(9),
				a10 = new Arvbin<Integer>(10,a8,a9);

				a4.defineEsq(a3);
				a4.defineDir(a7);
				a4.mostra();
		
		ArvBinBusca<Integer, Integer> arvore = new ArvBinBusca<Integer,Integer>();
		arvore.transformaArvBinBusca(a4);
		System.out.println();
		arvore.mostra();
		
		System.out.println(arvore.obtemAncestralComum(2, 3));
		*/
		
		// teste ex 5
		
		
		
		
	}
}
