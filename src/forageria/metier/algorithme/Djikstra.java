/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.algorithme;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Case.TypeCase;
import forageria.metier.carte.ressources.ressources;
import forageria.metier.carte.ressources.TypeRessource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Alexandre
 */
public class Djikstra extends AlgorithmeCalculDistance{

    private HashMap<Case,Boolean> estVisite;
    private HashMap<Case,Case> predecesseur;
    private int infini = 1 + 16*getCarte().getTaille()*getCarte().getTaille();

    public Djikstra(Carte carte) {
        super(carte);
        this.estVisite = new HashMap<>();
        this.predecesseur = new HashMap<>();
        infini = 1+16*getCarte().getTaille()*getCarte().getTaille();
        
    }
    
    protected int coutMouvementVers(Case destination){ //Verify
        
        int res = 1;
        TypeCase c = destination.getType();
        
        if (c == TypeCase.Eau || destination.getBatiment() != null){
            res = infini;
        }else if((!destination.estVide())){
            res = (destination.getRessource().nombreCoupsPioches())+1;            
        }
        return res;
    }
    
    private void initialisation(Case depart){
        
        for(Case v: this.getCarte().getCases()){
            this.setDistance(v,this.infini);
            this.estVisite.put(v, Boolean.FALSE);
            this.predecesseur.put(v, null);
        }
        this.setDistance(depart, 0);
        
    }
    
    private void relachement(Case a,Case b){
        
        if(this.getDistance(b)>this.getDistance(a)+this.coutMouvementVers(b)){
            this.setDistance(b, this.getDistance(a)+this.coutMouvementVers(b));
            this.predecesseur.put(b, a);  
        }
    }
    
    private Case getCaseLaPlusProche(){ //Verify
        
        int distanceMin = this.infini;
        Case res = null;
        
        for(Case c:this.getCarte().getCases()){
            if(this.estVisite.get(c) == Boolean.FALSE && this.getDistance(c)<distanceMin){
                distanceMin = this.getDistance(c);
                res = c;
            }
        }
        return res;
    }
    
    @Override
    public void calculerDistancesDepuis(Case depart) { //Verify
        initialisation(depart);
        Case caseLaPlusProche = this.getCaseLaPlusProche();
        while(caseLaPlusProche != null){//ICI WHAT
            
            this.estVisite.put(caseLaPlusProche, Boolean.TRUE);
            
            ArrayList<Case> voisins = caseLaPlusProche.getVoisins();
            for(Case voisin:voisins){
                relachement(caseLaPlusProche, voisin);
            }
            caseLaPlusProche = this.getCaseLaPlusProche();
        }
    }

    @Override
    public ArrayList<TypeMouvement> getChemin(Case arrivee) { //Verify
        
        ArrayList<TypeMouvement> res = new ArrayList<>();
        Case caseEnCours = arrivee;
        
        Case casePrecedente = this.predecesseur.get(caseEnCours);
            while(casePrecedente != null){
                res.add(casePrecedente.getMouvementPourAller(caseEnCours));
                caseEnCours = casePrecedente;
                casePrecedente = this.predecesseur.get(caseEnCours);
            }
        Collections.reverse(res);
        return res;
        
    } 

    public int getInfini() {
        return infini;
    }
    
}
