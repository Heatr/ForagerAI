package forageria.modules;

import forageria.IA;
import forageria.metier.Joueur;
import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.FabriqueAction;
import forageria.metier.actions.TypeAction;
import static forageria.metier.actions.TypeDemande.CARTE;
import static forageria.metier.actions.TypeDemande.JOUEUR;
import forageria.metier.algorithme.AlgorithmeCalculDistance;
import forageria.metier.algorithme.Djikstra;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Coordonnee;
import forageria.modules.etats.Etat;
import forageria.modules.etats.EtatInitial;

import java.util.ArrayList;
import java.util.Random;

/**
 * Module en charge de la prise de décision
 * @author Matthieu
 */
public class ModuleDecision extends Module {
    
   private ArrayList<Action> listeDesActionsARealiser;
    
    private Etat etatCourant;
    
    private String messageReponse;

    public ModuleDecision(IA ia) {
        super(ia);
        this.listeDesActionsARealiser = new ArrayList<>();
        this.etatCourant = new EtatInitial(this);
    }

    /**
     * Méthode principale de prise de décision
     * @param messageRecu dernier message reçu du serveur
     * @return Le prochain message à envoyer
     */
    public String determinerNouvelleAction(String messageRecu) {
        this.messageReponse="";
        while(this.messageReponse.equals("")) {
        etatCourant=etatCourant.transition();
        etatCourant.action();
    }
        return messageReponse;
    }
    
    public void ajouterAction(Action action){
        
        this.listeDesActionsARealiser.add(action);
    }
    
    public void ajouterActionPrioritaire(Action action){
        
        this.listeDesActionsARealiser.add(0, action);
        
    }
    public boolean hasAction(){
        boolean res = true;
        if(this.listeDesActionsARealiser.isEmpty()){
            res = false;
        }
        return res;
    }
    
    public void realiserAction(){
        
        Action action=this.listeDesActionsARealiser.get(0);
        if(action.getType() == TypeAction.MOUVEMENT) {
            Coordonnee coordonneDestination=this.getIA().getModuleMemoire().getCaseJoueur().getCoordonnee().getVoisin(action.getDirection());
            Case caseDestination=this.getIA().getModuleMemoire().getCarte().getCase(coordonneDestination);
            if(!caseDestination.estVide()) {
                for(int i= 0;i<caseDestination.getRessource().nombreCoupsPioches();i++) {
                    this.listeDesActionsARealiser.add(0,FabriqueAction.creerCollecte(action.getDirection()));
                }
            }
        }
        this.messageReponse=this.listeDesActionsARealiser.get(0).getMessage();
        this.getIA().getModuleMemoire().effectuerAction(this.listeDesActionsARealiser.get(0));
        this.listeDesActionsARealiser.remove(0);
        
    }
}
