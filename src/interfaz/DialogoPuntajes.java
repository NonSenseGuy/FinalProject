package interfaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoPuntajes extends JDialog{
	
	public final String PUNTAJES = "./data/puntajes.txt";
	
	private VentanaPrincipal v;
	private JButton organizarPorNombre;
	private JButton organizarPorPuntaje;
	private JButton organizarPorNivel;
	private JTextField busquedaBinaria;
	private JLabel puntajes;
	
	public DialogoPuntajes(VentanaPrincipal v) {
		this.setLocation(v.getLocation());
		setTitle("Highscores");
		setSize(v.getWidth() /2, v.getHeight() /2);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void cargarPuntajes() {
		File file = new File(PUNTAJES);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String text = "";
			while((text = br.readLine()) != null) {
				sb.append(text);
				sb.append(System.lineSeparator());
			}
				String everything = sb.toString();
				puntajes.setText(everything);
			
		}catch(Exception e) {
			
		}
	}
}
