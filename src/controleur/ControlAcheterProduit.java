package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	    return (etal != null) ? etal.acheterProduit(quantite) : -1;
	}
	
	public boolean verifierNom(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
	
	public String[] rechercherVendeursProduit(String produitAchat) {
	    Gaulois[] vendeurs = village.rechercherVendeursProduit(produitAchat);
	    if (vendeurs == null) return null;
	    
	    String[] nomVendeurs = new String[vendeurs.length];
	    for (int i = 0; i < vendeurs.length; i++) {
	        nomVendeurs[i] = vendeurs[i].getNom();
	    }
	    return nomVendeurs;
	}
}
