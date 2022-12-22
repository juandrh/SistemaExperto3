package principal;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DefaultCaret;

/**
 * Clase Gui
 * 
 * Entorno gráfico para realización del test.
 * 
 * Se muestran el mapa con las entidades y un log con la información
 * 
 * 
 * Iconos descargados de la web: https://remixicon.com/
 * 
 * @author juan.delrio
 * @version 1.L
 * 
 */

public class Gui extends JFrame implements ListSelectionListener { // implements Runnable {

	private static final long serialVersionUID = 1L;

	JScrollPane scrollPane;
	private JPanel panelCentral;
	private JPanel panelAux;

	private JScrollPane panelScrollSalida;
	private JTextArea cajaTextoCentral;
	private JMenuBar menuBar;
	private JMenu menu1, menu2, menu3;
	private JMenuItem menuNuevo, menuSalir, menuAcercaDe, menuEjecutar;
	private JToolBar toolBar;
	private JButton botonNuevo;
	private JButton botonAcerca;
	private JButton botonEjecutar;

	private Icon iconNuevo, iconAcerca, iconEjecuta;

	private JList<String> Jlista;
	private List<String> listaHechosIniciales;

	private JLabel label1, label2, label3, label4, label5;
	private CreadorSistemaExperto creador;
	private JSlider slider1, slider2, slider3, slider4, slider5, slider6;

	public Gui() {
		setTitle("Sistema Experto(AEC2: Patrones de Diseño)");
		inicializarComponentesGUI();
		registrarEscuchadores();
		pack();
		setVisible(true);

	}

	/*
	 * FUNCIONES INICIO
	 */

	private void inicializarComponentesGUI() {

		getContentPane().setLayout(new BorderLayout());

		// Menu
		menuBar = new JMenuBar();
		menu1 = new JMenu("Archivo");
		menuNuevo = new JMenuItem("Nuevo sistema experto");
		menuSalir = new JMenuItem("Salir");
		menuEjecutar = new JMenuItem("Ejecutar");
		menuBar.add(menu1);
		menu1.add(menuNuevo);
		menu1.add(menuSalir);
		menu2 = new JMenu("Opciones");
		menu2.add(menuEjecutar);
		menuBar.add(menu2);
		menuAcercaDe = new JMenuItem("Acerca de");
		menu3 = new JMenu("Acerca de");
		menu3.add(menuAcercaDe);
		menuBar.add(menu3);
		this.setJMenuBar(menuBar);

		// Barra de herramientas
		toolBar = new JToolBar("barra");
		iconNuevo = new ImageIcon("iconos/nuevo.png");
		iconAcerca = new ImageIcon("iconos/acerca.png");
		iconEjecuta = new ImageIcon("iconos/ejecuta.png");
		botonNuevo = new JButton(iconNuevo);
		botonAcerca = new JButton(iconAcerca);
		botonEjecutar = new JButton(iconEjecuta);
		botonNuevo.setToolTipText("Crear nuevo sistema experto");
		botonEjecutar.setToolTipText("Ejecutar");
		botonAcerca.setToolTipText("Acerca de");

		toolBar.add(botonNuevo);
		toolBar.add(new JToolBar.Separator());
		toolBar.add(botonEjecutar);
		toolBar.add(new JToolBar.Separator());
		toolBar.add(botonAcerca);

		// paneles
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelScrollSalida = new JScrollPane();

		cajaTextoCentral = new JTextArea(42, 24);
		cajaTextoCentral.setEditable(false);
		panelScrollSalida.setViewportView(cajaTextoCentral);
		panelScrollSalida.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		DefaultCaret caret = (DefaultCaret) cajaTextoCentral.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); // mantiene el scroll de la caja de texto actualizado siempre
		cajaTextoCentral.setForeground(Color.BLACK);
		cajaTextoCentral.setBackground(Color.WHITE);
		panelCentral.add(panelScrollSalida);

		panelAux = new JPanel();
		panelAux.setLayout(new FlowLayout());
		panelAux.setPreferredSize(new Dimension(250, 875));
		panelAux.setBackground(Color.WHITE);

