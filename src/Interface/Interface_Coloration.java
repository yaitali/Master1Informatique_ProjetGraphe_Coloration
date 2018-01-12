package Interface;

import Interface.Constructeur_Graphe.ArretGui;
import Interface.Constructeur_Graphe.SommetGui;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
 

public class Interface_Coloration extends JFrame implements MouseListener,ActionListener {
	  private static JPanel pan = new JPanel();
	  private JButton bouton = new JButton("Instructions");
	  private JButton bouton2 = new JButton("Rénitialiser");
	  private JButton bouton3 = new JButton("Colorier");
	  private static JPanel container = new JPanel();
	  private JFrame applet;
	  private Interface_Instuctions fen;
	     
	public Interface_Coloration() {
		container.setLayout(new BorderLayout());
		pan.setBackground(Color.DARK_GRAY);
		container.add(pan, BorderLayout.CENTER);
		JPanel south = new JPanel();
		south.setForeground(Color.GRAY);
		south.setBackground(Color.LIGHT_GRAY);
		bouton.setBackground(Color.WHITE);
		bouton.setForeground(Color.DARK_GRAY);
		bouton.setPreferredSize(new Dimension(300, 40));
		bouton.setFont(new java.awt.Font("Serif",1,20));
		bouton2.setBackground(Color.WHITE);
		bouton2.setForeground(Color.DARK_GRAY);
		bouton2.setPreferredSize(new Dimension(300, 40));
		bouton2.setFont(new java.awt.Font("Serif",1,20));
		bouton3.setBackground(Color.WHITE);
		bouton3.setForeground(Color.DARK_GRAY);
		bouton3.setPreferredSize(new Dimension(300, 40));
		bouton3.setFont(new java.awt.Font("Serif",1,20));
	    south.add(bouton);
	    south.add(bouton2);
	    south.add(bouton3);
	    bouton.addActionListener(this);
	    bouton3.addActionListener(this);
	    container.add(south, BorderLayout.SOUTH); 
	    this.add(container);	
		
	}
	    private static Interface_Coloration Interface_Coloration = new Interface_Coloration();
	    private Constructeur_Graphe graphe;
	    
	    public void mouseClicked(MouseEvent e){
		if(e.getButton()==MouseEvent.BUTTON1){
	            SommetGui s=graphe.new SommetGui(graphe.size()+1,e.getPoint().x,e.getPoint().y);
		        graphe.ajouterSommet(s);
		        Interface_Coloration.add(s.dessine());
		        Interface_Coloration.add(container);	
	            
	            
		}
	    }
	    public void 	mouseEntered(MouseEvent e){}
	    public void 	mouseExited(MouseEvent e){}
	    public void 	mousePressed(MouseEvent e){}
	    public void 	mouseReleased(MouseEvent e){}
	    
	@Override
	public void actionPerformed(ActionEvent arg0) {
		  if(arg0.getSource() == bouton) {
			 fen = new Interface_Instuctions(); 
			
		  }
		    
		  if(arg0.getSource() == bouton3) {
			  graphe.colorier();
			  graphe.dessine();
	        
		  }
		   
		  if(arg0.getSource() == bouton2) {
			
			   
				
		  }}
		    
		
	
	
	 public static void main(String s[]) {
		   
		    Interface_Coloration.setResizable(false);
		    Interface_Coloration.addWindowListener(
					new WindowAdapter() {
		            @Override
					    public void windowClosing(WindowEvent e) {
						System.exit(0);
					    }
					}
					);
		   
		    Interface_Coloration.addMouseListener(Interface_Coloration);
		    Interface_Coloration.graphe= new Constructeur_Graphe(Interface_Coloration.getGraphics(),Interface_Coloration);
		    Interface_Coloration.setSize(new Dimension(1000, 1000));
		    Interface_Coloration.show();
		   
		  }
	
	
	
	
	
	}