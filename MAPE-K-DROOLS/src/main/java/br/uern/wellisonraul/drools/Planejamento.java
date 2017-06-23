package br.uern.wellisonraul.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class Planejamento {
	
	public static void main(String[] args){
		try{
			// load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	 // go !
            Codigo codigo = new Codigo();
            codigo.setCodigo(1);
            
            Codigo codigo2 = new Codigo();
            codigo2.setCodigo(0);
            
            kSession.insert(codigo);
            kSession.insert(codigo2);
            
            kSession.fireAllRules();
            
		}catch(Throwable t){
			t.printStackTrace();
		}
	}
}
