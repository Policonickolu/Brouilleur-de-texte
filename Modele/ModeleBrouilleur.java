package Modele;

/**
 * Brouilleur de texte
 * Mélange les lettres des mots sauf les premières et dernières lettres.
 * 
 * Modèle concret.
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
	 * Brouille le texte à l'indice donné du tableau.
	 * 
	 * @param indice l'indice du tableau du texte à brouiller.
	 */
	public void brouillage(int indice){
		this.textes[indice].brouillage();
		notifyObservateur(this.textes);
	}

	/**
	 * Récupère les textes.
	 * 
	 * @return le tableau de textes.
	 */
	public Texte[] getTexte(){
		return this.textes;
	}
	
	/**
	 * Remplace le texte à l'indice donné du tableau. 
	 * 
	 * @param s le nouveau texte.
	 * @param indice l'indice du tableau du texte à remplacer.
	 */
	public void setTexte(String s, int indice){
		this.textes[indice].setTexte(s);
		notifyObservateur(this.textes);
	}
	
}
