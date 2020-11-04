/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte;

import forageria.metier.TypeMouvement;

/**
 *
 * @author dm645996
 */
public class Coordonnee {
   private int ligne;
   private int colonne;

    public Coordonnee(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }
   
    public int getLigne(){
       return this.ligne;       
    }
    public int getColonne(){
        return this.colonne;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.ligne;
        hash = 67 * hash + this.colonne;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordonnee other = (Coordonnee) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colonne != other.colonne) {
            return false;
        }
        return true;
    }
        public Coordonnee getVoisin(TypeMouvement mouvement){
        
        Coordonnee c = null;
        
        switch(mouvement){
            
            case TOP:
                c = new Coordonnee(getLigne()-1, getColonne());
                break;
            case BOTTOM:
                c = new Coordonnee(getLigne()+1, getColonne());
                break;
            case LEFT:
                c = new Coordonnee(getLigne(), getColonne()-1);
                break;
            case RIGHT:
                c = new Coordonnee(getLigne(), getColonne()+1);
                break;     
        }
        
        return c;
    }
    public TypeMouvement getMouvementPourAller(Coordonnee destination){
       TypeMouvement t = null;
  
           if (destination.getColonne() == this.getColonne()+1 && destination.getLigne() == this.getLigne()){
               t = TypeMouvement.RIGHT;
           }
           else if (destination.getColonne() == this.getColonne()-1 && destination.getLigne() == this.getLigne()){
               t = TypeMouvement.LEFT;
           }
           else if(destination.getLigne() == this.getLigne()+1 && destination.getColonne() == this.getColonne()){
               t = TypeMouvement.BOTTOM;
           }
           else if(destination.getLigne() == this.getLigne()-1 && destination.getColonne() == this.getColonne()){
               t = TypeMouvement.TOP;
           }       
       return t;       
    }

    @Override
    public String toString() {
        return "Coordonnee{" + "ligne=" + ligne + ", colonne=" + colonne + '}';
    }
}
