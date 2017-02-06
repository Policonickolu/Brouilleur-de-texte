package Controleur;

import Modele.ModeleAbstrait;

/**
 * Contrôleur abstrait.
 * Interprète les actions utilisateurs pour agir sur le modèle. 
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class ControleurBrouilleur extends ControleurAbstrait{
	
	/**
	 * Constructeur du contrôleur.
	 * 
	 * @param modele le modèle.
	 */
	public ControleurBrouilleur(ModeleAbstrait modele) {		
		super(modele);		
	}
	
	/**
	 * Méthode de contrôle.
	 * Agit en fonction des attributs.
	 * Si "brouiller" est vrai, le texte sera brouillé.
	 */
	public void control() {
		
		this.modele.setTexte(this.texte[this.indice],this.indice);
		if(this.brouiller){
			this.modele.brouillage(this.indice);
			this.brouiller = false;
		}
		
		
	}

}
