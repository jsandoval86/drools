package utils.unitaria;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import dominio.Cuenta;
import utils.KnowledgeSessionHelper;

@SuppressWarnings("restriction")
public class KnowledgeSessionHelperTest {
	
	StatelessKieSession sessionStateless = null;
	static KieSession sessionStatefull = null;
	static KieContainer kieContainer = null;
	
	@BeforeClass
	public static void setup() {
		kieContainer = KnowledgeSessionHelper.crearReglasBase();
		sessionStatefull = KnowledgeSessionHelper.getStatefullKieSession(
				kieContainer,
				"ksession-rules"
		);
	}
	
	@Test
	public void cargarBaseConocimiento() {
		sessionStatefull.fireAllRules();
	}
}
