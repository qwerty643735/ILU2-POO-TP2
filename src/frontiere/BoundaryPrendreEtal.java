package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Désolé " + nomVendeur + ", il faut être un habitant de notre village pour commercer ici.");
			return;
		} else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			
		}
		if(!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolée " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.\n");
			return;	
		}
		System.out.println("C'est parfait, il me reste un étal pour vous.");
	    System.out.println("Il me faudrait quelques renseignements :");
	 	
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
        int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");

        int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
        if (numeroEtal != -1) {
            installerVendeur(nomVendeur); 
            } else {
            System.out.println("Désolé, il y a eu un problème lors de l'attribution de l'étal.");
        }
    

	}

	private void installerVendeur(String nomVendeur) {
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, "", 0);          
        if (numeroEtal != -1) {
            System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n° " + numeroEtal);
        }
	}
}
