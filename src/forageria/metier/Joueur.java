/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier;

import forageria.metier.carte.Coordonnee;

/**
 *
 * @author dm645996
 */
public class Joueur {
  private Coordonnee coordonnee;

    public Joueur(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public void deplacer(TypeMouvement mouvement){
        this.coordonnee = this.getCoordonnee().getVoisin(mouvement);
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

  
}
