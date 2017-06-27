package br.uern.wellisonraul.metodos.mapek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.uern.wellisonraul.metodos.auxiliares.Escritora;
import br.uern.wellisonraul.utilitario.CaminhosUtilitarios;

public class Monitor {
	
	public File retornaArquivo(){
		// CRIA UM NOVO ARQUIVO .XES
		File arquivoXES = new File (CaminhosUtilitarios.ARQUIVO_XES);
		
		// TRANSFORMANDO ARQUIVO .XES CABEÇALHO
		try {
			// TRANSFORMAÇÃO DE CABEÇALHO
			cabecalho(arquivoXES);
			// TRANSFORMAÇÃO TRACES E EVENTOS
			preencheTrace(arquivoXES);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return arquivoXES;
	}
	
	public File cabecalho(File arquivoXES) throws IOException{
		FileWriter escritorArquivo = new FileWriter(arquivoXES);
		
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
		// PREENCHE TRACE ACESSA UM MÉTODO SYNCRONIZED 
		Escritora escritora = new Escritora();
		escritora.escreverNoArquivo(2);
		
		// ABRINDO O ARQUIVO CÓPIA
		File arquivoTextoCopia = new File(CaminhosUtilitarios.MAPEK_TXT_COPIA);
		
		// TRY - CATCH PARA INSERIR TRACES
		try {
			// LEITURA DO ARQUIVO ARQUIVO COPIA
			FileReader arq = new FileReader(arquivoTextoCopia);
		    BufferedReader lerArq = new BufferedReader(arq);
		    String linha = lerArq.readLine();
		    
		    // ESCRITURA DE ARQUIVO PARA .ARQUIVOXES
		    FileWriter escritorArquivo = new FileWriter(arquivoXES,true);
		    BufferedWriter carregadorArquivo = new BufferedWriter(escritorArquivo);
		    
		    // DIFERENCIAR OS TRACES
		    double caso = 0;
		    // CRIANDO TRACES
		    while (linha != null) {
		    	// ESCREVENDO NO ARQUIVO.
		    	// ABRI A EXECUÇÃO
		    	carregadorArquivo.write("\t<trace>\n");
    			carregadorArquivo.write("\t\t<string key=\"concept:name\" value=\"Caso"+(++caso)+"\"/>\n");
    			
    			// LINHA A LINHA E NA PRIMEIRA EXECUÇÃO ISSO É A LINHA UM
		    	for (int i = 0; i < linha.length(); i++) {
		    		// SE ELE NÃO O ESPAÇO EM BRANCO
		    		if(!(linha.charAt(i)==32)){
		    			carregadorArquivo.write("\t\t<event>\n");
		    			carregadorArquivo.write("\t\t\t<string key=\"org:resource\" value=\"UNDEFINED\"/>\n");
		    			carregadorArquivo.write("\t\t\t<date key=\"time:timestamp\" value=\"2008-12-09T08:20:01.527+01:00\"/>\n");
		    			carregadorArquivo.write("\t\t\t<string key=\"concept:name\" value=\""+linha.charAt(i)+"\"/>\n");
		    			carregadorArquivo.write("\t\t\t<string key=\"lifecycle:transition\" value=\"complete\"/>\n");
		    			carregadorArquivo.write("\t\t</event>\n");
		    		}
				}
		    	carregadorArquivo.write("\t</trace>\n\n");
		    	
		    	linha = lerArq.readLine(); // lê da segunda até a última linha
		    }
		    carregadorArquivo.write("</log>\n");
		    carregadorArquivo.close();
	    	escritorArquivo.close();
		    arq.close();
		}catch (IOException e) {
		    System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
		}
		
		return arquivoXES;
	}
}
