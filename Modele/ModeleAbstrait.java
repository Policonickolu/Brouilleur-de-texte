package Modele;

import java.util.ArrayList;

import Observateur.Observable;
import Observateur.Observateur;

/**
 * Brouilleur de texte
 * Mélange les lettres des mots sauf les premières et dernières lettres.
 * 
 * Modèle abstrait.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public abstract class ModeleAbstrait implements Observable{
	
	/**
	 * Tableau de Textes.
	 */
	protected Texte[] textes;
	
	/**
	 * Liste des observateurs tel que la vue.
	 */
	private ArrayList<Observateur> listeObservateur = new ArrayList<Observateur>();

	/**
	 * Constructeur du brouilleur.
	 * Le brouilleur peut contenir 10 Textes.
	 */
	public ModeleAbstrait(){
		this.textes = new Texte[10];
		for(int i=0;i<10;i++){
			this.textes[i] = new Texte();
		}
	}
	
	/**
	 * Brouille le texte à l'indice donné du tableau.
	 * 
	 * @param indice
	 */
	public abstract void brouillage(int indice);
	
	/**
	 * Récupère les textes.
	 * 
	 * @return le tableau de textes.
	 */
	public abstract Texte[] getTexte();
	
	/**
	 * Remplace le texte à l'indice donné du tableau. 
	 * 
	 * @param s le nouveau texte.
	 * @param indice l'indice du tableau du texte à remplacer.
	 */
	public abstract void setTexte(String s, int indice);
	
	/**
	 * Avertir les observateurs que le modèle a changé et qu'ils doivent se mettre à jour.
	 */
	public void notifyObservateur(Texte[] t) {
		for(Observateur o : listeObservateur)
			o.miseAJour(t);		
	}

	/**
	 * Ajouter un observateur de la liste.
	 */
	public void addObservateur(Observateur o) {
		this.listeObservateur.add(o);		
	}

	/**
	 * Retirer un observateur de la liste.
	 */
	public void removeObservateur() {
		listeObservateur = new ArrayList<Observateur>();		
	}

}
