package pruebas;

import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Arma;
import modelo.ArmaTiro;
import modelo.Bala;
import modelo.Personaje;
import modelo.PersonajePrincipal;

class PruebasPersonajePrincipal extends TestCase{
	
	PersonajePrincipal personaje;
	Arma arma;
	
	public void setupPersonaje() {
		personaje = new PersonajePrincipal(1000, PersonajePrincipal.IMAGEN);
		arma = new ArmaTiro("9mm", 20, "./img/gun.png", 1);
	}
	
	public void setupPersonaje2() {
		personaje = new PersonajePrincipal(1000, PersonajePrincipal.IMAGEN);
		arma = new ArmaTiro("9mm", 20, "./img/gun.png", 1);
		personaje.agregarArma(arma);
		personaje.setArmaElegida(personaje.getArmaPrimera());
	}
	
	
	@Test
	public void agregarArmaTest() {
		setupPersonaje();
		personaje.agregarArma(arma);
		assertTrue(personaje.getArmaPrimera().equals(arma));
		assertTrue(personaje.getArmaElegida() == null);
	}
	
	@Test
	public void dispararIzqTest() {
		setupPersonaje2();
		personaje.disparar(KeyEvent.VK_LEFT);
		Bala balaDisparada = ((ArmaTiro)personaje.getArmaElegida()).getBala();
		assertTrue(balaDisparada.getPosX() == personaje.getPosX()-5);
		assertTrue(balaDisparada.getVelocidad() == -ArmaTiro.VELOCIDAD_BALA);
	}
	
	@Test
	public void dispararDerTest() {
		setupPersonaje2();
		personaje.disparar(KeyEvent.VK_RIGHT);
		Bala balaDisparada = ((ArmaTiro)personaje.getArmaElegida()).getBala();
		assertTrue(balaDisparada.getPosX() == personaje.getPosX()+5);
		assertTrue(balaDisparada.getVelocidad() == ArmaTiro.VELOCIDAD_BALA);
	}
	
}
