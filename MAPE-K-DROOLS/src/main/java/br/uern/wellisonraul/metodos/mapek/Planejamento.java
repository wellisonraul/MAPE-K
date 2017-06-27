package br.uern.wellisonraul.metodos.mapek;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import br.uern.wellisonraul.drools.Codigo;

public class Planejamento {
	public void chamaExecutor(int codigo){
		try{
			// CARREGAMENTO DO DROOLS PADRÃO
			// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
            
        	// OBJETO DO CLASSE CÓDIGO PARA TER A POSSIBILIDADE DE SER TRATADA PELO DROOLS
            Codigo valorCodigo = new Codigo();
            valorCodigo.setCodigo(codigo);
            
            // INSERI ESSE OBJETO NO DROOLS
            kSession.insert(valorCodigo);   
            kSession.fireAllRules();
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
}
