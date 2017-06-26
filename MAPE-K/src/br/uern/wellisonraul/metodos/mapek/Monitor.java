package br.uern.wellisonraul.metodos.mapek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import br.uern.wellisonraul.metodos.auxiliares.Escritora;

public class Monitor {
	
	public File retornaArquivo(){
		File arquivoXES = new File ("/home/wellisonraul/ArquivosXes.xes");
		
		// TRANSFORMANDO ARQUIVO .XES CABEÇALHO
		try {
			cabecalho(arquivoXES);
			preencheTrace(arquivoXES);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arquivoXES;
	}
	
	public File cabecalho(File arquivoXES) throws IOException{
		FileWriter escritorArquivo = null;
		escritorArquivo = new FileWriter(arquivoXES);

		BufferedWriter buferizadorArquivos = new BufferedWriter(escritorArquivo);
		
		// ESCREVENDO O CABEÇALHO NO ARQUIVO
		buferizadorArquivos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		buferizadorArquivos.write("<!-- This file has been generated with the OpenXES library. It conforms -->\n");
		buferizadorArquivos.write( "<!-- to the XML serialization of the XES standard for log storage and -->\n");
		buferizadorArquivos.write("<!-- management. -->\n");
		buferizadorArquivos.write("<!-- XES standard version: 1.0 -->\n");
		buferizadorArquivos.write("<!-- OpenXES library version: 1.0RC7 -->\n");
		buferizadorArquivos.write("<!-- OpenXES is available from http://www.openxes.org/ -->\n");
		buferizadorArquivos.write("<log xes.version=\"1.0\" xes.features=\"nested-attributes\" openxes.version=\"1.0RC7\" xmlns=\"http://www.xes-standard.org/\">\n");
		buferizadorArquivos.write("\t<extension name=\"Lifecycle\" prefix=\"lifecycle\" uri=\"http://www.xes-standard.org/lifecycle.xesext\"/>\n");
		buferizadorArquivos.write("\t<extension name=\"Organizational\" prefix=\"org\" uri=\"http://www.xes-standard.org/org.xesext\"/>\n");
		buferizadorArquivos.write("\t<extension name=\"Time\" prefix=\"time\" uri=\"http://www.xes-standard.org/time.xesext\"/>\n");
		buferizadorArquivos.write("\t<extension name=\"Concept\" prefix=\"concept\" uri=\"http://www.xes-standard.org/concept.xesext\"/>\n");
		buferizadorArquivos.write("\t<extension name=\"Semantic\" prefix=\"semantic\" uri=\"http://www.xes-standard.org/semantic.xesext\"/>\n");
		buferizadorArquivos.write("\t<global scope=\"trace\">\n");
		buferizadorArquivos.write("\t\t<string key=\"concept:name\" value=\"__INVALID__\"/>\n");
		buferizadorArquivos.write("\t</global>\n");
		buferizadorArquivos.write("\t<global scope=\"event\">\n");
		buferizadorArquivos.write("\t\t<string key=\"concept:name\" value=\"__INVALID__\"/>\n");
		buferizadorArquivos.write("\t\t<string key=\"lifecycle:transition\" value=\"complete\"/>\n");
		buferizadorArquivos.write("\t</global>\n");
		buferizadorArquivos.write("\t<classifier name=\"MXML Legacy Classifier\" keys=\"concept:name lifecycle:transition\"/>\n");
		buferizadorArquivos.write("\t<classifier name=\"Event Name\" keys=\"concept:name\"/>\n");
		buferizadorArquivos.write("\t<classifier name=\"Resource\" keys=\"org:resource\"/>\n");
		buferizadorArquivos.write("\t<string key=\"source\" value=\"Rapid Synthesizer\"/>\n");
		buferizadorArquivos.write("\t<string key=\"concept:name\" value=\"excercise1.mxml\"/>\n");
		buferizadorArquivos.write("\t<string key=\"lifecycle:model\" value=\"standard\"/>\n");
		
		// FECHANDO OS ARQUIVOS DE ESCRITA. 
		buferizadorArquivos.close();
		escritorArquivo.close();
		
		return arquivoXES;
	}
	
	public File preencheTrace(File arquivoXES){
		// TRATANDO O DEADLOCK DAS THREADS.
		Escritora escritora = new Escritora();
		escritora.escreverNoArquivo(2);
		
		System.out.println("aqui ?");
		// ABRINDO O ARQUIVO CÓPIA
		File arquivoTextoCopia = new File("/home/wellisonraul/MAPE-Kcopia");
		
		// TRY - CATCH PARA INSERIR TRACES
		try {
			FileReader arq = new FileReader(arquivoTextoCopia);
		    BufferedReader lerArq = new BufferedReader(arq);
		    String linha = lerArq.readLine();
		    
		    ArrayList<Integer> eventos = new ArrayList<Integer>();
		      
		    // CRIANDO TRACES
		    while (linha != null) {
		    	for (int i = 0; i < linha.length(); i++) {
		    		if(!(linha.charAt(i)==32)){
		    			int conversor = linha.charAt(i);
		    			eventos.add(conversor);
		    		}
				}
		    	
		    	for (Integer inteiro : eventos) {
					System.out.println("Valores inteiros"+inteiro);
				}
		    	
		    	linha = lerArq.readLine(); // lê da segunda até a última linha
		    }
		    arq.close();
		}catch (IOException e) {
		    System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
		
		return arquivoXES;
	}
}
