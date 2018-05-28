package hilos;
import interfaz.VentanaPrincipal;
import modelo.Boss;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;
import modelo.Zombie;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * Clase que controla el movimiento de las balas de acuerdo al tipo de arma
 */
public class HiloEnemigos extends Thread {
	
	private JuegoModelo juegoM;
	private VentanaPrincipal ventana;
	/**
	 * Cosntructor que permite intstanciar el hilo para que se puedan mover los enemigos (Zombies y Bosses)
	 * @param jm:  Juego modelo donde se ejecuta el juego
	 * @param ventana: ventana princiapal donde se muestra el juego
	 */
	public HiloEnemigos(JuegoModelo jm, VentanaPrincipal ventana) {
		juegoM = jm;
		this.ventana = ventana;
	}
	
	public void run() {
		
		while(true) {
				subirNivel();
				for(int i = 0; i < juegoM.getElegido().getBoss().length; i++) {
					if(juegoM.getElegido().getBoss()[i] != null) {
						Boss boss = juegoM.getElegido().getBoss()[i];	
						boss.setPosX(boss.getPosX() + boss.getVelocidad());
						
						if(boss.getVida() <= 0) {
							juegoM.setScore(juegoM.getScore() + boss.getScore());
							juegoM.getElegido().eliminarBoss();
						}
						
						if(juegoM.getElegido().intersecta(boss)) {
							tick(boss.getDamage());
						}
						
						if(boss.localizarZombieMuerto() != null) {
							Zombie muerto = boss.localizarZombieMuerto();
							juegoM.setScore(juegoM.getScore() + muerto.getScore());
							boss.eliminarZombie(muerto.getPosX());
						}
						
						try {
							Zombie zombie = boss.getZombie();
							avanzarZombie(zombie);
						}catch (NullPointerException e) {
							
						}
					}				
				}
				
				try {
					Thread.sleep(50);
				}catch(Exception e) {
					e.printStackTrace();
				}
			
			ventana.repaint();
		}	
	}
	/**
	 * Permite mover el arbol binario de los zombies y evalua si esta tocando el humano, si lo toca le hace daño 
	 * @param zombie: raiz del arbol binario de zombies
	 */
	public void avanzarZombie(Zombie zombie) {
		
		zombie.setPosX(zombie.getPosX() + zombie.getVelocidad());
		if(juegoM.getElegido().intersecta(zombie)) {
			tick(zombie.getDamage());
		}
		if(zombie.getZombieIzq() != null) {
			avanzarZombie(zombie.getZombieIzq());
		}
		
		if(zombie.getZombieDer() != null) {
			avanzarZombie(zombie.getZombieDer());
		}
	}
	
	public void tick(int dano) {
		PersonajePrincipal p = juegoM.getElegido().getPersonajePrincipal();
		p.setVida(p.getVida() - dano);
		
	}
	/**
	 * Analiza si todos los zombies y bosses estan muertos, si es asi, entonces permite subir de nivel al juego modelo 
	 */
	public void subirNivel() {
		int i = 0;
		int contador = 0;
		while(i < juegoM.getElegido().getBoss().length) {
			if(juegoM.getElegido().getBoss()[i] == null) {
				contador++;
			}
			i++;
		}
		if(i == contador) {
			juegoM.setNivel(juegoM.getNivel()+1);
			
		}
	}
}
