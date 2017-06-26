package br.uern.wellisonraul.metodos.auxiliares;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import javax.swing.plaf.FileChooserUI;

public class Escritora {
	// ESTA PARTE DO CÓDIGO É RESPOSÁVEL POR CRIAR O ARQUIVO DE TEXTO.
	File arquivoDeTexto = new File("/home/wellisonraul/MAPE-K.txt");
			
	FileWriter escreveArquivo = null;
	BufferedWriter escreveOTexto = null;
	
	public synchronized void escreverNoArquivo(int codigo){
		
		if(codigo==0){
			arquivoDeTexto.delete();
		}else if(codigo==1){
			try{
				// QUANDO EU PASSO TRUE EU DIGO AO ESCRITOR QUE EU QUERO QUE ELE MANTENHA OS DADOS EXISTENTES LÁ
				// EU USO A FUNÇÃO MAIS CONHECIDA COMO APPEND();
				escreveArquivo = new FileWriter(arquivoDeTexto,true);
				escreveOTexto = new BufferedWriter(escreveArquivo);
				// INSIRO XXXXXX
				Random random = new Random();
				int numero = random.nextInt(5) + 1;
				
				for(int i=0;i<numero;i++){
					int letra = random.nextInt(5);
					escreveOTexto.write(letra+" ");		
				}
				escreveOTexto.newLine();
				
				// FECHO OS MEUS ESCRITORES
				escreveOTexto.close();
				escreveArquivo.close();
			}catch(Exception e){
				System.out.println(e.getCause());
			}
			
		}else if(codigo==2){
			File arquivoTextoCopia = new File("/home/wellisonraul/MAPE-Kcopia.txt");
			
			arquivoTextoCopia.delete();
		}
	}
	
	public void inicializaArquivo(){
		// LIMPA O ARQUIVO
		if(arquivoDeTexto.exists()){
			arquivoDeTexto.delete();
		}
	}
}
