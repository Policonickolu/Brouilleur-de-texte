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
public abstract class ControleurAbstrait {
	
	/**
	 * Modèle
	 */
	protected ModeleAbstrait modele;
	
	/**
	 * indice de l'onglet utilisé actuellement.
	 */
	protected int indice;
	
	/**
	 * Les 10 textes entrés dans l'interface graphique.
	 */
	protected String[] texte = new String[10];
	
	/**
	 * attribut déterminant s'il faut brouiller le texte.
	 */
	protected boolean brouiller;
	
	/**
	 * Constructeur du contrôleur.
	 * 
	 * @param modele le modèle.
	 */
	public ControleurAbstrait(ModeleAbstrait modele){
		this.modele = modele;
		this.indice = 0;
		for(int i=0;i<10;i++)this.texte[i] = "";
		this.brouiller = false;
	}
	
	/**
	 * Méthode du bouton "brouiller".
	 * 
	 * @param indice
	 */
	public void activerBrouillage(int indice){
		this.indice = indice;
		this.brouiller = true;
		control();
	}
	
	/**
	 * Méthode de la saisie de texte sur l'interface graphique.
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
	 * Méthode du bouton "effacer".
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
	 * Méthode de contrôle.
	 * Agit en fonction des attributs.
	 */
	public abstract void control();
	
}
