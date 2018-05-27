package hilos;

import interfaz.VentanaPrincipal;
import modelo.Botiquin;
import modelo.JuegoModelo;
import modelo.PersonajePrincipal;

public class HiloBotiquines {
	
	private VentanaPrincipal ventanaPrincipal;
	private JuegoModelo juegoM;
	
	public HiloBotiquines(VentanaPrincipal v, JuegoModelo jm) {
		ventanaPrincipal = v;
		juegoM = jm;
	}
	
	public void run() {
		while(true) {
			Botiquin b = new Botiquin(600, PersonajePrincipal.POS_Y);
			juegoM.getElegido().setBotiquin(b);
			if(juegoM.getElegido().getPersonajePrincipal().getHitBox().contains(b.getPosX(), b.getPosY())) {
				juegoM.getElegido().getPersonajePrincipal().setVida(juegoM.getElegido().getPersonajePrincipal().getVida() + b.getVida());
				juegoM.getElegido().setBotiquin(null);
			}
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
