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
 * Bouton permettant de brouiler le texte.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class BoutonBrouiller extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le contrôleur.
	 */
	private ControleurAbstrait controleur;
	
	/**
	 * Bouton "brouiller".
	 */
	private JButton brouiller;
	
	/**
	 * L'indice de l'onglet.
	 */
	private int indice;
	
	/**
	 * Le champ de texte.
	 */
	private ChampTexte texte;
	
	/**
	 * Constructeur.
	 * 
	 * @param controleur
	 * @param indice
	 */
	public BoutonBrouiller(ControleurAbstrait controleur, ChampTexte texte, int indice){
		this.controleur = controleur;
		this.texte = texte;
		this.indice = indice;
		this.setMaximumSize(new Dimension(650,60));
		
		//Bouton brouiller : taille, écouteur, infobulle
		this.brouiller = new JButton("Brouiller");
		this.brouiller.setPreferredSize(new Dimension(150,40));	
		this.brouiller.addActionListener(new ClicListener()); 
		this.brouiller.setToolTipText("Brouille le texte");
		
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(457,40));
		
		this.add(this.brouiller);
		this.add(p1);


	}
	
	/**
	 * Ecouteur de clic de bouton brouiller
	 * 
	 *@author BEN YAHIA HEIDY
	 *@author SAINTPIERRE CHARLOTTE
	 *
	 */
	public class ClicListener implements ActionListener{

		/**
		 * En cas de clic, le texte sera brouillé.
		 */
		public void actionPerformed(ActionEvent a) {
			controleur.setTexte(texte.getTexte().getText(), indice);
			controleur.activerBrouillage(indice);			
		}
		
	}
}
