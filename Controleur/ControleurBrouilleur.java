package Controleur;

import Modele.ModeleAbstrait;

/**
 * Contr�leur abstrait.
 * Interpr�te les actions utilisateurs pour agir sur le mod�le. 
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class ControleurBrouilleur extends ControleurAbstrait{
	
	/**
	 * Constructeur du contr�leur.
	 * 
	 * @param modele le mod�le.
	 */
	public ControleurBrouilleur(ModeleAbstrait modele) {		
		super(modele);		
	}
	
	/**
	 * M�thode de contr�le.
	 * Agit en fonction des attributs.
	 * Si "brouiller" est vrai, le texte sera brouill�.
	 */
	public void control() {
		
		this.modele.setTexte(this.texte[this.indice],this.indice);
		if(this.brouiller){
			this.modele.brouillage(this.indice);
			this.brouiller = false;
		}
		
		
	}

}
