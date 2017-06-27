package br.uern.wellisonraul.metodos.auxiliares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import br.uern.wellisonraul.utilitario.CaminhosUtilitarios;

public class Escritora {
	// ESTA PARTE DO CÓDIGO É RESPOSÁVEL POR CRIAR O ARQUIVO DE TEXTO.
	File arquivoDeTexto = new File(CaminhosUtilitarios.MAPEK_TXT);
	Padroes p = new Padroes();
	int escolhaPadrao= -1;
			
	FileWriter escreveArquivo = null;
	BufferedWriter escreveOTexto = null;
	
	public synchronized void escreverNoArquivo(int codigo){
		// LIMPA O ARQUIVO
		if(codigo==0){
			arquivoDeTexto.delete();
		// RESETA O PADRÃO E LIMPA O ARQUIVO
		}else if(codigo==1){
			escolhaPadrao *= -1;
			p.preencheArray(escolhaPadrao);
			arquivoDeTexto.delete();
		// COPIA O ARQUIVO
		}else if(codigo==2){
			File arquivoTextoCopia = new File(CaminhosUtilitarios.MAPEK_TXT_COPIA);
			try {
				copiar(arquivoDeTexto, arquivoTextoCopia);
				arquivoDeTexto.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		// CRIA O TRACE DE EXECUÇÃO
		}else if(codigo==3){			
			try{
				// QUANDO EU PASSO TRUE EU DIGO AO ESCRITOR QUE EU QUERO QUE ELE MANTENHA OS DADOS EXISTENTES LÁ
				// EU USO A FUNÇÃO MAIS CONHECIDA COMO APPEND();
				escreveArquivo = new FileWriter(arquivoDeTexto,true);
				escreveOTexto = new BufferedWriter(escreveArquivo);
				
				
				ArrayList<String> padrao = p.retornaPadrao();
				
				for (String nomeServico : padrao) {
					escreveOTexto.write(nomeServico+" ");
				}
				escreveOTexto.newLine();
				
				// FECHO OS MEUS ESCRITORES
				escreveOTexto.close();
				escreveArquivo.close();
			}catch(Exception e){
				System.out.println(e.getCause());
			}
		}
	}
	
	public void inicializaArquivo(){
		// LIMPA O ARQUIVO
		if(arquivoDeTexto.exists()){
			arquivoDeTexto.delete();
		}
	}
	
	public void copiar(File src, File dst) throws IOException {
	        InputStream in = new FileInputStream(src);
	        OutputStream out = new FileOutputStream(dst);           // Transferindo bytes de entrada para saída
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
	    }
}
