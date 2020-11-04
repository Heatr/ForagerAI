/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.algorithme;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author dm645996
 */
public abstract class AlgorithmeCalculDistance {

    private Carte carte;
    private HashMap<Case,Integer> distances;

    public AlgorithmeCalculDistance(Carte carte) {
        this.carte = carte;
        distances = new HashMap<>();
    }
/**
 * 
 * @return 
 */
    protected Carte getCarte(){
        return this.carte;
    }
/**
 * 
 * @param position
 * @param valeur 
 */
    protected void setDistance(Case position, int valeur){
        this.distances.put(position,valeur);
    }
/**
 * 
 * @param arrivee
 * @return 
 */
    public Integer getDistance(Case arrivee){
        Integer i;
        i = this.distances.get(arrivee);
        return i;
    }


    protected void reinitialisationDistances(){
        this.distances.clear();
    }

    public abstract void calculerDistancesDepuis(Case depart);

    public abstract ArrayList<TypeMouvement>getChemin(Case arrivee);


}
