/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.ActionConstruire;
import forageria.metier.actions.ActionMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.modules.ModuleDecision;

/**
 *
 * @author natha
 */
public class EtatConstruireFourneau extends Etat{

    public EtatConstruireFourneau(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
        Etat e = new EtatReflexion(this.getModule());
        return e;
    }

    @Override
    public void action() {
       Action a = new ActionMouvement(TypeMouvement.RIGHT);
       Action a1 = new ActionMouvement(TypeMouvement.TOP);
       Action a2 = new ActionMouvement(TypeMouvement.LEFT);
       Action a3 = new ActionMouvement(TypeMouvement.BOTTOM);
       Action a4 = new ActionMouvement(TypeMouvement.LEFT);
       Action a5 = new ActionConstruire(TypeMouvement.RIGHT,TypeBatiment.FURNACE);
       
       this.getModule().ajouterAction(a);
       this.getModule().ajouterAction(a1);
       this.getModule().ajouterAction(a2);
       this.getModule().ajouterAction(a3);
       this.getModule().ajouterAction(a4);
       this.getModule().ajouterAction(a5);
       
    }
    
}
