/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.ressources.TypeMateriau;

/**
 *
 * @author natha
 */
public class ActionCraft extends Action{
    private TypeMouvement mouvement;
    private TypeMateriau materiau;

    public ActionCraft(TypeMouvement mouvement, TypeMateriau materiau) {
        this.mouvement = mouvement;
        this.materiau = materiau;
    }

    @Override
    public String getMessage() {
      return "CRAFT|"+this.mouvement+"|"+this.materiau;
    }

    @Override
    public TypeAction getType() {
      return TypeAction.CRAFT;  
    }

    @Override
    public TypeMouvement getDirection() {
      return this.mouvement; 
    }

    @Override
    public TypeMateriau getMateriau() {
        return this.materiau;
    }
    
}
