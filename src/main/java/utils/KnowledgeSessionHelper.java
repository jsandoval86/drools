package utils;

import org.kie.api.KieServices;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class KnowledgeSessionHelper {
	
	private static final String UTILIDAD_DE_CLASE_EXCEPCION = "Utility class";
	public static final String NOMBRE_SESSION = "ksession-rules";
	
	// no usar instancias
	private KnowledgeSessionHelper() {
		throw new IllegalStateException(UTILIDAD_DE_CLASE_EXCEPCION);
	}
	
	// crear reglas
	public static KieContainer crearReglasBase() {
		KieServices ks = KieServices.Factory.get();
		return ks.getKieClasspathContainer();
	}
	
	// session stateless
	public static StatelessKieSession getStatelessKieSession(KieContainer kieContainer, String nombreSession) {
		return kieContainer.newStatelessKieSession(nombreSession);
	}
	
	// session stateful
	public static KieSession getStatefullKieSession(KieContainer kieContainer, String nombreSession) {
		KieSession sessionStatefull = kieContainer.newKieSession(nombreSession);
		sessionStatefull.addEventListener(new RuleRuntimeEventListener() {

			@Override
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Objeto Insertado \n"
						+ event.getObject().toString());
			}

			@Override
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Objeto Actualizado \n"
						+ event.getObject().toString());
			}
			
			@Override
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Objeto Eliminado \n"
						+ event.getOldObject().toString());
			}
			
		});
		return sessionStatefull;
	}
}
