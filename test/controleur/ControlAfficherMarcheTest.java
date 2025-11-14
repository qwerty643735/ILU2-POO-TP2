package controleur;

import static org.junit.jupiter.api.Assertions.*;

import personnages.Gaulois;
import villagegaulois.Village;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ControlAfficherMarcheTest {

    private Village village;
    private ControlAfficherMarche control;

    @BeforeEach
    void setUp() {
        village = new Village("Village Test", 10, 3);
        control = new ControlAfficherMarche(village);
    }

    @Test
    void testDonnerEtatMarche_vide() {
        String[] etat = control.donnerEtatMarche();
        assertEquals(0, etat.length);
    }

    @Test
    void testDonnerEtatMarche_unEtal() {
        Gaulois vendeur = new Gaulois("Bonemine", 5);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "fleur", 7);

        String[] etat = control.donnerEtatMarche();
        assertEquals(1, etat.length);
        assertTrue(etat[0].contains("Bonemine"));
        assertTrue(etat[0].contains("fleur"));
        assertTrue(etat[0].contains("7"));
    }
}
