package br.uern.wellisonraul.threads;

import java.io.File;

import br.uern.wellisonraul.metodos.mapek.Analisador;
import br.uern.wellisonraul.metodos.mapek.Monitor;
import br.uern.wellisonraul.metodos.mapek.Planejamento;

public class MAPEKThread extends Thread{
	
	
	@Override
	public void run(){
		int x = 0;
		Monitor monitor = new Monitor();
		Analisador analisador = new Analisador();
		Planejamento planejamento = new Planejamento();
		while(true){
			try{
				Thread.sleep(2000);
				System.out.println("Quantidade de vezes que o MAPEK foi chamado:"+(++x));
				File arquivo = monitor.retornaArquivo();
				int codigo = analisador.retornaNumeroLinhas(arquivo);
				planejamento.chamaExecutor(codigo);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
}
