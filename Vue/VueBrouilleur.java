package Vue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import Controleur.ControleurAbstrait;
import Modele.Texte;
import Observateur.Observateur;

/**
 * Interface Graphique.
 * 
 * Fenêtre Principale.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class VueBrouilleur extends JFrame implements Observateur{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Contrôleur.
	 */
	private ControleurAbstrait controleur;
	
	/**
	 * Conteneur d'onglets.
	 */
	private JTabbedPane container = new JTabbedPane(JTabbedPane.TOP,JTabbedPane.SCROLL_TAB_LAYOUT);	
	
	/**
	 * onglets.
	 */
	private Onglet[] panneaux; 
	
		
	/**
	 * Constructeur.
	 * 
	 * @param controleur
	 */
	public VueBrouilleur(ControleurAbstrait controleur){		
		
		// Change l'apparence en fonction du système d'exploitation utilisé. 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
		} catch (Exception e) {}
		
		// taille de la fenêtre
		this.setSize(650, 650);
        // titre de la fenêtre
		this.setTitle("Brouilleur de texte");
        // fermeture du programme à la fermeture de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// affichage au centre de l'écran
        this.setLocationRelativeTo(null);
        // non redimensionnable.
        this.setResizable(false);       
        this.controleur = controleur;
        
        // création des onglets
        this.panneaux = new Onglet[10];
		for(int i=0;i<10;i++){
			this.panneaux[i] = new Onglet(this.controleur, i);
		}
		// ajout des onglets à la fenêtre principale
		for(int i=0;i<10;i++){
			this.container.addTab("Texte " + (i+1), this.panneaux[i]);
		}
        this.setContentPane(container);
		
        // affichage de la fenêtre
        this.setVisible(true);
	}
	
	


	/**
	 * Récupère les mises à jour du modèle.
	 */
	public void miseAJour(Texte[] t) {
		for(int i=0;i<10;i++){
			this.panneaux[i].setTexte(t[i].getTexte());
		}
	}

}
