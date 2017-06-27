package br.uern.wellisonraul.threads;

import br.uern.wellisonraul.metodos.auxiliares.Escritora;
import br.uern.wellisonraul.utilitario.CaminhosUtilitarios;

public class PreencheArquivoThread extends Thread {
	
	@Override
	public void run(){
		Escritora escritora = new Escritora();
		escritora.inicializaArquivo();
		
		// AQUI É ONDE FUNCIONA A THREAD
		while(true){
			try{
				escritora.escreverNoArquivo(3);
				Thread.sleep(CaminhosUtilitarios.TEMPO_ENTRE_INSTANCIAS);
				// ESCREVE NO ARQUIVO A CADA UM SEGUNDO.
				// REPITO O PROCESSO INFINITAMENTE. 
			}catch(Exception e){
				System.out.println(e);
			}

		}
	}
}
