/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte.Case;

import forageria.metier.carte.Coordonnee;

/**
 *
 * @author dm645996
 */
public class CaseHerbe extends Case{
    
    public CaseHerbe(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.Herbe;
    }

    @Override
    public boolean estAccessible() {
        boolean r = false;
        if(this.getRessource()== null){
            r = true;
        }
        return r;
    }
    
}
