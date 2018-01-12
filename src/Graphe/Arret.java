package Graphe;

public class Arret {
    private Sommet Premier_Sommet;
    private Sommet Deuxieme_Sommet;
    
    public Arret(Sommet Premier_Sommet , Sommet Deuxieme_Sommet){
        this.Premier_Sommet=Premier_Sommet;
        this.Deuxieme_Sommet=Deuxieme_Sommet;
    }
    
    
    public Sommet get_Premier_Sommet(){
        return Premier_Sommet;
    }
    public Sommet get_Deuxieme_Sommet(){
        return Deuxieme_Sommet;
    }
    @Override
    public int hashCode(){
        return Premier_Sommet.getNumero()*7+Deuxieme_Sommet.getNumero()*5;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arret arret = (Arret) obj;
        if(
                (this.Premier_Sommet.equals(arret.Premier_Sommet) && this.Deuxieme_Sommet.equals(arret.Deuxieme_Sommet)) ||
                (this.Premier_Sommet.equals(arret.Deuxieme_Sommet) && this.Premier_Sommet.equals(arret.Deuxieme_Sommet))
                
                ) return true;

        
        return false;
    }
}
