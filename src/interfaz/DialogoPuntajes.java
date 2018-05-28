package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import modelo.JuegoModelo;
import modelo.Puntaje;

@SuppressWarnings("serial")
public class DialogoPuntajes extends JDialog implements ActionListener{
	
	public final String PUNTAJES = "./data/puntajes.txt";
	public final String ORGANIZAR_PUNTAJE = "OrganizarPuntaje";
	public final String ORGANIZAR_NOMBRE = "OrganizarNickname";
	public final String ORGANIZAR_NIVEL = "OrganizarNivel";
	
	private VentanaPrincipal v;
	private JButton organizarPorNombre;
	private JButton organizarPorPuntaje;
	private JButton organizarPorNivel;
	private JTextField busquedaBinaria;
	private JButton buscarPorNivel;
	private JButton buscarPorPuntaje;
	private JTextArea puntajes;
	private JLabel organizar;
	
	public DialogoPuntajes(VentanaPrincipal v) {
		this.v = v;
		this.setLocation(this.v.getLocation());
		setTitle("Highscores");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./img/zombie.png"));
		setSize(860, 600);
		setResizable(false);
		setLayout(new BorderLayout());
		JPanel jp = new JPanel(new GridLayout(1, 4));
		organizar = new JLabel("Organizar por");
		organizarPorNombre = new JButton("Nombre");
		organizarPorNombre.setActionCommand(ORGANIZAR_NOMBRE);
		organizarPorNombre.addActionListener(this);
		
		organizarPorPuntaje = new JButton("Puntaje");
		organizarPorPuntaje.setActionCommand(ORGANIZAR_PUNTAJE);
		organizarPorPuntaje.addActionListener(this);
		
		organizarPorNivel = new JButton("Nivel");
		organizarPorNivel.setActionCommand(ORGANIZAR_NIVEL);
		organizarPorNivel.addActionListener(this);
		
		busquedaBinaria = new JTextField();
		busquedaBinaria.setToolTipText("Buscar por: ");
		buscarPorNivel = new JButton("Nivel");
		buscarPorNivel.setEnabled(false);
		buscarPorNivel.setActionCommand("buscarPorNivel");
		buscarPorNivel.addActionListener(this);
		buscarPorPuntaje = new JButton("Puntaje");
		buscarPorPuntaje.setEnabled(false);
		buscarPorPuntaje.setActionCommand("buscarPorPuntaje");
		buscarPorPuntaje.addActionListener(this);
		JPanel panelBusqueda = new JPanel(new GridLayout(1,3));
		panelBusqueda.add(busquedaBinaria);
		panelBusqueda.add(buscarPorNivel);
		panelBusqueda.add(buscarPorPuntaje);
		add(panelBusqueda, BorderLayout.NORTH);
		
		puntajes = new JTextArea();
		puntajes.setEditable(false);
		jp.add(organizar);
		jp.add(organizarPorNombre);
		jp.add(organizarPorPuntaje);
		jp.add(organizarPorNivel);
		add(jp, BorderLayout.SOUTH);
		ScrollPane panelDesplazable = new ScrollPane();
	    panelDesplazable.add(puntajes);
	    add(panelDesplazable, BorderLayout.CENTER);
	    cargarPuntajes();
		setVisible(true);
		pack();
	}
	
	public void cargarPuntajes() {
		File file = new File(PUNTAJES);
		FileReader fr = null;
		BufferedReader br = null;
		puntajes.setText("Nickname / Nivel / Score" + "\n");
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			StringBuilder sb = new StringBuilder();
			String text = br.readLine();
			
			while(text != null) {
				sb.append(text);
				sb.append(System.lineSeparator());
				text = br.readLine();
			}
				String everything = sb.toString();
				puntajes.append(everything);
			
		}catch(Exception e) {
			
		}
	}
	
	public void organizarPorPuntaje() {
		JuegoModelo.guardarPuntajeOrganizado(JuegoModelo.organizarPorPuntaje(JuegoModelo.leerPuntajes()));
		cargarPuntajes();
		
	}
	
	public void organizarPorNivel() {
		JuegoModelo.guardarPuntajeOrganizado(JuegoModelo.organizarPorNivel(JuegoModelo.leerPuntajes()));
		cargarPuntajes();
	}
	
	public void organizarPorNombre() {
		JuegoModelo.guardarPuntajeOrganizado(JuegoModelo.organizarPorNickname(JuegoModelo.leerPuntajes()));
		cargarPuntajes();
	}
	
	public void buscarPorPuntaje(int puntaje) {
		Puntaje p = JuegoModelo.busquedaBinariaPuntaje(puntaje, JuegoModelo.leerPuntajes());
		if(p != null) {
			puntajes.setText(p.getNickname() + " " + p.getNivel() + " " + p.getPuntaje());
		}else {
			puntajes.setText("No se ha encontrado ningun jugador con ese puntaje");
		}
		
	}
	
	public void buscarPorNivel(int nivel) {
		Puntaje p = JuegoModelo.busquedaBinariaPorNivel(nivel, JuegoModelo.leerPuntajes());
		try {
			puntajes.setText(p.getNickname() + " " + p.getNivel() + " " + p.getPuntaje());
		}catch(NullPointerException e) {
			puntajes.setText("No se ha encontrado ningun jugador con ese nivel");
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(ORGANIZAR_PUNTAJE)) {
			organizarPorPuntaje();
			buscarPorPuntaje.setEnabled(true);
			buscarPorNivel.setEnabled(false);
		}else if(comando.equals(ORGANIZAR_NIVEL)) {
			organizarPorNivel();
			buscarPorPuntaje.setEnabled(false);
			buscarPorNivel.setEnabled(true);
		}else if(comando.equals(ORGANIZAR_NOMBRE)) {
			organizarPorNombre();
			buscarPorPuntaje.setEnabled(false);
			buscarPorNivel.setEnabled(false);
		}else if(comando.equals("buscarPorPuntaje")){
			try {
				buscarPorPuntaje(Integer.valueOf(busquedaBinaria.getText()));
				busquedaBinaria.setText("");
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un parametro entero ");
			}
			
		}else if(comando.equals("buscarPorNivel")) {
			try {
				buscarPorNivel(Integer.valueOf(busquedaBinaria.getText()));
				busquedaBinaria.setText("");
			}catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Ingrese un parametro entero");
			}
		}
		
	}


}
