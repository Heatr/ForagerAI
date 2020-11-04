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
public class EtatInnocupe extends Etat{

    public EtatInnocupe(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
     Etat t = null;
        
        if(this.getMemoire().getFourneau().isEmpty()){ //getSiteFourneaux ?
            t = new EtatRessourceFourneau(this.getModule());
        }else{
            t = new EtatCrafterRessource(this.getModule(),TypeMateriau.COAL);
        }
        return t;
    }

    @Override
    public void action() {
       
    }
    
}
