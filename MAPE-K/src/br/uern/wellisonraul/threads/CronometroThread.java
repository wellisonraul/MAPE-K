package br.uern.wellisonraul.threads;

public class CronometroThread extends Thread {
	
	@Override
	public void run(){
		int i=0;
		while(true){
			try {
				Thread.sleep(1000);
				System.out.println("Quantidade em segundos de execução:"+(++i));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
