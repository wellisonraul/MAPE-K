package br.uern.wellisonraul.threads;

import java.io.File;

import br.uern.wellisonraul.metodos.mapek.Analisador;
import br.uern.wellisonraul.metodos.mapek.Monitor;
import br.uern.wellisonraul.metodos.mapek.Planejamento;
import br.uern.wellisonraul.utilitario.CaminhosUtilitarios;

public class MAPEKThread extends Thread{
	
	
	@Override
	public void run(){
		int x = 0;
		Monitor monitor = new Monitor();
		Analisador analisador = new Analisador();
		Planejamento planejamento = new Planejamento();
		while(true){
			try{
				// ENVIA AS INSTANCIAS A CADA X SEGUNDOS
				Thread.sleep(CaminhosUtilitarios.TEMPO_ENTRE_ANALISES);
				System.out.println("Quantidade de vezes que o MAPEK foi chamado:"+(++x));
				File arquivoXES = monitor.retornaArquivo();
				int codigo = analisador.consultaoLTLMinner(arquivoXES);
				planejamento.chamaExecutor(codigo);
			}catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
}
