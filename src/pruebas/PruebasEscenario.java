package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Escenario;
import modelo.PersonajePrincipal;

class PruebasEscenario {
	
	Escenario escenario;
	
	public void setupEscenario() {
		escenario = new Escenario(Escenario.ESCENARIOS[0]);
	}
	
	public void setupEscenario2() {
		escenario = new Escenario(Escenario.ESCENARIOS[0]);
		escenario.setPersonajePrincipal(new PersonajePrincipal(1000, PersonajePrincipal.IMAGEN));
		escenario.generar(1);
		escenario.getBoss()[0].setPosX(950);
	}
	
	@Test
	public void generarTest() {
		setupEscenario();
		escenario.generar(2);
		assertTrue(escenario.getBoss()[0]!= null && escenario.getBoss()[1] != null);
	}
	
	@Test
	public void posicionBossTest() {
		setupEscenario();
		int finalE = escenario.getPosicionBoss(true);
		int inicio = escenario.getPosicionBoss(false);
		assertTrue(finalE > 1000 && inicio < 0);
	}
	
	@Test
	public void intersectaTest() {
		setupEscenario2();
		assertTrue(escenario.intersecta(escenario.getBoss()[0]));
		
	}
	@Test
	public void eliminarBossSetup() {
		setupEscenario2();
		escenario.getBoss()[0].setVida(0);
		escenario.eliminarBoss();
		assertTrue(escenario.getBoss()[0].getDamage() == 0);
	}
	
}
