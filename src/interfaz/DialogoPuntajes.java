package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogoPuntajes extends JDialog implements ActionListener{
	
	public final String PUNTAJES = "./data/puntajes.txt";
	
	private VentanaPrincipal v;
	private JButton organizarPorNombre;
	private JButton organizarPorPuntaje;
	private JButton organizarPorNivel;
	private JTextField busquedaBinaria;
	private JButton buscar;
	private JLabel puntajes;
	private JLabel organizar;
	
	public DialogoPuntajes(VentanaPrincipal v) {
		this.setLocation(v.getLocation());
		setTitle("Highscores");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setSize(860, 600);
		setResizable(false);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel(new GridLayout(1, 4));
		organizar = new JLabel("Organizar por");
		organizarPorNombre = new JButton("Nombre");
		organizarPorPuntaje = new JButton("Puntaje");
		organizarPorNivel = new JButton("nivel");
		busquedaBinaria = new JTextField();
		buscar = new JButton("Buscar");	
		puntajes = new JLabel();
		jp.add(organizar);
		jp.add(organizarPorNombre);
		jp.add(organizarPorPuntaje);
		jp.add(organizarPorNivel);
		add(puntajes);
		add(jp, BorderLayout.SOUTH);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
