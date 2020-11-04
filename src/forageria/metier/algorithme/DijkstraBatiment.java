/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.algorithme;

import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Case.TypeCase;
import forageria.metier.carte.TypeBatiment;

/**
 *
 * @author natha
 */
public class DijkstraBatiment extends Djikstra{
    private TypeBatiment typeBatiment;
    
    public DijkstraBatiment(Carte carte,TypeBatiment typeBatiment) {
        super(carte);
        this.typeBatiment = typeBatiment;
    }
    
    @Override
        protected int coutMouvementVers(Case destination){ //Verify
        
        int res = 1;
        TypeCase c = destination.getType();
        
        if (c == TypeCase.Eau || (destination.getBatiment() != null && destination.getBatiment() != this.typeBatiment)){
            res = this.getInfini();
        }else if((!destination.estVide() && destination.getBatiment() == null)){
            res = (destination.getRessource().nombreCoupsPioches())+1;            
        }
        return res;
    }
    
}
