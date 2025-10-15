package controleur;

import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		if(!controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return -1;
		}
		if(!resteEtals()) {
			return -2;
		}
		int indiceEtal = village.installerVendeur(village.trouverHabitant(nomVendeur), produit, nbProduit);
		return indiceEtal + 1;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return village.trouverHabitant(nomVendeur)!= null;
	}
}
