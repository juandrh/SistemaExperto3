package principal;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		
	private JLabel etiqueta2,etiqueta3 ;
	private CreadorSistemaExperto creador;


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
		
		
		
		
		creador = new CreadorSistemaExpertoNitido(); 
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
		menuNuevo = new JMenuItem("Nuevo metaverso");
		menuSalir = new JMenuItem("Salir");
		menuBar.add(menu1);
		menu1.add(menuNuevo);
		menu1.add(menuSalir);
		menu2 = new JMenu("Notificaciones");
		menuNotificaciones = new JMenuItem("Mostrar / ocultar Notificaciones");
		menu2.add(menuNotificaciones);	
		menuBar.add(menu2);
		menuAcercaDe = new JMenuItem("Acerca de");
		menu3 = new JMenu("Acerca de");
		menu3.add(menuAcercaDe);
		menuBar.add(menu3);
		this.setJMenuBar(menuBar);
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
		Jlista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		Jlista.setBounds(50,100,250,350);
		Jlista.setPreferredSize(new Dimension(400, 875));
		
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
		panelAux.setLayout(new BorderLayout());
		panelAux.add(Jlista,BorderLayout.CENTER );
		//panelMapa.setBackground(new Color(100, 50, 50));

		getContentPane().add(toolBar, BorderLayout.NORTH);
		getContentPane().add(panelAux, BorderLayout.WEST);
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		panelScrollSalida.setFocusable(false);
		cajaTextoCentral.setFocusable(false);
		
		
		//Add ListSelectionListener to list
	      Jlista.addListSelectionListener(this);
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