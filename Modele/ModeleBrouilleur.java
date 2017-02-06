package Modele;

/**
 * Brouilleur de texte
 * M�lange les lettres des mots sauf les premi�res et derni�res lettres.
 * 
 * Mod�le concret.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class ModeleBrouilleur extends ModeleAbstrait{
	
	/**
	 * Constructeur du brouilleur.
	 */
	public ModeleBrouilleur() {
		
		super();
		
	}
	
	/**
	 * Brouille le texte � l'indice donn� du tableau.
	 * 
	 * @param indice l'indice du tableau du texte � brouiller.
	 */
	public void brouillage(int indice){
		this.textes[indice].brouillage();
		notifyObservateur(this.textes);
	}

	/**
	 * R�cup�re les textes.
	 * 
	 * @return le tableau de textes.
	 */
	public Texte[] getTexte(){
		return this.textes;
	}
	
	/**
	 * Remplace le texte � l'indice donn� du tableau. 
	 * 
	 * @param s le nouveau texte.
	 * @param indice l'indice du tableau du texte � remplacer.
	 */
	public void setTexte(String s, int indice){
		this.textes[indice].setTexte(s);
		notifyObservateur(this.textes);
	}
	
}
