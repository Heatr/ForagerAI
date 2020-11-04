/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author Alexandre
 */
public class EtatSeDeplacer extends Etat{

    private ArrayList<TypeMouvement> chemin;
    
    public EtatSeDeplacer(ModuleDecision module, ArrayList<TypeMouvement> chemin ) {
        super(module);
        this.chemin = chemin;
    }

    @Override
    public Etat transition() {
        Etat e = null;
         e = new EtatReflexion(this.getModule());
        return e;
    }

    @Override
    public void action() {
        TypeMouvement dernierMouvement = this.chemin.get(this.chemin.size()-1); // A verifier !!!! 
        this.chemin.remove(dernierMouvement);
        for(TypeMouvement mouvement:this.chemin){
            Action a = FabriqueAction.creerMouvement(mouvement);
            this.getModule().ajouterAction(a);
        }
//        int n = this.ressource.nombreCoupsPioche();
//        for(int i = 0;i<n;i++){
//            Action a = FabriqueAction.creerCollecte(dernierMouvement);
//            this.getModule().ajouterAction(a);
//    }
    }
    
}
