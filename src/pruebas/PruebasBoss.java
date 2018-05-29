package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import junit.framework.TestCase;
import modelo.Boss;
import modelo.Zombie;

class PruebasBoss extends TestCase {
	
	Boss boss;
	
	public void setupEscenario() {
		boss = new Boss(Boss.VIDA, 0,Boss.IMAGEN_BOSS, Boss.DANO);
		boss.setZombie(null);
	}
	
	public void setupEscenario2() {
		boss = new Boss(Boss.VIDA, 0,Boss.IMAGEN_BOSS, Boss.DANO);
		Zombie z = new Zombie(-10,Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		boss.setZombie(null);
		boss.agregarZombie(z);
	}
	
	@Test
	public void agregarZombieTest() {
		setupEscenario();
		Zombie z = new Zombie(-10,Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		boss.agregarZombie(z);
		assertTrue(boss.getZombie().equals(z));
	
	}
	
	@Test
	public void agregarZombieTest2() {
		setupEscenario2();
		Zombie z2 = new Zombie(-15,Zombie.IMAGEN_ZOMBIE,Zombie.DANO );
		boss.agregarZombie(z2);
		assertTrue(boss.getZombie().getZombieIzq().equals(z2));
	}
	
	@Test 
	public void generarTest() {
		setupEscenario();
		boss.generar(2);
		assertTrue(boss.getZombie() != null && (boss.getZombie().getZombieDer() != null || boss.getZombie().getZombieIzq() != null) );
	}
	
	@Test
	public void quitarVidaBossTest() {
		setupEscenario();
		boss.quitarVidaBoss(boss.getPosX(), 15);
		assertTrue(boss.getVida() == Boss.VIDA-15);
	}
	
	@Test
	public void eliminarZombieTest() {
		setupEscenario2();
		boss.eliminarZombie(-10);
		assertTrue(boss.getZombie() == null);
	}
	
	@Test
	public void localizarZombieMuertoTest() {
		setupEscenario2();
		boss.getZombie().setVida(0);
		Zombie z = boss.localizarZombieMuerto();
		assertTrue(boss.getZombie().equals(z));	
	}
	
	@Test
	public void buscarZombieTest() {
		setupEscenario2();
		Zombie z = boss.buscarZombie(-10);
		assertTrue(boss.getZombie().equals(z));
	}
	
	
	
}
