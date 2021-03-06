/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeDemande;
import forageria.modules.ModuleDecision;

/**
 *
 * @author natha
 */
public class EtatInitialisation extends Etat{

    public EtatInitialisation(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        Etat e = new EtatReflexion(this.getModule());
        return e;
    }

    @Override
    public void action() {
        Action a = FabriqueAction.creerDemande(TypeDemande.JOUEUR);
        this.getModule().ajouterAction(a);
    }
    
}
