package br.uern.wellisonraul.metodos.mapek;


import br.uern.wellisonraul.metodos.auxiliares.Escritora;

public class Executor {
	static Escritora escritora = new Escritora();
	
	Executor(){
		escritora = new Escritora();
	}
	
	public static void limpaLinhas(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("APAGA LINHAS");
	}
	
	public static void resetaPadrao(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("ACRESCENTA LINHAS");
	}
}
