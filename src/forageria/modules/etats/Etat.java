/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.modules.ModuleDecision;
import forageria.modules.ModuleMemoire;

/**
 *
 * @author dm645996
 */
public abstract class Etat {
    private ModuleDecision module;
    private ModuleMemoire memoire;

    public Etat(ModuleDecision module) {
        this.module = module;
        this.memoire = this.module.getIA().getModuleMemoire();
    }

    public ModuleDecision getModule() {
        return module;
    }

    public ModuleMemoire getMemoire() {
        return memoire;
    }
    
    public abstract Etat transition();

    public abstract void action(); 
    
}
