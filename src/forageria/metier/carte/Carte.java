/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.carte;

import forageria.metier.TypeMouvement;
import forageria.metier.carte.Case.Case;
import forageria.metier.carte.Case.FabriqueCase;
import forageria.metier.carte.Case.TypeCase;
import static forageria.metier.carte.Case.TypeCase.Herbe;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author dm645996
 */
public class Carte {
   private HashMap<Coordonnee,Case> cases = new HashMap<Coordonnee,Case>();
   private int taille;

    public Carte(String messageRecu){
        this.cases = new HashMap<>(); 
        this.taille = (int) Math.sqrt(messageRecu.length());
        for(int i=0;i<this.taille;i++) { 
            for(int j=0;j<this.taille;j++) { 
                this.ajouterCase(new Coordonnee(i,j), messageRecu.charAt(j+this.taille*i));
            } 
        }
        for(int i=0;i<this.taille;i++) { 
            for(int j=0;j<this.taille;j++) {
                Coordonnee cooCase = new Coordonnee(i,j); 
                for(TypeMouvement mouvement : TypeMouvement.values()) { 
                   Coordonnee cooVoisin = cooCase.getVoisin(mouvement); 
                   if(this.cases.get(cooVoisin)!= null) { 
                       this.cases.get(cooCase).ajouterVoisins(this.cases.get(cooVoisin));
                   }
                }
            }
        }
     /*Coordonnee vGauche;  
     Coordonnee vDroite; 
     Coordonnee vHaut; 
     Coordonnee vbas; 
     
     Coordonnee Coo1 = new Coordonnee(0,0);
     vbas =  Coo1.getVoisin(TypeMouvement.BOTTOM);
     vHaut = Coo1.getVoisin(TypeMouvement.TOP);
     vDroite = Coo1.getVoisin(TypeMouvement.RIGHT);
     vGauche = Coo1.getVoisin(TypeMouvement.LEFT);
     
        System.out.println("(0,0) : "+"haut"+vHaut.toString()+"bas"+vbas.toString()+"gauche"+vDroite.toString()+"droite"+vGauche.toString());
     Coordonnee Coo2 = new Coordonnee(3,3);
     vbas =  Coo2.getVoisin(TypeMouvement.BOTTOM);
     vHaut = Coo2.getVoisin(TypeMouvement.TOP);
     vDroite = Coo2.getVoisin(TypeMouvement.RIGHT);
     vGauche = Coo2.getVoisin(TypeMouvement.LEFT);
     
             System.out.println("(3,3) : "+"haut"+vHaut.toString()+"bas"+vbas.toString()+"gauche"+vDroite.toString()+"droite"+vGauche.toString());
     Coordonnee Coo3 = new Coordonnee(6,4);
     vbas =  Coo3.getVoisin(TypeMouvement.BOTTOM);
     vHaut = Coo3.getVoisin(TypeMouvement.TOP);
     vDroite = Coo3.getVoisin(TypeMouvement.RIGHT);
     vGauche = Coo3.getVoisin(TypeMouvement.LEFT);
     
             System.out.println("(6,4) : "+"haut"+vHaut.toString()+"bas"+vbas.toString()+"gauche"+vDroite.toString()+"droite"+vGauche.toString());
    
*/}

    public int getTaille(){
        return this.taille;
    }
    private void ajouterCase(Coordonnee coordonnee,Character lettre){
        cases.put(coordonnee,FabriqueCase.creer(coordonnee, lettre));
    }
   public void afficheConsole() {
       for(int i=0;i<this.taille;i++) { 
           for(int j=0;j<this.taille;j++) { 
               String affichage = "W"; 
               Case caseEnCours = this.cases.get(new Coordonnee(i,j)); 
               if(caseEnCours.getType() == Herbe) { 
                  if(caseEnCours.getRessource() == null) { 
                      affichage = "H";
                  }
                  else{
                      switch(caseEnCours.getRessource().getType()) { 
                          case ARBRE : affichage = "T"; 
                          break;
                          case ROCHER :affichage = "R"; 
                          break;
                          case FER : affichage = "I"; 
                          break;
                          case OR : affichage = "G"; 
                          break;
                      }
                  }
               }
               System.out.print(affichage);
           }
           System.out.println("");

       }
   }
   public Case getCase(Coordonnee coordonnee){
       return this.cases.get(coordonnee);
   }
   public Collection<Case>getCases(){
       return cases.values();
   }
   public boolean estZoneValide(Case coinBasGauche){
       boolean res = true;
       for(int i = coinBasGauche.getCoordonnee().getLigne()-2;i <= coinBasGauche.getCoordonnee().getLigne()+1;i++){
           for(int j = coinBasGauche.getCoordonnee().getColonne()-1;j <= coinBasGauche.getCoordonnee().getColonne()+2;j++){
               Coordonnee c = new Coordonnee(i,j);
               if(getCase(c)== null || TypeCase.Eau==getCase(c).getType()){
                   res = false;
               }
           }
       }
       return res;
   }
}
