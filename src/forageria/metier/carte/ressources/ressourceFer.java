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
public class ressourceFer extends ressources{

    public ressourceFer(Case position) {
        super(position);
    }

    @Override
    public TypeRessource getType() {
        return TypeRessource.FER;
    }

    @Override
    public int nombreCoupsPioches() {
        return 3;
    }

    @Override
    public ArrayList<TypeMateriau> getLoot() {
       ArrayList<TypeMateriau> loot = new ArrayList<>();
        loot.add(TypeMateriau.IRON);
        loot.add(TypeMateriau.IRON);
        return loot;
    }
    
}
