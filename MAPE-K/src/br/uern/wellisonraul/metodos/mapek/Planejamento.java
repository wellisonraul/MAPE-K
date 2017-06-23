package br.uern.wellisonraul.metodos.mapek;

public class Planejamento {
	public void chamaExecutor(int codigo){
		Executor executor = new Executor();
		if(codigo==0){
			executor.limpaLinhas(codigo);
		}else if(codigo==1){
			executor.AcrescentaLinhas(codigo);
		}
	}
}
