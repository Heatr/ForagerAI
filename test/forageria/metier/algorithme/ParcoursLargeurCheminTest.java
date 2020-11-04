/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forageria.metier.algorithme;

import forageria.metier.carte.Carte;
import forageria.metier.carte.Coordonnee;
import forageria.metier.TypeMouvement;
import static forageria.metier.TypeMouvement.BOTTOM;
import static forageria.metier.TypeMouvement.RIGHT;
import static forageria.metier.TypeMouvement.TOP;
import forageria.metier.algorithme.ParcoursLargeur;
import forageria.metier.carte.Case.Case;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Matthieu
 */
public class ParcoursLargeurCheminTest {
    
    /**
     * Test of calculerDistancesDepuis method, of class ParcoursLargeur.
     */
    @Test
    public void testGetChemin() {
        System.out.println("getChemin");
        Carte carte = new Carte(
                "HWWWH"
               +"HRRRH"
               +"HTTTH"
               +"HHHHH"
               +"HWWWH" 
        );
                
        Case depart = carte.getCase(new Coordonnee(0,0));
        ParcoursLargeur instance = new ParcoursLargeur(carte);
        instance.calculerDistancesDepuis(depart);
        
        ArrayList<TypeMouvement> result = instance.getChemin(carte.getCase(new Coordonnee(0,4)));
        TypeMouvement[] expResultArray = {BOTTOM,BOTTOM,BOTTOM,RIGHT,RIGHT,RIGHT,RIGHT,TOP,TOP,TOP};
        ArrayList<TypeMouvement> expResult = new ArrayList<>(Arrays.asList(expResultArray));
        
        assertEquals(expResult,result);
        
    }
    
}
