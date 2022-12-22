package principal;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import nitido.Expresion;
import nitido.Hecho;




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

public class Gui extends JFrame implements ListSelectionListener{  //implements Runnable {

	private static final long serialVersionUID = 1L;
	private BufferStrategy bs;
	private volatile boolean running;
	private Thread gameThread;


	private int anchoMapa = 1024; // 65536;





	JScrollPane scrollPane;
	private JPanel panelCentral;
	private JPanel panelAux;
	
	private JScrollPane panelScrollSalida;
	private JTextArea cajaTextoCentral;
	private JMenuBar menuBar;
	private JMenu menu1,menu2, menu3;
	private JMenuItem menuNuevo, menuSalir,menuNotificaciones, menuAcercaDe;
	private JToolBar toolBar;
	private JButton botonNuevo;
	private JButton botonAcerca;
	private JButton botonEjecutar;
	

	private Icon iconNuevo;
	private Icon iconAcerca;
	
	private JList<String> Jlista;
	private List<String> listaHechosIniciales;
		
	private JLabel label1 ,label2,label3 ;
	private CreadorSistemaExperto creador;
	private JSlider slider1,slider2,slider3,slider4,slider5,slider6;


	public Gui() {
		setTitle("Sistema Experto(AEC2: Patrones de Diseño)");
		inicializarComponentesGUI();
		registrarEscuchadores();
		pack();
		setVisible(true);
		
		//inicializarMapa();
		//panelCentral.createBufferStrategy(2);
		//bs = panelCentral.getBufferStrategy();
		setFocusable(true); // permite recibir eventos del teclado
		
		
		
		
		
		//creador = new CreadorSistemaExpertoDifuso();
			
		
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
		menuBar.add(menu1);
		menu1.add(menuNuevo);
		menu1.add(menuSalir);		
		menuAcercaDe = new JMenuItem("Acerca de");
		menu3 = new JMenu("Acerca de");
		menu3.add(menuAcercaDe);
		menuBar.add(menu3);
		this.setJMenuBar(menuBar);
		
		
		
		
		
		
		
		

		// Barra de herramientas
		toolBar = new JToolBar("barra");
		iconNuevo = new ImageIcon("iconos/nuevo.png");
		iconAcerca = new ImageIcon("iconos/acerca.png");
		botonNuevo = new JButton(iconNuevo);
		botonAcerca = new JButton(iconAcerca);
		botonEjecutar = new JButton(iconAcerca);
		botonNuevo.setToolTipText("Crear metaverso nuevo");
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
		setPreferredSize(new Dimension(1335, 875));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - 700, dim.height / 2 - 500);
	}

	private void registrarEscuchadores() {
		menuAcercaDe.addActionListener(new AcercaDeActionListener(this));
		botonAcerca.addActionListener(new AcercaDeActionListener(this));
		botonNuevo.addActionListener(new NuevoActionListener(this));		
		menuNuevo.addActionListener(new NuevoActionListener(this));
		botonEjecutar.addActionListener(new EjecutarActionListener(this));
		menuSalir.addActionListener(new SalirListener(this));
		panelCentral.addMouseMotionListener(new MousseListener(this));
		this.addWindowListener(new GuiActionListener(this));
		this.addKeyListener(new TecladoListener(this));
	
	}

	

	/*
	 * FUNCIONES CICLO ANIMACION
	 */
	public void crearNuevo() {
		
	
	String[] options = {"Nítido", "Difuso", "Cancelar"};
    int x = JOptionPane.showOptionDialog(null, "Elije el sistema experto",
            "Crear nuevo sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, iconNuevo, options, options[0]);
    
    
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
    
    
    if (x == 0) {
    	
    	inicializarEntornoNitido();    	
    	
    } else if (x == 1) {
    	
    	try {
			panelAux.remove(Jlista);
			this.pack();
    	} catch (Exception e) {			
		}
    	inicializarEntornoDifuso(); 
    } 
    this.pack();
	}
	
	private void inicializarEntornoNitido() {
		
		
		creador = new CreadorSistemaExpertoNitido(); 
		
		String hechos[]={		
				"Pedido recibido",
				"Cliente nuevo",			
				"Artículo disponible",
				"Cliente moroso",			
				"Robot libre",
				"Robot cargado"		
			};
		Jlista = new JList<String>(hechos);
		listaHechosIniciales = new ArrayList<String>();
		
		Jlista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Jlista.setBounds(50,100,250,350);
		Jlista.setPreferredSize(new Dimension(250, 875));
		
		panelAux.add(Jlista);
		cajaTextoCentral.setText("");
		
		//Add ListSelectionListener to list
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
		
		label1 = new JLabel("Parámetros Velocidad Media");
		label2 =  new JLabel("Parámetros Nivel de Bateria");
		label3 =  new JLabel("Parámetros Potencia a aplicar");

		panelAux.add(label1 );
		panelAux.add(slider1 );
		panelAux.add(slider2 );
		panelAux.add(label2 );
		panelAux.add(slider3 );
		panelAux.add(slider4);
		panelAux.add(label3 );
		panelAux.add(slider5 );
		panelAux.add(slider6 );
		
		cajaTextoCentral.setText("");
		this.pack();
		
		actualizaParametros();
		
		
		
		
		slider1.addChangeListener(new SliderListener(this));
		slider2.addChangeListener(new SliderListener(this));
		slider3.addChangeListener(new SliderListener(this));
		slider4.addChangeListener(new SliderListener(this));
		slider5.addChangeListener(new SliderListener(this));
		slider6.addChangeListener(new SliderListener(this));
	}
	
	
	public void actualizaParametros() {
		
		int x1 = slider1.getValue();
		int x2 = slider1.getValue();
		int x3 = slider1.getValue();
		int x4 = slider1.getValue();
		int x5 = slider1.getValue();
		int x6 = slider1.getValue();
		
		
		listaHechosIniciales.clear();
		
		listaHechosIniciales.add(Integer.toString(x1));
		listaHechosIniciales.add(Integer.toString(x2));
		listaHechosIniciales.add(Integer.toString(x3));
		listaHechosIniciales.add(Integer.toString(x4));
		listaHechosIniciales.add(Integer.toString(x5));
		listaHechosIniciales.add(Integer.toString(x6));
		
		
		
	}
	
	
	

	private void bucleAnimacion(float delta) {

		
		dibujarPanelMapa();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
		}
	}



	private void dibujarPanelMapa() {
		do {
			do {
				Graphics g = null;
				try {
					g = bs.getDrawGraphics();
					dibujarMapa(g);
				} finally {
					if (g != null) {
						g.dispose();
					}
				}
			} while (bs.contentsRestored());
			bs.show();
		} while (bs.contentsLost());
	}

	private void dibujarMapa(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, 769, 769);

		

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		//Get index of items selected
		int index[]=Jlista.getSelectedIndices();
		//Get the items selected from their indices
		listaHechosIniciales.clear();
		String str=""; 
		for(int i=0;i<index.length;i++) {
			String valor = Jlista.getModel().getElementAt(index[i]);
			str=str+ valor+ "\n"  ;			
			listaHechosIniciales.add(valor);
			
		}
			
		        str=str.replaceAll(", $", "");
		//Change label to items selected
		cajaTextoCentral.setText("Hechos de inicio elegidos :"+"\n"+str);
		
		
	}
	
	public void setTexto(String texto) {
		String t= cajaTextoCentral.getText()+"\n"+texto;
		cajaTextoCentral.setText(t);
		
	}
	
	
	
	public void ejecutaSistema(CreadorSistemaExperto creador) {

		
		creador.crearVariables(); // Variables globales del sistema
		creador.datosEntrada(listaHechosIniciales); // Base de conocimiento: Inputs, Hechos
		creador.anadirReglas(); // Base de conocimiento: Reglas
		creador.ejecutarMotor(); // Motor de inferencia
		

	}
	
	public CreadorSistemaExperto getCreador() {
		
		return creador;
	}

}