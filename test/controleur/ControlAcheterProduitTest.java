package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {

    private Village village;
    private ControlVerifierIdentite controlVerifier;
    private ControlTrouverEtalVendeur controlTrouverEtal;
    private ControlAcheterProduit controlAcheter;

    @BeforeEach
    void setUp() {
        village = new Village("Village Test", 10, 5);
        new Chef("Abraracourcix", 10, village);
        controlVerifier = new ControlVerifierIdentite(village);
        controlTrouverEtal = new ControlTrouverEtalVendeur(village);
        controlAcheter = new ControlAcheterProduit(controlVerifier, controlTrouverEtal, village);
    }

    @Test
    void testAcheterProduit_etalExiste_quantiteValide() {
        Gaulois vendeur = new Gaulois("Bonemine", 5);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "fleur", 10);
        int restant = controlAcheter.acheterProduit("Bonemine", 4);
        assertEquals(6, restant);
    }

    @Test
    void testAcheterProduit_etalExiste_quantiteSuperieure() {
        Gaulois vendeur = new Gaulois("Bonemine", 5);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "fleur", 3);
        int restant = controlAcheter.acheterProduit("Bonemine", 5);
        assertEquals(-1, restant);
    }

    @Test
    void testAcheterProduit_etalInexistant() {
        int restant = controlAcheter.acheterProduit("Inconnu", 2);
        assertEquals(-1, restant);
    }

    @Test
    void testVerifierNom_existe() {
        village.ajouterHabitant(new Gaulois("Asterix", 6));
        assertTrue(controlAcheter.verifierNom("Asterix"));
    }

    @Test
    void testVerifierNom_inexistant() {
        assertFalse(controlAcheter.verifierNom("Obelix"));
    }

    @Test
    void testRechercherVendeursProduit_aucun() {
        String[] result = controlAcheter.rechercherVendeursProduit("sanglier");
        assertNull(result);
    }

    @Test
    void testRechercherVendeursProduit_un() {
        Gaulois vendeur = new Gaulois("Cétautomatix", 7);
        village.ajouterHabitant(vendeur);
        village.installerVendeur(vendeur, "poisson", 5);

        String[] result = controlAcheter.rechercherVendeursProduit("poisson");
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("Cétautomatix", result[0]);
    }

    @Test
    void testRechercherVendeursProduit_plusieurs() {
        Gaulois v1 = new Gaulois("Ordralfabétix", 4);
        Gaulois v2 = new Gaulois("Cétautomatix", 7);
        village.ajouterHabitant(v1);
        village.ajouterHabitant(v2);
        village.installerVendeur(v1, "poisson", 3);
        village.installerVendeur(v2, "poisson", 8);

        String[] result = controlAcheter.rechercherVendeursProduit("poisson");
        assertEquals(2, result.length);
        assertArrayEquals(new String[]{"Ordralfabétix", "Cétautomatix"}, result);
    }
}