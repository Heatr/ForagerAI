/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.algorithme;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import java.util.ArrayList;


/**
 *
 * @author dm645996
 */
public class ParcoursLargeur extends AlgorithmeCalculDistance{
    
    public ParcoursLargeur(Carte carte) {
        super(carte);
    }
/**
 * 
 * @param depart 
 */
    @Override
    public void calculerDistancesDepuis(Case depart) {
        ArrayList<Case> aTraiter = new ArrayList<>();
        aTraiter.add(depart);
        this.reinitialisationDistances();
        
        
        this.setDistance(depart, 0);
        
        while(!aTraiter.isEmpty()){
            Case caseEnCours = aTraiter.get(0);
            aTraiter.remove(0);
            for(Case c:caseEnCours.getVoisins()){
                if(this.getDistance(c)==null){
                   if(c.estAccessible()){
                       this.setDistance(c, this.getDistance(caseEnCours)+1);
                       aTraiter.add(c);
                   }
                }
            }
        }
    }
/**
 * 
 * @param arrivee
 * @return 
 */
    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) {
       ArrayList<TypeMouvement>resultat = new ArrayList();
       Case caseEnCours = arrivee;
       Case casePrecedente = null;
       
       if(this.getDistance(caseEnCours)!= null){
          while(this.getDistance(caseEnCours)> 0){
             ArrayList<Case> voisin = new ArrayList();
             voisin = caseEnCours.getVoisins();
             for(Case c: voisin){
                 if(this.getDistance(c) != null && this.getDistance(c) == this.getDistance(caseEnCours)-1){
                     casePrecedente = c;
                 }
             }
             resultat.add(casePrecedente.getMouvementPourAller(caseEnCours));
             caseEnCours = casePrecedente;
          } 
          java.util.Collections.reverse(resultat);
       }      
       return resultat;
    }
    
}
