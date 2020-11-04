/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte.Case;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.ressources;
import java.util.ArrayList;

/**
 *
 * @author dm645996
 */
public abstract class Case {
    private Coordonnee coordonnee;
    private ressources ressource;
    private ArrayList<Case> voisins;
    private TypeBatiment batiment;

    /**
     * 
     * @param coordonnee 
     */
    public Case(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList();
    }
/**
 * 
 * @return 
 */
    public Coordonnee getCoordonnee() {
        return coordonnee;
    }
/**
 * 
 * @return 
 */
    public ressources getRessource() {
        return ressource;
    }
/**
 * 
 * @param ressource 
 */
    public void setRessource(ressources ressource) {
        this.ressource = ressource;
    }
    /**
     * 
     * @return 
     */
     public ArrayList<Case> getVoisins(){
        return this.voisins;
    }
     /**
      * 
      * @param voisins 
      */
    public void ajouterVoisins(Case voisins){
        this.voisins.add(voisins);
    }
    
    public abstract TypeCase getType();
    
    /**
     * 
     * @return 
     */
    public boolean estVide(){
        boolean r = false;
        if(this.getRessource()== null && this.batiment == null){
         r = true;   
        }
        return r;
    }
    public abstract boolean estAccessible();
    /**
     * 
     * @param arrivee
     * @return 
     */
    public TypeMouvement getMouvementPourAller(Case arrivee){
        TypeMouvement tm;
        
        tm = this.getCoordonnee().getMouvementPourAller(arrivee.getCoordonnee());
        return tm;
                
    }

    public TypeBatiment getBatiment() {
        return batiment;
    }

    public void setBatiment(TypeBatiment batiment) {
        this.batiment = batiment;
    }
    
}
