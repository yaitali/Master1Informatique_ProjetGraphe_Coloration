package Graphe;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * structure de donnée pour définir un graphe
 * en utilisant les arrets et les sommet déja 
 * définit dans deux classe differentes
 *
 */
public class  Graphe{
    protected List<Sommet> sommets;
    protected List<Arret> arrets;
    private int size=0;
    
public Graphe(Graphe graphe){
        this.sommets.addAll(graphe.sommets);
        this.arrets.addAll(graphe.arrets);
    }
    
public Graphe(){
        sommets=new LinkedList<Sommet>();
        arrets=new LinkedList<Arret>();
    }
    
public void ajouterSommet(Sommet sommet){
        size++;
        sommets.add(sommet);
        
    }
public boolean ajouterArret(Arret arret){
        return arrets.add(arret);
    }
    
    
public Collection<Sommet> getSommetsEnRelation(Sommet s){
        Collection<Sommet> col=new LinkedList<Sommet>();
        Iterator<Arret> it=arrets.iterator();
        while(it.hasNext()){
            Arret arret=it.next();
            if(s.equals(arret.get_Premier_Sommet())) col.add(arret.get_Deuxieme_Sommet());
            else if(s.equals(arret.get_Deuxieme_Sommet())) col.add(arret.get_Premier_Sommet());
        }
        return col;
    }
    
 
public int size(){
        return size;
    }
    
public Collection<Sommet> getSommets(){
        return sommets;
    }
public Collection<Arret> getArrets(){
        return arrets;
    }
public int degree(Sommet s){
        return this.getSommetsEnRelation(s).size();
    }
    @Override
public String toString(){
        String tmp="";
        for(int i=0;i<sommets.size();i++){
            tmp+=sommets.get(i);
        }
        return tmp;

    }
}