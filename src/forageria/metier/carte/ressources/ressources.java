/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte.ressources;

import forageria.metier.carte.Case.Case;
import java.util.ArrayList;

/**
 *
 * @author dm645996
 */
public abstract class ressources {
  private Case position;

    public ressources(Case position) {
        this.position = position;
    }

    public Case getPosition() {
        return position;
    }
    public abstract TypeRessource getType();        
    public abstract int nombreCoupsPioches();
    public abstract ArrayList<TypeMateriau> getLoot(); 
}
