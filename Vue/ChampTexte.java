package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import Controleur.ControleurAbstrait;

/**
 * Interface Graphique.
 * 
 * Champ de saisie et d'affichage de texte.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class ChampTexte extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le contrôleur.
	 */
	private ControleurAbstrait controleur;
	
	/**
	 * L'indice de l'onglet.
	 */
	private int indice;
	
	/**
	 * Le champ de texte.
	 */
	private JTextArea texte;
	
	/**
	 * Le constructeur.
	 * 
	 * @param controleur
	 * @param indice
	 */
	public ChampTexte (ControleurAbstrait controleur, int indice){
		this.controleur = controleur;
		this.indice = indice;
		this.texte = new JTextArea();
		
		// ajout d'écouteurs de sélection du JTextArea.
		this.texte.addFocusListener(new ClicListener());

		
		
		// panneau muni de barres de défilement.
		JScrollPane sp = new JScrollPane(this.texte,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(610,370));
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		this.add(sp);
		
	}
	
	/**
	 * Remplace le texte.
	 * 
	 * @param s
	 */
	public void setTexte(String s){
		this.texte.setText(s);
		
		//raffraîchit l'affichage du champ de texte.
		this.texte.revalidate();
	}
	

	
	/**
	 * Récupère le texte.
	 * 
	 * @return le texte.
	 */
	public JTextArea getTexte(){
		return this.texte;
	}	
	
	/**
	 * Ecouteur de sélection (Focus) du champ de texte.
	 * Le texte est envoyé au modèle.
	 * 
	 * @author BEN YAHIA HEIDY
	 * @author SAINTPIERRE CHARLOTTE
	 */
	public class ClicListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent f) {
			controleur.setTexte(texte.getText(),indice);			
		}

		@Override
		public void focusLost(FocusEvent f) {
			controleur.setTexte(texte.getText(),indice);
		}
	
	}
	
}