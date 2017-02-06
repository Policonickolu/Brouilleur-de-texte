package Vue;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Controleur.ControleurAbstrait;

/**
 * Interface Graphique.
 * 
 * Onglet de la fen�tre principale.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class Onglet extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le contr�leur.
	 */
	private ControleurAbstrait controleur;
	
	/**
	 * JPanel g�rant l'ouverture d'un fichier texte.
	 */
	private OuvrirFichier ouvrir;
	
	/**
	 * JPanel g�rant l'extraction du contenu d'une page web. 
	 */
	private OuvrirURL url;
	
	/**
	 * JPanel g�rant l'enregistrement du texte dans un fichier.txt
	 */
	private BoutonEnregistrer boutonEnregistrer;
	
	/**
	 * JPanel g�rant le bouton d'effacement.
	 */
	private BoutonEffacer boutonEffacer;
	
	/**
	 * JPanel g�rant le bouton lan�ant le brouillage du texte.
	 */
	private BoutonBrouiller boutonBrouiller;
	
	/**
	 * JPanel g�rant la saisie et l'affichage de texte.
	 */
	private ChampTexte texte;
	
	/**
	 * Constructeur.
	 * 
	 * @param controleur
	 * @param indice
	 */
	public Onglet(ControleurAbstrait controleur, int indice) {
		
		this.controleur = controleur;
		
		// les objets se placeront du haut vers le bas comme pour une liste.
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));		
		
		// cr�ation des sous-composants.
		this.boutonEffacer = new BoutonEffacer(this.controleur, indice);
		this.texte = new ChampTexte(this.controleur, indice);
		this.boutonEnregistrer = new BoutonEnregistrer(this.texte);
		this.ouvrir = new OuvrirFichier(this.texte);
		this.url = new OuvrirURL(this.texte);
		this.boutonBrouiller = new BoutonBrouiller(this.controleur, this.texte, indice);
		
		// ajout des sous-composants au panneau.
		this.add(Box.createVerticalStrut(10));
		this.add(this.ouvrir);
		this.add(this.url);
		this.add(this.boutonEnregistrer);
		this.add(this.boutonEffacer);
		this.add(this.boutonBrouiller);
		this.add(this.texte);
		this.add(Box.createVerticalStrut(10));
		
		
	}
	
	/**
	 * Remplace le texte.
	 * 
	 * @param s
	 */
	public void setTexte(String s){
		this.texte.setTexte(s);
	}
	
	/**
	 * Recup�re le texte.
	 * 
	 * @return le texte.
	 */
	public String getTexte(){
		return this.texte.getTexte().getText();
	}

}
