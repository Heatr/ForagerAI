/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.actions;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;

/**
 *
 * @author dm645996
 */
public class FabriqueAction {
  
    public static Action creerDemande(TypeDemande demande){
        Action a = null;
        switch(demande){
            case CARTE:
                a = new ActionDemande("MAP");
                break;
            case JOUEUR:
                a = new ActionDemande("PLAYER");
                break;
            case ATTENDRE:
                a = new ActionDemande("WAIT");
                break;
        }
        return a;
    }
    
    public static Action creerMouvement(TypeMouvement mouvement){
        Action a = null;
        switch(mouvement){
            case TOP:
                a = new ActionMouvement(TypeMouvement.TOP);
                break;
            case BOTTOM:
                a = new ActionMouvement(TypeMouvement.BOTTOM);
                break;
            case LEFT:
                a = new ActionMouvement(TypeMouvement.LEFT);
                break;
            case RIGHT:
                a = new ActionMouvement(TypeMouvement.RIGHT);
                break;
        }
        return a;
    }
        public static Action creerCollecte(TypeMouvement mouvement){
        Action a = null;
        switch(mouvement){
            case TOP:
                a = new ActionCollecte(TypeMouvement.TOP);
                break;
            case BOTTOM:
                a = new ActionCollecte(TypeMouvement.BOTTOM);
                break;
            case LEFT:
                a = new ActionCollecte(TypeMouvement.LEFT);
                break;
            case RIGHT:
                a = new ActionCollecte(TypeMouvement.RIGHT);
                break;
        }
        return a;
    }
      public static Action creerConstruire(TypeMouvement mouvement,TypeBatiment batiment){
        Action a = null;
        TypeMouvement temp = null;
        switch(mouvement){
            case TOP:
                temp = TypeMouvement.TOP;
                break;
            case BOTTOM:
                temp = TypeMouvement.BOTTOM;
                break;
            case LEFT:
                temp = TypeMouvement.LEFT;
                break;
            case RIGHT:
                temp = TypeMouvement.RIGHT;
                break;
        }
        switch(batiment){
            case FURNACE:
                a = new ActionConstruire(temp,TypeBatiment.FURNACE);
                break;
        }
        return a;
    }
    public static Action creerCraft(TypeMouvement mouvement,TypeMateriau materiau){
     Action a = null;
        TypeMouvement temp = null;
      switch(mouvement){
          case TOP:
                temp = TypeMouvement.TOP;
                break;
            case BOTTOM:
                temp = TypeMouvement.BOTTOM;
                break;
            case LEFT:
                temp = TypeMouvement.LEFT;
                break;
            case RIGHT:
                temp = TypeMouvement.RIGHT;
                break;
      }
      switch(materiau){
          case COAL:
            a = new ActionCraft(temp,TypeMateriau.COAL);
            break;
          case IRONINGOT:
              a = new ActionCraft(temp,TypeMateriau.IRONINGOT);
              break;
          case GOLDINGOT:
              a = new ActionCraft(temp,TypeMateriau.GOLDINGOT);
              break;
          case COIN:
              a = new ActionCraft(temp,TypeMateriau.COIN);
              break;
      }
      return a;
    }
}
