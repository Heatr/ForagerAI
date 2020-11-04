/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.modules.ModuleDecision;

/**
 *
 * @author natha
 */
public class EtatReflexion extends Etat{

    public EtatReflexion(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
       Etat e = null;
       if(!this.getMemoire().hasCarte()){
          e = new EtatCarte(this.getModule()); 
       }
       else if(this.getModule().hasAction()){
           e = new EtatReflexion(this.getModule());
       }
       else{
           e = new EtatInnocupe(this.getModule());
       }
       return e;
    }

    @Override
    public void action() {
       if(this.getModule().hasAction()){
           this.getModule().realiserAction();
       } 
    }
    
}
