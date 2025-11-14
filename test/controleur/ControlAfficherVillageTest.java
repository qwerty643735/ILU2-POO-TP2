package controleur;

import static org.junit.jupiter.api.Assertions.*;

import personnages.Gaulois;
import personnages.Chef;
import personnages.Druide;
import villagegaulois.Village;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ControlAfficherVillageTest {

    private Village village;
    private ControlAfficherVillage control;

    @BeforeEach
    void setUp() {
        village = new Village("Village des Irréductibles", 10, 5);
        new Chef("Abraracourcix", 10, village);
        control = new ControlAfficherVillage(village);
    }

    @Test
    void testDonnerNomsVillageois() {
        village.ajouterHabitant(new Gaulois("Asterix", 6));
        village.ajouterHabitant(new Druide("Panoramix", 8, 1, 5));


    } 

    @Test
    void testDonnerNomVillage() {
        assertEquals("Village des Irréductibles", control.donnerNomVillage());
    }

    @Test
    void testDonnerNbEtals() {
        assertEquals(5, control.donnerNbEtals());
    }
}
