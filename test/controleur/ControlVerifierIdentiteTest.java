package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

    private Village village;
    private ControlVerifierIdentite control;

    @BeforeEach
    void setUp() {
        village = new Village("TestVillage", 10, 3);
        new Chef("Abraracourcix", 10, village);
        village.ajouterHabitant(new Gaulois("Obelix", 12));
        

        control = new ControlVerifierIdentite(village);
    }

    @Test
    void testVerifierIdentite_true() {
        assertTrue(control.verifierIdentite("Obelix"));
    }

    @Test
    void testVerifierIdentite_false() {
        assertFalse(control.verifierIdentite("Inconnu"));
    }
}