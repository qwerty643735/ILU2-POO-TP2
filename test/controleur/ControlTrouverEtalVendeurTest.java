package controleur;

import static org.junit.jupiter.api.Assertions.*;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ControlTrouverEtalVendeurTest {

    private Village village;
    private ControlTrouverEtalVendeur control;

    @BeforeEach
    void setUp() {
        village = new Village("Village Test", 10, 3);
        control = new ControlTrouverEtalVendeur(village);
    }

    @Test
    void testTrouverEtalVendeur_ok() {
        Gaulois vendeur = new Gaulois("Bonemine", 5);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "fleur", 4);
        Etal etal = control.trouverEtalVendeur("Bonemine");
        assertNotNull(etal);
        assertEquals(vendeur, etal.getVendeur());
    }

    @Test
    void testTrouverEtalVendeur_pasVendeur() {
        assertNull(control.trouverEtalVendeur("Inconnu"));
    }

    @Test
    void testTrouverEtalVendeur_habitantSansEtal() {
        village.ajouterHabitant(new Gaulois("Asterix", 6));
        assertNull(control.trouverEtalVendeur("Asterix"));
    }
}
