package br.uern.wellisonraul.metodos.mapek;

public class Planejamento {
	public void chamaExecutor(int codigo){
		Executor executor = new Executor();
		
		// SE O CÓDIGO FOR 0, ENTÃO LIMPA AS LINHAS!
		if(codigo==0){
			executor.limpaLinhas(codigo);
		// RESETA O PADRÃO ATUAL - TROCANDO 
		// PADRÃO 1  = P1 = {1,2,3,4,5}, P2 = {1.2.3.6.5}
		// PADRÃO 2  = P2 = {1,2,3,4,5}, P1 = {1.2.3.6.5}
		}else if(codigo==1){
			executor.resetaPadrao(codigo);
		}
	}
}
