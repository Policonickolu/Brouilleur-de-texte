package Vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.ControleurAbstrait;

/**
 * Interface Graphique.
 * 
 * Bouton permettant d'efface le texte.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class BoutonEffacer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le contrôleur.
	 */
	private ControleurAbstrait controleur;
	
	/**
	 * Le bouton "effacer"
	 */
	private JButton effacer;
	
	/**
	 * L'indice de l'onglet.
	 */
	private int indice;
	
	/**
	 * Constructeur.
	 * 
	 * @param controleur
	 * @param indice
	 */
	public BoutonEffacer(ControleurAbstrait controleur, int indice){
		this.controleur = controleur;
		this.indice = indice;
		this.setMaximumSize(new Dimension(650,40));
		
		//Bouton effacer : taille, écouteur, infobulle
		this.effacer = new JButton("Effacer");
		this.effacer.setPreferredSize(new Dimension(100,25));
		this.effacer.addActionListener(new ClicListener());  
		this.effacer.setToolTipText("Efface le texte");
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(3,25));
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(500,25));
		
		this.add(this.effacer);
		this.add(p1);
		this.add(p2);

	}
	
	/**
	 * Ecouteur de click de bouton.
	 * En cas de click sur le bouton "effacer", le texte affiché est effacé.
	 * 
	 * @author BEN YAHIA HEIDY
	 * @author SAINTPIERRE CHARLOTTE
	 *
	 */
	public class ClicListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			controleur.effacer(indice);			
		}
		
	}
	
}
