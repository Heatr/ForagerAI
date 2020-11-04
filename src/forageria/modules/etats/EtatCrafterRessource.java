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
public class EtatCrafterRessource extends Etat{
    private TypeMateriau materiau;

    public EtatCrafterRessource(ModuleDecision module,TypeMateriau materiau) {
        super(module);
        this.materiau = materiau;
    }

    @Override
    public Etat transition() {
        Etat e = null;
        e = new EtatAttendre(this.getModule());
        if(materiau == this.materiau.COAL){
            if(this.getMemoire().getQuantiteMateriel(materiau.WOOD)<2){
                ArrayList<TypeRessource>temp = new ArrayList<>();
                temp.add(TypeRessource.ARBRE);
                e = new EtatRechercheRessource(this.getModule(),temp);
            }
            else{
                e = new EtatCrafterAuFourneau(this.getModule(),this.materiau);
            }
        }
        return e;
    }

    @Override
    public void action() {
        
    }
    
}
