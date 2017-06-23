package br.uern.wellisonraul.threads;

import br.uern.wellisonraul.metodos.auxiliares.Escritora;

public class PreencheArquivoThread extends Thread {
	
	@Override
	public void run(){
		Escritora escritora = new Escritora();
		escritora.inicializaArquivo();
		
		// AQUI É ONDE FUNCIONA A THREAD
		while(true){
			try{
				escritora.escreverNoArquivo(1);
				Thread.sleep(1000);
				// REPITO O PROCESSO INFINITAMENTE. 
			}catch(Exception e){
				System.out.println(e);
			}

		}
	}
}
