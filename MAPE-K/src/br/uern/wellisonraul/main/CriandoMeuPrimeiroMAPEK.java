package br.uern.wellisonraul.main;


import br.uern.wellisonraul.threads.CronometroThread;
import br.uern.wellisonraul.threads.MAPEKThread;
import br.uern.wellisonraul.threads.PreencheArquivoThread;

public class CriandoMeuPrimeiroMAPEK {

	public static void main(String[] args) {
		// PORQUE ESSA CLASS EXTENDS THREAD.
		new PreencheArquivoThread().start();
		new MAPEKThread().start();
		new CronometroThread().start();
	}

}
