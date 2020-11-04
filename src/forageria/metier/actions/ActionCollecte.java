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
public class ActionCollecte extends Action{

    private TypeMouvement typemouvement;

    ActionCollecte(TypeMouvement typeMouvement) {
        this.typemouvement = typeMouvement;
    }
    @Override
    public String getMessage() {
      return "COLLECT|"+typemouvement;  
    }

    @Override
    public TypeAction getType() {
       return TypeAction.COLLECTE;
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
