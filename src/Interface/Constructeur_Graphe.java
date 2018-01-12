package Interface;
import Graphe.Algo_Dsat;
import Graphe.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Constructeur_Graphe extends Algo_Dsat{
    private Graphics graphics;
    private static boolean cliqueSurSommet=false;
    private static SommetGui sommetClique;
    public static final Color[] couleurs={Color.gray,Color.red,Color.blue,Color.yellow,Color.PINK,Color.magenta,Color.black};
    private JFrame applet;
    
    public Constructeur_Graphe(Graphics g,JFrame jf){
        applet=jf;
        graphics=g;
    }
    public void dessine(){
        Iterator<Sommet> itsommets=this.getSommets().iterator();
        while(itsommets.hasNext()){
            SommetGui sommet=(SommetGui)itsommets.next();
            sommet.jpanel.update(sommet.jpanel.getGraphics());
        }
    }
     
    class SommetGui extends Sommet implements MouseListener{
        private int x;
        private int y;
        private JPanel jpanel=new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(couleurs[getCouleur()]);
                g.fillOval(0, 0, 60, 60);
                g.setColor(Color.WHITE);
                g.drawString(getNumero()+"", 0+30, 0+30);
            }

        };


        SommetGui(int nbr,int x,int y) {
            super(nbr,0);
            this.x=x;
            this.y=y;
        }
        
        public JPanel dessine(){
            applet.add(jpanel);
            jpanel.setBounds(x, y, 60, 60);
            jpanel.setOpaque(false);
            jpanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            jpanel.addMouseListener(SommetGui.this);
            jpanel.paint(jpanel.getGraphics());
            return jpanel;
        }
        public void mouseClicked(MouseEvent e) {
        	System.out.println("dessiner une arrete");
            if(cliqueSurSommet){
                ArretGui a=new ArretGui(sommetClique, this);
                if(Constructeur_Graphe.this.ajouterArret(a))
                {
                    applet.add(a.dessine());
                }
                cliqueSurSommet=false;
                
            }else{
                sommetClique=this;
                cliqueSurSommet=true;
            }
        }

        public void mousePressed(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
            this.setCouleur(2);
            this.jpanel.update(jpanel.getGraphics());
        }

        public void mouseReleased(MouseEvent e) {
        //    throw new UnsupportedOperationException("Not supported yet.");
            this.setCouleur(0);
            this.jpanel.update(jpanel.getGraphics());
        }

        public void mouseEntered(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet.");
        }

        public void mouseExited(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    class ArretGui extends Arret{
         private JPanel jpanel=new JPanel(){
            @Override
            public void paint(Graphics g){
                g.setColor(couleurs[0]);
                SommetGui Premier_Sommet=(SommetGui) ArretGui.this.get_Premier_Sommet();
                SommetGui Deuxieme_Sommet=(SommetGui) ArretGui.this.get_Deuxieme_Sommet();
                int w=Math.abs(Deuxieme_Sommet.x-Premier_Sommet.x);
                int h=Math.abs(Deuxieme_Sommet.y-Premier_Sommet.y);
                if(Premier_Sommet.x<Deuxieme_Sommet.x){
                    if(Premier_Sommet.y<Deuxieme_Sommet.y)
                        g.drawLine(0, 0, w, h);
                    else
                        g.drawLine(0,h,w ,0 );
                }else
                    if(Premier_Sommet.y>Deuxieme_Sommet.y)
                        g.drawLine(0, 0, w, h);
                    else
                        g.drawLine(0,h,w ,0 );


            }

        };

        ArretGui(SommetGui Premier_Sommet,SommetGui Deuxieme_Sommet){
            super(Premier_Sommet,Deuxieme_Sommet);
        }
        public JPanel dessine(){
            applet.add(jpanel);
            jpanel.setOpaque(false);
            jpanel.paint(jpanel.getGraphics());
            SommetGui Premier_Sommet=(SommetGui) ArretGui.this.get_Premier_Sommet();
            SommetGui Deuxieme_Sommet=(SommetGui) ArretGui.this.get_Deuxieme_Sommet();
            int x,y,w=Math.abs(Deuxieme_Sommet.x-Premier_Sommet.x),h=Math.abs(Deuxieme_Sommet.y-Premier_Sommet.y);

             if(Premier_Sommet.x<Deuxieme_Sommet.x){
                 x=Premier_Sommet.x;
                 if(Premier_Sommet.y<Deuxieme_Sommet.y)
                     y=Premier_Sommet.y;
                 else
                     y=Deuxieme_Sommet.y;
                }else{
                    x=Deuxieme_Sommet.x;
                    if(Premier_Sommet.y>Deuxieme_Sommet.y)
                        y=Deuxieme_Sommet.y;
                    else
                        y=Premier_Sommet.y;
                }
            jpanel.setBounds(x+20, y+20,w, h);
            return jpanel;
        }
    }
}

