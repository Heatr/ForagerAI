/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte.ressources;

import forageria.metier.carte.Case.Case;

/**
 *
 * @author dm645996
 */
public class FabriqueRessource {
    
    public static ressources creer(Case position,Character lettre){
    ressources r = null;
    switch(lettre)
    {
        case('T'):
            r = new ressourceArbre(position);
            break;
        case('R'):
            r = new ressourceRocher(position);
            break;
        case('I'):
            r = new ressourceFer(position);
            break;
        case('G'):
            r = new ressourceOr(position);
            break;
        case('H'):
            r = null;
            break;
    }
        return r;   
    }        
    }

