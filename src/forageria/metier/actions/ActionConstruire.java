/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

/**
 *
 * @author natha
 */
public class ActionConstruire extends Action{
    private TypeMouvement mouvement;
    private TypeBatiment batiment;

    public ActionConstruire(TypeMouvement mouvement, TypeBatiment batiment) {
        this.mouvement = mouvement;
        this.batiment = batiment;
    }
    
    @Override
    public String getMessage() {
        return "BUILD|"+this.mouvement+"|"+this.batiment;
    }

    @Override
    public TypeAction getType() {
        return TypeAction.CONSTRUCTION;
    }

    @Override
    public TypeMouvement getDirection() {
        return this.mouvement;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }
        
}
