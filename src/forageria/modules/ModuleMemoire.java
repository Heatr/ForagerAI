package forageria.modules;

import forageria.IA;
import forageria.metier.Joueur;
import forageria.metier.TypeMouvement;
import forageria.metier.actions.Action;
import forageria.metier.actions.TypeAction;
import static forageria.metier.actions.TypeAction.COLLECTE;
import static forageria.metier.actions.TypeAction.MOUVEMENT;
import forageria.metier.carte.Carte;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Case.CaseHerbe;
import forageria.metier.carte.Coordonnee;
import forageria.metier.carte.TypeBatiment;
import forageria.metier.carte.ressources.TypeMateriau;
import forageria.metier.carte.ressources.ressources;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Module en charge de la mémorisation et de la restitution des informations obtenues
 * @author Matthieu
 */
public class ModuleMemoire extends Module  {

    private Carte carte;
    private Joueur joueur;
    private int dureeValiditeCarte;
    private HashMap<TypeMateriau,Integer> inventaire;
    private Coordonnee siteFourneau;
    private ArrayList<Coordonnee>fourneau;
    private int timerCraftFourneau;
    private ArrayList<TypeMateriau>listeCraftEnCoursFourneau;
    
    public ModuleMemoire(IA ia) {
        super(ia);
        this.dureeValiditeCarte = 0;
        this.inventaire = new HashMap<>();
        this.inventaire.put(TypeMateriau.IRON, 0);
        this.inventaire.put(TypeMateriau.WOOD, 0);
        this.inventaire.put(TypeMateriau.COAL, 0);
        this.inventaire.put(TypeMateriau.IRONINGOT, 0);
        this.inventaire.put(TypeMateriau.GOLDINGOT, 0);
        this.inventaire.put(TypeMateriau.COIN, 0);
        this.inventaire.put(TypeMateriau.STONE, 0);
        this.fourneau = new ArrayList<>();
        this.timerCraftFourneau = 0;
        this.listeCraftEnCoursFourneau = new ArrayList<>();
    }
    
    public void genererCarte(String messageRecu){
        this.carte = new Carte(messageRecu);
        this.carte.afficheConsole();
        this.dureeValiditeCarte = 2;
        
        for(Coordonnee c:fourneau){
            this.carte.getCase(c).setBatiment(TypeBatiment.FURNACE);
        }
    }
    
    public boolean hasCarte(){
        boolean test = false;
        if (this.dureeValiditeCarte > 0){
            test = true;
        }
        return test;
    }
    public boolean hasJoueur(){
        boolean r = false;
        if(joueur != null){
          r = true;   
        }
        return r;
    }
    public Joueur getJoueur(){
        return joueur;
    }
    public void genererJoueur(String messageRecu){   
           String coordonnee = messageRecu;
           String[] l = coordonnee.split("/");
           String ligne = l[0];
           String colonne = l[1];
           Coordonnee c = new Coordonnee(Integer.parseInt(ligne),Integer.parseInt(colonne));
           this.joueur = new Joueur(c); 
    }
    public Carte getCarte(){
        return carte;       
    }
    public Case getCaseJoueur(){
       Case c = this.carte.getCase(this.joueur.getCoordonnee());
       return c;
    }
    
   public void effectuerAction(Action action){
        
    if(action.getType() == MOUVEMENT) {
        joueur.deplacer(action.getDirection());
        this.dureeValiditeCarte--;
    }else if(action.getType() == COLLECTE) {
        Case caseDestination=this.carte.getCase(this.getCaseJoueur().getCoordonnee().getVoisin(action.getDirection()));
        if(!caseDestination.estVide()) {
            this.recolter(caseDestination.getRessource()); // A Verifier
            caseDestination.setRessource(null);
        }
    }
    else if(action.getType() == TypeAction.CONSTRUCTION){
        Case caseCoinsBas = this.carte.getCase(this.getCaseJoueur().getCoordonnee().getVoisin(action.getDirection()));
        Case caseBasDroite = this.carte.getCase(caseCoinsBas.getCoordonnee().getVoisin(TypeMouvement.RIGHT));
        Case caseHautDroite = this.carte.getCase(caseCoinsBas.getCoordonnee().getVoisin(TypeMouvement.TOP));
        Case caseHautGauche = this.carte.getCase(caseCoinsBas.getCoordonnee().getVoisin(TypeMouvement.TOP));
        
        this.fourneau.add(caseCoinsBas.getCoordonnee());
        this.fourneau.add(caseBasDroite.getCoordonnee());
        this.fourneau.add(caseHautDroite.getCoordonnee());
        this.fourneau.add(caseHautGauche.getCoordonnee());
        
        this.inventaire.put(TypeMateriau.STONE, this.inventaire.get(TypeMateriau.STONE)-10);
    }
    else if(action.getType() == TypeAction.CRAFT){
        this.inventaire.put(TypeMateriau.WOOD, this.inventaire.get(TypeMateriau.WOOD)-2);
        this.ajouterCraft(TypeMateriau.COAL);
    }
    }
  private void recolter(ressources ressource){ // Verifier

        for(TypeMateriau materiau : ressource.getLoot()) {
            this.inventaire.put(materiau, inventaire.get(materiau)+1);
        }
    }
   public int getQuantiteMateriel(TypeMateriau type){
       int res = this.inventaire.get(type);
       return res;
   }

    public Coordonnee getSiteFourneau() {
        return siteFourneau;
    }

    public void setSiteFourneau(Coordonnee siteFourneau) {
        this.siteFourneau = siteFourneau;
    }

    public ArrayList<Coordonnee> getFourneau() {
        return fourneau;
    }
    private void ajouterCraft(TypeMateriau materiau){
        this.timerCraftFourneau = this.timerCraftFourneau+14;
        this.listeCraftEnCoursFourneau.add(materiau);
    }
       
}
