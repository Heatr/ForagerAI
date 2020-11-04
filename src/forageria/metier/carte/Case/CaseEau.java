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
public class CaseEau extends Case{
    
    public CaseEau(Coordonnee coordonnee) {
        super(coordonnee);
    }

    @Override
    public TypeCase getType() {
        return TypeCase.Eau;
    }

    @Override
    public boolean estAccessible() {
        return false;
    }
    
}
