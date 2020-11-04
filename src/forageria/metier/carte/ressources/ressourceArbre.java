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
public class ressourceArbre extends ressources{

    public ressourceArbre(Case position) {
        super(position);
    }

    @Override
    public TypeRessource getType() {
        return TypeRessource.ARBRE;
    }

    @Override
    public int nombreCoupsPioches() {
        return 1;
    }

    @Override
    public ArrayList<TypeMateriau> getLoot() {
        ArrayList<TypeMateriau> loot = new ArrayList<>();
        loot.add(TypeMateriau.WOOD);
        return loot;
    }
    
}
