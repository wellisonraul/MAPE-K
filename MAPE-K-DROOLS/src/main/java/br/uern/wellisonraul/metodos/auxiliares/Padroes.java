package br.uern.wellisonraul.metodos.auxiliares;

import java.util.ArrayList;
import java.util.Random;

public class Padroes {
	int escolhaPadrao;
	ArrayList<String> padrao1 = new ArrayList<String>();
	ArrayList<String> padrao2 = new ArrayList<String>();
	
	Padroes(){
		padrao1.add("1");
		padrao1.add("2");
		padrao1.add("3");
		padrao1.add("4");
		padrao1.add("5");
		
		padrao2.add("1");
		padrao2.add("2");
		padrao2.add("3");
		padrao2.add("6");
		padrao2.add("5");
	}
	
	// ESSE MÉTODO É RESPOSÁVEL POR TROCAR OS PADRÕES
	public void preencheArray(int codigo){
		// PADRÃO P1 - - IGUAL AO CONSTURTOR
		if(codigo<0){
			padrao1.clear();
			padrao2.clear();
			
			padrao1.add("1");
			padrao1.add("2");
			padrao1.add("3");
			padrao1.add("4");
			padrao1.add("5");
			
			padrao2.add("1");
			padrao2.add("2");
			padrao2.add("3");
			padrao2.add("6");
			padrao2.add("5");
			
		// TROCA O PADRÃO E VIRA P2 > 0
		}else{
			padrao1.clear();
			padrao2.clear();
			
			padrao2.add("1");
			padrao2.add("2");
			padrao2.add("3");
			padrao2.add("6");
			padrao2.add("5");
			
			padrao1.add("1");
			padrao1.add("2");
			padrao1.add("3");
			padrao1.add("4");
			padrao1.add("5");
		}
	}
	
	// ESTE MÉTODO É RESPOSÁVEL POR RETORNAR O PADRÃO DE ESCRITA DAQUELA INSTANCIA!
	public ArrayList<String> retornaPadrao(){
		Random r = new Random ();
		int padrao = r.nextInt();
		
		// SE FOR PAR
		if(padrao%2==0){
			return padrao1;
		}else{
			return padrao2;
		}
	}
}
