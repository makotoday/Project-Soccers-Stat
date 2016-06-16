package view;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.jme3.system.AppSettings;
import com.jme3.system.JmeCanvasContext;

import main_mi_temps.Read_file;


public class SoccerView extends JFrame{
	private  static StadeView canvasjeux; 
	private static Canvas canvas; 
	private static JPanel panelfinal; 
	private static AppSettings setting; 
	
	private Read_file filejeux; 
	private Repertoire dialogfile; 
	
	
	
	
	
	public SoccerView(){
		super("Projet Soccor Stat"); 
		InitSettingCanvas(); 
		InitFrame(); 
	}
	
	public void InitSettingCanvas(){
	    setting = new AppSettings(true);
		setting.setResolution(1280, 800);
		setting.setSamples(8);
		canvasjeux = new StadeView();
		//apply the settings and configure our application
		
		canvasjeux.setSettings(setting);
		canvasjeux.setShowSettings(false);
		setting.setFrameRate(60);
		setting.setVSync(true);
		canvasjeux.setDisplayFps(false);
		canvasjeux.setDisplayStatView(false);
		canvasjeux.createCanvas();
		JmeCanvasContext ctx = (JmeCanvasContext) canvasjeux.getContext();
		canvas = ctx.getCanvas();
		Dimension dim = new Dimension(setting.getWidth(), setting.getHeight());
		canvas.setPreferredSize(dim);
	}
	public void InitFrame(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO : Uncomment this in order to stop the application
				// when the windows will be closed.
				 canvasjeux.stop();
			}
		});
		
		// je definis le type de mon grand panel 
		panelfinal=new JPanel(new BorderLayout()); 
		
		// definition des compossante de la fenetre
		final JMenuBar menubar = new JMenuBar();
		final JMenu objectsMenu = new JMenu("File");
		final JMenu helpMenu = new JMenu("Help");

		final JMenuItem ouvrirFichierItem = new JMenuItem("Lancer une mi-temps");

		objectsMenu.add(ouvrirFichierItem);
		menubar.add(objectsMenu);
		menubar.add(helpMenu);
		setJMenuBar(menubar);
		ouvrirFichierItem.addActionListener(new ActionListener(){
			@Override 
			public void actionPerformed(ActionEvent e){
				dialogfile=new Repertoire(); 
				if(dialogfile.isPathNUll()==false){
					filejeux=new Read_file(); 
					filejeux.setFilePath(dialogfile.getPath());
				}
				
			}
		});
	


		
		
		panelfinal.add(new JButton("Swing Components"), BorderLayout.WEST);
		// Add the canvas to the panel
		panelfinal.add(canvas, BorderLayout.CENTER);
		
		add(panelfinal);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	public static void main(String [] agrs){
		SoccerView jeux=new SoccerView(); 
	}
}
