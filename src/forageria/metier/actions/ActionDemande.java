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
public class ActionDemande extends Action{
    
    private String message;

    public ActionDemande(String message) {
        this.message = message;
    }
   
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public TypeAction getType() {
       return TypeAction.DEMANDE;
    }

    @Override
    public TypeMouvement getDirection() {
        return null;
    }

    @Override
    public TypeMateriau getMateriau() {
        return null;
    }
    
}
