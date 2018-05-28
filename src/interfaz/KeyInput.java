package interfaz;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private PanelJuego pj;
	
	public KeyInput(PanelJuego pj) {
		this.pj = pj;
	}
	
	public void keyPressed(KeyEvent e) {
		pj.keyPressed(e);
	}
	
	public void keyReleased(KeyEvent e) {
		pj.keyReleased(e);
	}
	
	
}
