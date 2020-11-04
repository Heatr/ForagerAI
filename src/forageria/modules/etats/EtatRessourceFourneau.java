/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.TypeRessource;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class EtatRessourceFourneau extends Etat{

    public EtatRessourceFourneau(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        Etat t = null;
        if(this.getMemoire().getQuantiteMateriel(TypeMateriau.STONE) < 10){
            ArrayList<TypeRessource> typesRessource = new ArrayList<>();
            typesRessource.add(TypeRessource.ROCHER);
            t = new EtatRechercheRessource(this.getModule(), typesRessource);
        }else{
            t = new EtatSiteFourneau(this.getModule());
        }
        return t;
    }

    @Override
    public void action() {
        
    }
    
}
