package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface Graphique.
 * 
 * Bouton permettant d'ouvrir un fichier texte.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 * Tutoriel flux entrée/sortie : valhalla.fr
 */
public class OuvrirFichier extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le bouton "Ouvrir". 
	 */
	private JButton ouvrir;
	
	/**
	 * TextField affichant le chemin du fichier ouvert.
	 */
	private JTextField lien;
	
	/**
	 * Le champ de texte.
	 */
	private ChampTexte texte;
	
	/**
	 * Le constructeur.
	 * 
	 * @param texte
	 */
	public OuvrirFichier(ChampTexte texte){
		this.texte = texte;
		this.setMaximumSize(new Dimension(650,40));
		
		//Bouton ouvrir : taille, écouteur, infobulle
		this.ouvrir = new JButton("Ouvrir");
		this.ouvrir.setPreferredSize(new Dimension(100,25));
		this.ouvrir.addActionListener(new ClicListener());  
		this.ouvrir.setToolTipText("Ouvre un fichier");
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(3,25));
		
		this.lien = new JTextField("");
		this.lien.setPreferredSize(new Dimension(500,25));
		this.lien.setFocusable(false);
		this.lien.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		// Affichage d'informations depuis le curseur de souris.  
		this.lien.setToolTipText("Chemin du fichier");
		
		this.add(this.ouvrir);
		this.add(p1);
		this.add(this.lien);
	}
	
	/**
	 * Ecouteur de click de bouton.
	 * En cas de click sur le bouton "Ouvrir", Un JFileChooser permet d'ouvrir
	 * un fichier dans le JTextArea.
	 * 
	 * @author BEN YAHIA HEIDY
	 * @author SAINTPIERRE CHARLOTTE
	 *
	 */
	public class ClicListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			// choix du fichier.
			String fichier = "";
			JFileChooser fc = new JFileChooser();
	        fc.setApproveButtonText("Ouvrir");
	        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
	        	fichier = fc.getSelectedFile().getAbsolutePath();
	        	
	        }	
			try
			{ 
				// Lecture du fichier et affichage.
				FileInputStream fis = new FileInputStream(fichier);
				int n = fis.available();
				while(true){ 
					byte[] b = new byte[n];
					int result = fis.read(b);
					if (result == -1) break;
					String s = new String(b);
					lien.setText(fichier); 
					texte.setTexte(s);
			   }
			} catch (Exception err) {}
			
		}
		
	}

}
