/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 *
 * @author dm645996
 */
public class EtatInitial extends Etat{

    public EtatInitial(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
      Etat t = new EtatInitialisation(getModule());
      return t;
    }

    @Override
    public void action() {
       
    }
    
}