		getContentPane().add(toolBar, BorderLayout.NORTH);
		getContentPane().add(panelAux, BorderLayout.WEST);
		getContentPane().add(panelCentral, BorderLayout.CENTER);

		panelScrollSalida.setFocusable(false);
		cajaTextoCentral.setFocusable(false);

		// Propiedades generales del GUI
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setPreferredSize(new Dimension(950, 700));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - 475, dim.height / 2 - 350);
	}

	private void registrarEscuchadores() {
		menuAcercaDe.addActionListener(new ListenerAcercaDeAction(this));
		botonAcerca.addActionListener(new ListenerAcercaDeAction(this));
		botonNuevo.addActionListener(new ListenerNuevoAction(this));
		menuNuevo.addActionListener(new ListenerNuevoAction(this));
		botonEjecutar.addActionListener(new ListenerEjecutarAction(this));
		menuSalir.addActionListener(new ListenerSalir(this));
		this.addWindowListener(new ListenerGuiAction(this));

	}

	/*
	 * FUNCIONES CICLO ANIMACION
	 */
	public void crearNuevo() {

		String[] options = { "Nítido", "Difuso", "Cancelar" };
		int x = JOptionPane.showOptionDialog(null, "Elije el tipo:", "Crear un nuevo sistema experto",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iconNuevo, options, options[0]);

		// Limpieza de panel auxiliar
		try {
			panelAux.remove(Jlista);

		} catch (Exception e) {
		}
		try {
			panelAux.remove(slider1);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(slider2);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(slider3);
		} catch (Exception e) {
		}

		try {
			panelAux.remove(slider4);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(slider5);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(slider6);
		} catch (Exception e) {
		}

		try {
			panelAux.remove(label1);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(label2);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(label3);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(label5);
		} catch (Exception e) {
		}
		try {
			panelAux.remove(label4);
		} catch (Exception e) {
		}
		
		try {
			panelAux.remove(Jlista);
		} catch (Exception e) {
		}

		if (x == 0) {
			inicializarEntornoNitido();
		} else if (x == 1) {
			inicializarEntornoDifuso();
		}
		this.pack();
	}

	private void inicializarEntornoNitido() {

		creador = new CreadorSistemaExpertoNitido();
		label4 = new JLabel("Selecciona los hechos iniciales");
		label5 = new JLabel("(usa CONTROL para elegir varios):");
		panelAux.add(label4);
		panelAux.add(label5);

		String hechos[] = { "Pedido recibido", "Cliente nuevo", "Artículo disponible", "Cliente moroso", "Robot libre",
				"Robot cargado" };
		Jlista = new JList<String>(hechos);
		listaHechosIniciales = new ArrayList<String>();

		Jlista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Jlista.setBounds(50, 100, 250, 350);
		Jlista.setPreferredSize(new Dimension(250, 875));

		panelAux.add(Jlista);
		cajaTextoCentral.setText("");

		// Añadir ListSelectionListener a la lista
		Jlista.addListSelectionListener(this);
		this.pack();

	}

	private void inicializarEntornoDifuso() {

		creador = new CreadorSistemaExpertoDifuso();

		slider1 = new JSlider(JSlider.HORIZONTAL, -100, 100, -100);
		slider2 = new JSlider(JSlider.HORIZONTAL, -100, 100, 100);
		slider3 = new JSlider(JSlider.HORIZONTAL, -100, 100, -100);
		slider4 = new JSlider(JSlider.HORIZONTAL, -100, 100, 100);
		slider5 = new JSlider(JSlider.HORIZONTAL, -100, 100, -100);
		slider6 = new JSlider(JSlider.HORIZONTAL, -100, 100, 100);
		
		slider1.setPaintTrack(true);
		slider1.setPaintTicks(true);
		slider1.setPaintLabels(true);
		slider1.setMajorTickSpacing(50);
		slider1.setMinorTickSpacing(5);
		
		slider2.setPaintTrack(true);
		slider2.setPaintTicks(true);
		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(50);
		slider2.setMinorTickSpacing(5);
		
		slider3.setPaintTrack(true);
		slider3.setPaintTicks(true);
		slider3.setPaintLabels(true);
		slider3.setMajorTickSpacing(50);
		slider3.setMinorTickSpacing(5);
		
		slider4.setPaintTrack(true);
		slider4.setPaintTicks(true);
		slider4.setPaintLabels(true);
		slider4.setMajorTickSpacing(50);
		slider4.setMinorTickSpacing(5);
		
		slider5.setPaintTrack(true);
		slider5.setPaintTicks(true);
		slider5.setPaintLabels(true);
		slider5.setMajorTickSpacing(50);
		slider5.setMinorTickSpacing(5);
		
		slider6.setPaintTrack(true);
		slider6.setPaintTicks(true);
		slider6.setPaintLabels(true);
		slider6.setMajorTickSpacing(50);
		slider6.setMinorTickSpacing(5);

		label1 = new JLabel("Parámetros Velocidad Media");
		label2 = new JLabel("Parámetros Nivel de Bateria");
		label3 = new JLabel("Parámetros Potencia a aplicar");		
		
		panelAux.add(label1);
		panelAux.add(slider1);
		panelAux.add(slider2);
		panelAux.add(label2);
		panelAux.add(slider3);
		panelAux.add(slider4);
		panelAux.add(label3);
		panelAux.add(slider5);
		panelAux.add(slider6);

		cajaTextoCentral.setText("");
		this.pack();

		actualizaParametros();

		// Añadir Listeners a los sliders
		slider1.addChangeListener(new ListenerSlider(this));
		slider2.addChangeListener(new ListenerSlider(this));
		slider3.addChangeListener(new ListenerSlider(this));
		slider4.addChangeListener(new ListenerSlider(this));
		slider5.addChangeListener(new ListenerSlider(this));
		slider6.addChangeListener(new ListenerSlider(this));
	}

	public void actualizaParametros() {

		int x1 = slider1.getValue();
		int x2 = slider2.getValue();
		int x3 = slider3.getValue();
		int x4 = slider4.getValue();
		int x5 = slider5.getValue();
		int x6 = slider6.getValue();

		listaHechosIniciales = new ArrayList<String>();

		listaHechosIniciales.clear();
		listaHechosIniciales.add(Integer.toString(x1));
		listaHechosIniciales.add(Integer.toString(x2));
		listaHechosIniciales.add(Integer.toString(x3));
		listaHechosIniciales.add(Integer.toString(x4));
		listaHechosIniciales.add(Integer.toString(x5));
		listaHechosIniciales.add(Integer.toString(x6));

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// Get index of items selected
		int index[] = Jlista.getSelectedIndices();
		// Get the items selected from their indices
		listaHechosIniciales.clear();
		String str = "";
		for (int i = 0; i < index.length; i++) {
			String valor = Jlista.getModel().getElementAt(index[i]);
			str = str + valor + "\n";
			listaHechosIniciales.add(valor);

		}

		str = str.replaceAll(", $", "");
		// Change label to items selected
		cajaTextoCentral.setText("Hechos de inicio elegidos :" + "\n" + str);

	}

	public void setTexto(String texto) {

		String t = cajaTextoCentral.getText() + "\n" + texto;
		cajaTextoCentral.setText(t);

	}

	public void ejecutaSistema(CreadorSistemaExperto creador) {

		if (creador == null) {
			JOptionPane.showMessageDialog(null, "Primero debe crear un nuevo sistema experto.");
		} else {
			creador.crearVariables(); // Variables globales del sistema
			creador.datosEntrada(listaHechosIniciales); // Base de conocimiento: Inputs, Hechos
			creador.anadirReglas(); // Base de conocimiento: Reglas
			creador.ejecutarMotor(); // Motor de inferencia
		}

	}

	public CreadorSistemaExperto getCreador() {

		return creador;
	}

}