package Main;
import Controleur.ControleurAbstrait;
import Controleur.ControleurBrouilleur;
import Modele.ModeleAbstrait;
import Modele.ModeleBrouilleur;
import Vue.VueBrouilleur;

/**
 * Classe Main.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class Main {
	
	/**
	 * Méthode main.
	 * Mise en place du modèle, du controleur et de la vue.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Modèle.
		ModeleAbstrait modele = new ModeleBrouilleur();

		// Controleur prenant en paramètre le modèle.
		ControleurAbstrait controleur = new ControleurBrouilleur(modele);

		// Interface graphique prenant en paramètre le controleur.
		VueBrouilleur vue = new VueBrouilleur(controleur);
		
		// La vue sera avertie des modifications du modèle.
		modele.addObservateur(vue);
		

		
	}
	
}
