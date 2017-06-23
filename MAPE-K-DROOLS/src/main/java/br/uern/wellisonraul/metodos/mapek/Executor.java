package br.uern.wellisonraul.metodos.mapek;


import br.uern.wellisonraul.metodos.auxiliares.Escritora;

public class Executor {
	static Escritora escritora = new Escritora();
	
	public static void limpaLinhas(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("APAGA LINHAS");
	}
	
	public static void AcrescentaLinhas(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("ACRESCENTA LINHAS");
	}
}
