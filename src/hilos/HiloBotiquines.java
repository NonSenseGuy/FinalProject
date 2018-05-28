package hilos;

import interfaz.VentanaPrincipal;
import modelo.Botiquin;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;
/**
 * @since 2018
 * @author Alejandro Barrera Lozano
 * @author Luis Alfredo Rodriguez
 * Clase que controla el tiempo de reswpawn de los botiquines en cada escenario
 */
public class HiloBotiquines extends Thread{
	
	private VentanaPrincipal ventanaPrincipal;
	private JuegoModelo juegoM;
	/**
	 * Constructor que permite instanciar el hilo para que pueden empezar a aparecer botiquines cada cierto tiempo en el juego 
	 * @param v:  Ventana principal actual donde se muestra el juego
	 * @param jm:  juego modelo donde se esta ejecutando el juego
	 */
	public HiloBotiquines(VentanaPrincipal v, JuegoModelo jm) {
		ventanaPrincipal = v;
		juegoM = jm;
	}
	
	public void run() {
		while(true) {
			
			Botiquin b = new Botiquin(600, PersonajePrincipal.POS_Y + 50);
			juegoM.getElegido().setBotiquin(b);
						
			try {
				Thread.sleep(6000);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ventanaPrincipal.repaint();
		}
	}
}
