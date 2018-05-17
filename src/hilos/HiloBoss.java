package hilos;

import java.util.ArrayList;

import interfaz.VentanaPrincipal;
import modelo.Boss;
import modelo.Personaje;
import modelo.PersonajePrincipal;

public class HiloBoss extends Thread{
	
	private ArrayList <Personaje> zombies;
	private PersonajePrincipal principal;

	public HiloBoss(VentanaPrincipal Vprincipal) {
		zombies = Vprincipal.getJuegoModelo().getEscenario().getEnemigos();
		principal = Vprincipal.getJuegoModelo().getEscenario().getPersonajePrincipal();
	}
	public void run() {
		for (int i = 0; i < zombies.size(); i++) {
			if (zombies.get(i) instanceof Boss){
				if( principal.getPosX() > zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 200 ) {
					((Boss) zombies.get(i)).setAtacar(false);
					zombies.get(i).moverPersonaje(5);
				}else if(principal.getPosX() < zombies.get(i).getPosX() && zombies.get(i).getPosX() !=  principal.getPosX() + 200){
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
