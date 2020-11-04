/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.algorithme.Djikstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Coordonnee;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class EtatTrouverSiteFourneau extends Etat{
    private ArrayList<TypeMouvement>chemin;
    private Djikstra dijkstra;

    public EtatTrouverSiteFourneau(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
       Etat e = null;
        
        if(this.chemin.isEmpty()){
            e = new EtatAttendre(this.getModule());
        }else{
            e = new EtatSeDeplacer(this.getModule(), this.chemin);
        }
        
        return e;
    }

    @Override
    public void action() {
      Carte carte = this.getMemoire().getCarte();
        this.dijkstra = new Djikstra(carte);
        Case actuelle = this.getMemoire().getCaseJoueur();
        this.dijkstra.calculerDistancesDepuis(actuelle);
       
        int coutMin = -1;
        Case zoneRetenue = null;
        for(Case c:carte.getCases() ){
            if(carte.estZoneValide(c)){
                int cout = this.coutZone(c);
                if(zoneRetenue == null || cout<coutMin){
                    coutMin = cout;
                    zoneRetenue = c;
                }
            }
        }
        this.chemin = this.dijkstra.getChemin(zoneRetenue);
        this.getMemoire().setSiteFourneau(zoneRetenue.getCoordonnee());
    }
    private int coutZone(Case coinBasGauche){
        int cout = dijkstra.getDistance(coinBasGauche); 
        for(int i=0;i<2;i++) { 
           for(int j=0;j<2;j++) {
              if(i!=0 || j!=0) { 
                 Coordonnee coordonnee = coinBasGauche.getCoordonnee();
                 Case position = this.getMemoire().getCarte().getCase(new Coordonnee(coordonnee.getLigne()-i,coordonnee.getColonne()+j));
                 if(position.getRessource() != null) { 
                    cout += position.getRessource().nombreCoupsPioches(); 
                 }
              } 
           } 
        }
        return cout; 
    }
    
}
