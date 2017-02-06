package Vue;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface Graphique.
 * 
 * Bouton permettant d'extraire le texte d'une page web.
 * 
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class OuvrirURL extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le bouton "URL". 
	 */
	private JButton ouvrir;
	
	/**
	 * Entrée d'URL
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
	public OuvrirURL(ChampTexte texte){
		this.texte = texte;
		this.setMaximumSize(new Dimension(650,40));
		
		//Bouton URL : taille, écouteur, infobulle
		this.ouvrir = new JButton("URL");
		this.ouvrir.setPreferredSize(new Dimension(100,25));
		this.ouvrir.addActionListener(new ClicListener()); 
		this.ouvrir.setToolTipText("Affiche le texte de l'URL");
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(3,25));
		
		this.lien = new JTextField("");
		this.lien.setPreferredSize(new Dimension(500,25));
		this.lien.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.lien.setText("http://");
		
		// Affichage d'informations depuis le curseur de souris.  
		this.lien.setToolTipText("URL");
		
		this.add(this.ouvrir);
		this.add(p1);
		this.add(this.lien);
	}
	
	/** 
	 * Ecouteur de click de bouton.
	 * En cas de click du bouton "URL", le contenu de la page web cible est affiché.
	 * 
	 * @author BEN YAHIA HEIDY
	 * @author SAINTPIERRE CHARLOTTE
	 *
	 */
	public class ClicListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent a) {
			try{
			
			// connexion à l'URL et récupération du code source.
			URL url = new URL(lien.getText());
			URLConnection con = url.openConnection();
				
			BufferedReader rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null){
				sb.append(line);
			}
			rd.close();	
			
			// Suppression des balises HTML.
			String s = sb.toString();
			String[] s1 = s.split(">");
			String s2 = "";
			for(int i=0;i<s1.length;i++){
				char[] c1 = s1[i].toCharArray();
				ArrayList<Character> mot = new ArrayList<Character>(); 
				for(int j=0;j<c1.length;j++){
					if(!(c1[j]=='<'))mot.add(c1[j]);
					else{				
						for(int k=0;k<mot.size();k++){
							s2 += mot.get(k); 
						}
						s2 += "\n";
					}
				}		
			}	
			texte.setTexte(s2);
			} catch(IOException er){}			
			catch(IllegalArgumentException er){}
		}
		
	}

}
