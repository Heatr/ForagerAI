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
public class ressourceRocher extends ressources{

    public ressourceRocher(Case position) {
        super(position);
    }

    @Override
    public TypeRessource getType() {
        return TypeRessource.ROCHER;
    }

    @Override
    public int nombreCoupsPioches() {
        return 2;
    }

    @Override
    public ArrayList<TypeMateriau> getLoot() {
        ArrayList<TypeMateriau> loot = new ArrayList<>();
        loot.add(TypeMateriau.STONE);
        return loot;
    }
    
}
