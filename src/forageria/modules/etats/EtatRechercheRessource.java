/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithme.AlgorithmeCalculDistance;
import forageria.metier.algorithme.Djikstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.metier.carte.ressources.ressources;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class EtatRechercheRessource extends Etat{
    
   private ArrayList<TypeMouvement> chemin;
    private ressources ressource; 
    private ArrayList<TypeRessource>ressourcesRecherchees;
    
    public EtatRechercheRessource(ModuleDecision module,ArrayList<TypeRessource> typesRessource) {
        super(module);
        this.ressourcesRecherchees = typesRessource;
    }

    @Override
    public Etat transition() {
        Etat t = null;
        if(this.chemin == null){
            t = new EtatAttendre(this.getModule());
        }else{
            t = new EtatCollecter(this.getModule(), ressource,chemin);
        }
        return t;
        
    }

    @Override
    public void action() {
        
        Carte c = this.getMemoire().getCarte();
        AlgorithmeCalculDistance d = new Djikstra(c);
        Case joueurPos = this.getMemoire().getCaseJoueur();
        d.calculerDistancesDepuis(joueurPos);
        
        int distanceMin = -1;
        Case arbreLePlusProche = null;
        
        for(Case c1:c.getCases()){
            for(TypeRessource type: this.ressourcesRecherchees){
            if(c1.getRessource() != null && c1.getRessource().getType() == type){
                if(arbreLePlusProche == null || d.getDistance(c1)<distanceMin){
                    distanceMin = d.getDistance(c1);
                    arbreLePlusProche = c1;
                }
            }
            }        
        }
        if(arbreLePlusProche != null){
            this.ressource = arbreLePlusProche.getRessource();
            this.chemin = d.getChemin(arbreLePlusProche);
        }
        
    }
    
    
}
