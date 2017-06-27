package br.uern.wellisonraul.metodos.mapek;


import br.uern.wellisonraul.metodos.auxiliares.Escritora;

public class Executor {
	Escritora escritora;
	
	Executor(){
		escritora = new Escritora();
	}
	
	public void limpaLinhas(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("APAGA LINHAS");
	}
	
	public void resetaPadrao(int codigo){
		escritora.escreverNoArquivo(codigo);
		//System.out.println("ACRESCENTA LINHAS");
	}
}
