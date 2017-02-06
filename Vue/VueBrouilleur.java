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
 * Fen�tre Principale.
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
	 * Contr�leur.
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
		
		// Change l'apparence en fonction du syst�me d'exploitation utilis�. 
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
		} catch (Exception e) {}
		
		// taille de la fen�tre
		this.setSize(650, 650);
        // titre de la fen�tre
		this.setTitle("Brouilleur de texte");
        // fermeture du programme � la fermeture de la fen�tre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// affichage au centre de l'�cran
        this.setLocationRelativeTo(null);
        // non redimensionnable.
        this.setResizable(false);       
        this.controleur = controleur;
        
        // cr�ation des onglets
        this.panneaux = new Onglet[10];
		for(int i=0;i<10;i++){
			this.panneaux[i] = new Onglet(this.controleur, i);
		}
		// ajout des onglets � la fen�tre principale
		for(int i=0;i<10;i++){
			this.container.addTab("Texte " + (i+1), this.panneaux[i]);
		}
        this.setContentPane(container);
		
        // affichage de la fen�tre
        this.setVisible(true);
	}
	
	


	/**
	 * R�cup�re les mises � jour du mod�le.
	 */
	public void miseAJour(Texte[] t) {
		for(int i=0;i<10;i++){
			this.panneaux[i].setTexte(t[i].getTexte());
		}
	}

}
