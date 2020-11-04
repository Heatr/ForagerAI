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
public class EtatSiteFourneau extends Etat{

    public EtatSiteFourneau(ModuleDecision module) {
        super(module);
    }

    @Override
    public Etat transition() {
       Etat e = null;
       if(this.getMemoire().getSiteFourneau()==null){
           e = new EtatTrouverSiteFourneau(this.getModule());
       }
       else{
          e = new EtatConstruireFourneau(this.getModule()); 
       }
       return e;
       
    }

    @Override
    public void action() {
        
    }
    
}
