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
public abstract class Action {
    
    public abstract String getMessage();
    
    public abstract TypeAction getType();
    
    public abstract TypeMouvement getDirection();
    
    public abstract TypeMateriau getMateriau();
}
