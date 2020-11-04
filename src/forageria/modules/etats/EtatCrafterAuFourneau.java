/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.modules.etats;

import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.algorithme.AlgorithmeCalculDistance;
import forageria.metier.algorithme.DijkstraBatiment;
import forageria.metier.algorithme.Djikstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;
import forageria.modules.ModuleDecision;
import java.util.ArrayList;

/**
 *
 * @author natha
 */
public class EtatCrafterAuFourneau extends Etat{
    private TypeMateriau materiau;

    public EtatCrafterAuFourneau(ModuleDecision module,TypeMateriau materiau) {
        super(module);
        this.materiau = materiau;
    }

    @Override
    public Etat transition() {
        Etat e = new EtatReflexion(this.getModule());
        return e;
    }

    @Override
    public void action() {
      //On récupère la carte et on lance Dijkstra
      Carte carte = this.getMemoire().getCarte();
      AlgorithmeCalculDistance dijkstra = new DijkstraBatiment(carte,TypeBatiment.FURNACE); 
      dijkstra.calculerDistancesDepuis(this.getMemoire().getCaseJoueur()); 
      //On recherche la case du fourneau la plus proche 
      int distanceMin = -1;
      Case fourneauLePlusProche = null;
      for(Coordonnee coo : this.getMemoire().getFourneau()) {
         Case c = carte.getCase(coo); 
         if (fourneauLePlusProche == null || dijkstra.getDistance(c) < distanceMin) { 
            distanceMin = dijkstra.getDistance(c); 
            fourneauLePlusProche = c;
         }
      }
      //On s'y rend (on enlève le dernier mouvement pour le replacer par CRAFT) 
      ArrayList<TypeMouvement> chemin = dijkstra.getChemin( fourneauLePlusProche); 
      TypeMouvement dernierMouvement = chemin.get(chemin.size()-1); 
      chemin.remove(chemin.size()-1);
      for(TypeMouvement mouvement : chemin) { 
         Action action = FabriqueAction.creerMouvement(mouvement); 
         this.getModule().ajouterAction(action);
      }
      Action action = FabriqueAction.creerCraft(dernierMouvement,materiau) ; 
      this.getModule().ajouterAction(action);   
    }
    
}
