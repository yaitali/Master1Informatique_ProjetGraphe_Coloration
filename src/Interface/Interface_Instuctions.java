package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.TextArea;
import java.awt.ScrollPane;



public class Interface_Instuctions extends JFrame  {
	 private JLabel lblInstructions = new JLabel("Instructions");
	  private static JPanel container = new JPanel();
	  private static JPanel panel = new JPanel();
	  private final JTextArea textArea_1 = new JTextArea(25,90);
	  
          public Interface_Instuctions() {
        	  
        	container.setLayout(new BorderLayout());
      		JPanel middel = new JPanel();
      		middel.setBackground(Color.LIGHT_GRAY);
      	    container.add(middel, BorderLayout.CENTER);
      	   
      	    
      	  JTextArea textArea_1 = new JTextArea( 
      			"\r\n" + 
      			"Ce projet est intitulé « Coloration de graphe »\r\n"+ 
      			"Colorer un graphe signifie:\r\n" +
      			"attribuer une couleur à chacun de ses nœuds, de maniere a ce que \r\n" + 
      			"deux nœuds adjacents soient de couleur diffirente.\r\n" + 
      			"Et souvent on recherche l'utilisation d'un nombre minimal de couleurs,dit nombre chromatique.\r\n "
      			+"\r\n" + 
      			"Manuel d'utilisation :\r\n"
      		    +"Pour créer un sommet ,il faut cliquer avec le bouton gauche de la sourie.\r\n"
      			+"Pour relier deux sommets ,il faut cliquer avec les bouton gauche,sur chaqun des sommets.\r\n"
      		    +"Pour executer l'algorithme de coloriage,il faut appuier sur le bouton Colorier en bas de la fenetre principale .\r\n"
      			
      		); 
      	  textArea_1.setForeground(Color.WHITE);
      	  textArea_1.setRows(18);
      	  textArea_1.setColumns(55);
      	  textArea_1.setFont(new Font("Serif", Font.BOLD, 18));
      	  textArea_1.setBackground(Color.DARK_GRAY);
          textArea_1.setLineWrap(true); 
          textArea_1.setWrapStyleWord(true);
      	    middel.add(textArea_1);
      	    Font police = new Font("Tahoma", Font.BOLD, 20);
            lblInstructions.setBackground(Color.BLACK);
            lblInstructions.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
            panel.setForeground(Color.LIGHT_GRAY);
            panel.setBackground(Color.LIGHT_GRAY);
            lblInstructions.setForeground(Color.DARK_GRAY);
            lblInstructions.setHorizontalAlignment(JLabel.CENTER);
            panel.add(lblInstructions, BorderLayout.NORTH);
            container.add(panel, BorderLayout.NORTH);
            this.setContentPane(container);
            this.setResizable(false);
            this.setVisible(true);
            this.setSize(new Dimension(900, 550));
             
          }
          }
                

