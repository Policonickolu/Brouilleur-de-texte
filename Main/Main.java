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
	 * M�thode main.
	 * Mise en place du mod�le, du controleur et de la vue.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Mod�le.
		ModeleAbstrait modele = new ModeleBrouilleur();

		// Controleur prenant en param�tre le mod�le.
		ControleurAbstrait controleur = new ControleurBrouilleur(modele);

		// Interface graphique prenant en param�tre le controleur.
		VueBrouilleur vue = new VueBrouilleur(controleur);
		
		// La vue sera avertie des modifications du mod�le.
		modele.addObservateur(vue);
		

		
	}
	
}
