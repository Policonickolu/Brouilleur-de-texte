package Vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 * Interface Graphique.
 * 
 * Bouton permettant d'enregistrer le texte dans un fichier.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 * Tutoriel flux entrée/sortie : valhalla.fr
 */
public class BoutonEnregistrer extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le bouton "enregistrer". 
	 */
	private JButton enregistrer;
	
	/**
	 * Le champ de texte.
	 */
	private ChampTexte texte;
	
	/**
	 * Le constructeur.
	 * 
	 * @param texte
	 */
	public BoutonEnregistrer(ChampTexte texte){
		this.texte = texte;
		this.setMaximumSize(new Dimension(650,40));
		
		// bouton enregistrer : taille, écouteur, infobulle
		this.enregistrer = new JButton("Enregistrer");
		this.enregistrer.setPreferredSize(new Dimension(100,25));
		this.enregistrer.addActionListener(new ClicListener());
		this.enregistrer.setToolTipText("Enregistre le texte");
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(3,25));
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(500,25));
		
		this.add(this.enregistrer);
		this.add(p1);
		this.add(p2);

	}
	
	/**
	 * Ecouteur de click de bouton.
	 * En cas de click du bouton "Enregistrer", Un JFileChooser permet de créer 
	 * un fichier dans lequel sera enregistré le texte.
	 * 
	 * @author BEN YAHIA HEIDY
	 * @author SAINTPIERRE CHARLOTTE
	 *
	 */
	public class ClicListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			// choix du nom et de la destination du fichier.
			JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File(".")); 
			String app = new String("Enregistrer"); 
			if (fc.showDialog(fc,app) == JFileChooser.APPROVE_OPTION){ 
				String fichier= new String(fc.getSelectedFile().toString());
				if(fichier.endsWith(".txt")|| fichier.endsWith(".TXT")){}
				else {fichier = fichier+ ".txt";}
				try { 
				// création du fichier	
				FileWriter lu = new FileWriter(fichier);
				BufferedWriter out = new BufferedWriter(lu);
				out.write(texte.getTexte().getText()); 
				out.close(); 
				} catch (IOException er){}
			}			
		}
		
	}
	
}
