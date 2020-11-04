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
 * @author dm645996
 */
public class ActionMouvement extends Action{
    private TypeMouvement typemouvement;

    /**
     *
     * @return
     */
    @Override
    public String getMessage() {
        return "MOVE|"+typemouvement;      
    }

    public ActionMouvement(TypeMouvement TypeMouvement) {
        this.typemouvement = TypeMouvement;
    }

    @Override
    public TypeAction getType() {
       return TypeAction.MOUVEMENT; 
    }

    @Override
    public TypeMouvement getDirection() {
        return this.typemouvement;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }
    
}
