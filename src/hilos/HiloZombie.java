package hilos;

import java.util.ArrayList;
import interfaz.VentanaPrincipal;
import modelo.*;

public class HiloZombie extends Thread{
	private ArrayList <Personaje> zombies;
	private PersonajePrincipal principal;
	
	public HiloZombie(VentanaPrincipal Vprincipal) {
		zombies = Vprincipal.getJuegoModelo().getEscenario().getEnemigos();
		principal = Vprincipal.getJuegoModelo().getEscenario().getPersonajePrincipal();
	}
	
	public void run() {
		for (int i = 0; i < zombies.size(); i++) {
			if(zombies.get(i) instanceof Zombie ) {
				if(principal.getPosX() > zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 30) {
					((Zombie) zombies.get(i)).setAtacar(false);
					zombies.get(i).moverPersonaje(5);
				}else if (principal.getPosX() > zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 30){
					((Zombie) zombies.get(i)).setAtacar(false);
					zombies.get(i).moverPersonaje(-5);
				}else {
					((Zombie) zombies.get(i)).setAtacar(true);
				}
				
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if (zombies.get(i) instanceof Boss){
				if(principal.getPosX() > zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 200) {
					((Boss) zombies.get(i)).setAtacar(false);
					zombies.get(i).moverPersonaje(5);
				}else if( principal.getPosX() < zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 200 ) {
					((Boss) zombies.get(i)).setAtacar(false);
					zombies.get(i).moverPersonaje(-5);
				}else {
					((Boss) zombies.get(i)).setAtacar(true);
				}
				
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
