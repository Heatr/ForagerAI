/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.carte.ressources.ressources;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class EtatCollecter extends Etat{
    
    private ArrayList<TypeMouvement>chemin;
    private ressources ressource;

    public EtatCollecter(ModuleDecision module,ressources ressource, ArrayList<TypeMouvement>chemin) {
        super(module);
        this.ressource = ressource;
        this.chemin = chemin;
    }

    @Override
    public Etat transition() {
        Etat e = new EtatReflexion(this.getModule());
        return e;
    }

    @Override
    public void action() {
        TypeMouvement dernierMouvement = this.chemin.get(this.chemin.size()-1);
        this.chemin.remove(dernierMouvement);
        for(TypeMouvement mouvement:this.chemin){
            Action a = FabriqueAction.creerMouvement(mouvement);
            this.getModule().ajouterAction(a);
        }
        int n = this.ressource.nombreCoupsPioches();
        for(int i = 0;i<n;i++){
           Action a1 = FabriqueAction.creerCollecte(dernierMouvement);
           this.getModule().ajouterAction(a1);
        }
    }
    
}
