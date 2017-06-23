package br.uern.wellisonraul.metodos.mapek;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class Analisador {
	
	private LineNumberReader lineRead;

	public int retornaNumeroLinhas(File arquivoLeitura){
		int numLinhas = 0;
		long tamanhoArquivo = arquivoLeitura .length();
		 
		try {
			// PARAMÊTROS PARA LEITURA NECESSÁRIOS
			FileInputStream fs = new FileInputStream(arquivoLeitura);
			DataInputStream in = new DataInputStream(fs);	
			lineRead = new LineNumberReader(new InputStreamReader(in));
			lineRead.skip(tamanhoArquivo);
			numLinhas = lineRead.getLineNumber() + 1;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(numLinhas>40){
			numLinhas = 0;
		}else{
			numLinhas = 1;
		}
		
		return numLinhas;
	}
}
