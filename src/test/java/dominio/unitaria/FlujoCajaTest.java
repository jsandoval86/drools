package dominio.unitaria;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.ConsequenceException;

import dominio.Cuenta;
import dominio.FlujoCaja;
import dominio.excepciones.NegocioExcepcion;
import junit.framework.Assert;
import utils.KnowledgeSessionHelper;

public class FlujoCajaTest {
	
	static KieSession sessionStatefull = null;
	static KieContainer kieContainer = null;
	
	@Before
	public void setup() {
		kieContainer = KnowledgeSessionHelper.crearReglasBase();
		sessionStatefull = KnowledgeSessionHelper.getStatefullKieSession(
				kieContainer, 
				KnowledgeSessionHelper.NOMBRE_SESSION
		);
	}
	
	@Test
	public void reglaNegocio1() {
		// arrange
		Cuenta cuenta = new Cuenta();
		cuenta.setCuentaNumero(1);
		cuenta.setTipo(Cuenta.AHORROS);
		
		FlujoCaja fcaja = new FlujoCaja();
		fcaja.setCuentaNumero(cuenta.getCuentaNumero());
		fcaja.setTipo(FlujoCaja.CREDITO);
		sessionStatefull.insert(cuenta);
		sessionStatefull.insert(fcaja);
		// act
		try {
			sessionStatefull.fireAllRules();
		}
		catch(ConsequenceException  e) {
			// assert
			Assert.assertEquals(FlujoCaja.MSG, e.getCause().getMessage());
			return;
		}

		fail();
	}
	
	@Test
	public void reglaNegocio2() {
		// arrange
		double balanceActual = 500000d;
		int cuentaNumero = 1;
		double montoFlujo = 450000d;
		
		Cuenta cuenta = new Cuenta();
		cuenta.setTipo(Cuenta.AHORROS);
		cuenta.setBalance(balanceActual);
		cuenta.setCuentaNumero(cuentaNumero);
		
		FlujoCaja fcaja = new FlujoCaja();
		fcaja.setCuentaNumero(cuenta.getCuentaNumero());
		fcaja.setTipo(FlujoCaja.DEBITO);
		fcaja.setMonto(montoFlujo);
		
		sessionStatefull.insert(cuenta);
		sessionStatefull.insert(fcaja);
		// act
		try {
			sessionStatefull.fireAllRules();
		}
		catch(ConsequenceException  e) {
			fail();
		}
		// assert
		Assert.assertEquals((balanceActual - montoFlujo), cuenta.getBalance());
	}
}
