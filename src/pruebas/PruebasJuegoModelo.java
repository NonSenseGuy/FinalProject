package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Escenario;
import modelo.JuegoModelo;
import modelo.Puntaje;

class PruebasJuegoModelo {

	JuegoModelo jm;
	Escenario e;
	ArrayList<Puntaje> puntajes;
	
	public void setupEscenario() {
		jm = new JuegoModelo("Test", 1, 0);
		jm.setEscenario(null);
	}
	
	public void setupEscenario2() {
		jm = new JuegoModelo("Test", 1, 0);
		jm.setEscenario(null);
		e = new Escenario(Escenario.ESCENARIOS[0]);
		jm.agregarEscenario(e);
	}
	
	public void setupEscenario3() {
		jm = new JuegoModelo("Test", 1, 0);
	}
	
	public void setupEscenario4() {
		puntajes = new ArrayList<Puntaje>();
		puntajes.add(new Puntaje("Test1", 1, 25));
		puntajes.add(new Puntaje("Alejandro", 3, 600));
		puntajes.add(new Puntaje("Fredo", 6, 1200));
	}
	

	@Test
	public void agregarEscenarioTest() {
		setupEscenario2();
		assertTrue(jm.getEscenario().equals(e));
	}
	@Test
	public void agregarEscenarioTest2() {
		setupEscenario2();
		Escenario escenario = new Escenario(Escenario.ESCENARIOS[1]);
		jm.agregarEscenario(escenario);
		assertTrue(jm.getEscenario().getSiguiente().equals(escenario));
	}
	@Test
	public void subirNivelTest() {
		setupEscenario3();
		jm.setNivel(2);
		assertTrue(jm.getElegido().getBoss().length == 2);
	}
	
	@Test
	public void organizarPorPuntajeTest() {
		setupEscenario4();
		Puntaje[] puntaje = JuegoModelo.organizarPorPuntaje(puntajes);
		assertTrue(puntaje[0].getPuntaje() == 1200 && puntaje[1].getPuntaje() == 600 && puntaje[2].getPuntaje() == 25);
	}
	
	@Test
	public void organizarPorNivelTest() {
		setupEscenario4();
		Puntaje[] puntaje = JuegoModelo.organizarPorNivel(puntajes);
		assertTrue(puntaje[0].getNivel() == 6 && puntaje[1].getNivel() == 3 && puntaje[2].getNivel() == 1);
	}
	@Test
	public void organizarPorNicknameTest() {
		setupEscenario4();
		Puntaje[] puntaje = JuegoModelo.organizarPorNickname(puntajes);
		assertTrue(puntaje[0].getNickname().equals("Alejandro") && puntaje[1].getNickname().equals("Fredo") && puntaje[2].getNickname().equals("Test1"));
	}
	
	@Test
	public void  busquedaBinariaNivelTest() {
		setupEscenario5(){
			Puntaje
		}
	}
	
	
}
