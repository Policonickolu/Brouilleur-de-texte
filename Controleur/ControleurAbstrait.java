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
public abstract class ControleurAbstrait {
	
	/**
	 * Mod�le
	 */
	protected ModeleAbstrait modele;
	
	/**
	 * indice de l'onglet utilis� actuellement.
	 */
	protected int indice;
	
	/**
	 * Les 10 textes entr�s dans l'interface graphique.
	 */
	protected String[] texte = new String[10];
	
	/**
	 * attribut d�terminant s'il faut brouiller le texte.
	 */
	protected boolean brouiller;
	
	/**
	 * Constructeur du contr�leur.
	 * 
	 * @param modele le mod�le.
	 */
	public ControleurAbstrait(ModeleAbstrait modele){
		this.modele = modele;
		this.indice = 0;
		for(int i=0;i<10;i++)this.texte[i] = "";
		this.brouiller = false;
	}
	
	/**
	 * M�thode du bouton "brouiller".
	 * 
	 * @param indice
	 */
	public void activerBrouillage(int indice){
		this.indice = indice;
		this.brouiller = true;
		control();
	}
	
	/**
	 * M�thode de la saisie de texte sur l'interface graphique.
	 * 
	 * @param s
	 * @param indice
	 */
	public void setTexte(String s,int indice){
		this.indice = indice;
		this.texte[indice] = s;
		control();
	}
	
	/**
	 * M�thode du bouton "effacer".
	 * Efface le champ de texte.
	 * 
	 * @param indice
	 */
	public void effacer(int indice){
		this.indice = indice;
		this.texte[indice] = "";
		control();
	}

	/**
	 * M�thode de contr�le.
	 * Agit en fonction des attributs.
	 */
	public abstract void control();
	
}
