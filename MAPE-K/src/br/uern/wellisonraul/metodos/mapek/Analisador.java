package br.uern.wellisonraul.metodos.mapek;

import java.io.File;
import ee.tkasekamp.ltlminer.StarterTest;

public class Analisador {
	
	public int consultaoLTLMinner(File arquivoXES){
		// CRIA UMA INSTÂNCIA DO LTLMINER.
		StarterTest statertest = new StarterTest();
		
		// CRIA DOIS VALORES DE RETORNO
		double retornoLTLMiner = 0;
		int retornoCodigo = 0;
		
		try {
			// INVOCA O LTLMINER PASSANDO O .XES
			retornoLTLMiner = statertest.test(arquivoXES);
			System.out.println(retornoLTLMiner);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ELE VAI PASSAR PARA O PLANEJAMENTO CÓDIGO 0
		if(retornoLTLMiner>=0.9){
			retornoCodigo = 0;
		}else{
		// ELE VAI PASSAR PRO PLANEJAMENTO CÓDIGO 1
			retornoCodigo = 1;
		}
		
		return retornoCodigo;
	}
}
