package hilos;
import interfaz.VentanaPrincipal;
import modelo.*;

public class HiloEnemigos extends Thread {
	
	private JuegoModelo juegoM;
	private VentanaPrincipal ventana;
	
	public HiloEnemigos(JuegoModelo jm, VentanaPrincipal ventana) {
		juegoM = jm;
		this.ventana = ventana;
	}
	
	public void run() {
		while(juegoM.getElegido().getBoss()) {
			
		}
	}
	
	
	
}
