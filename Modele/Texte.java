package Modele;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Texte du Brouilleur.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class Texte {

	/**
	 * Le texte � brouiller.
	 */
	private String texte = "";
	

	/**
	 * Brouille le texte.
	 * 
	 * La cha�ne de caract�res est chang�e en un tableau de caract�res.
	 * Le tableau est parcouru. 
	 * Si le caract�re � l'indice i est une lettre, il est stock� dans une liste "mot".
	 * Si le caract�re � l'indice i n'est pas une lettre ou est le dernier caract�re de la cha�ne,
	 * cela marque la fin du "mot".
	 * La liste "mot" est m�lang�e apr�s avoir �t� priv�e du premier et du dernier �l�ment.
	 * La premi�re lettre puis, le mot m�lang� puis, la derni�re lettre puis, le caract�re p�cial
	 * sont concat�n�s � la nouvelle cha�ne de caract�re qui remplace le texte original.
	 * La liste "mot" est r�initialis�e pour contenir le prochain mot � m�langer.
	 */
	public void brouillage(){
		
		// Le texte � brouiller est un tableau de caract�res.
		char[] c1 = this.texte.toCharArray();
		
		// La liste "mot" repr�sente le mot du texte en cours de traitement.
		ArrayList<Character> mot = new ArrayList<Character>(); 
		
		// Le nouveau texte qui remplacera l'actuel avec les mots brouill�s.
		String s1 = "";
		
		// Chaque caract�re est test�.
		for(int i=0;i<c1.length;i++){
			
			// Si c'est une lettre, il fait donc parti du "mot" et est stock� dans la liste.
			if(Character.isLetter(c1[i])){
				mot.add(c1[i]);
				
				// Si c'est le dernier caract�re du tableau, le mot est termin� et est donc m�lang�.
				if(i==c1.length-1) s1 += melangeMot(mot);
			}
			
			// Sinon, c'est un caract�re sp�cial (espace, tiret, chiffre et autres) et le mot est termin� et est donc m�lang�.
			else{
				
				// brouillage du mot.
				String s2 = melangeMot(mot);
				
				// ajout du caract�re sp�cial � la fin du mot
				s2 += c1[i];
				
				// ajout du mot brouill� au nouveau texte.
				s1 += s2;
				
				// r�initialisation pour le prochain mot.
				mot.clear();

			}
			
		}
		
		// remplacement du texte actuel par le nouveau brouill�.
		this.texte = s1;
						
	}
	
	/**
	 * Brouille un mot.
	 * M�lange les �l�ments de la liste entr�e en argument,
	 * sauf le premier et le dernier �lement.
	 * Retourne un mot dit brouill� sous forme de cha�ne de caract�res.
	 * 
	 * Seuls les mots de plus de trois lettres sont brouill�s.
	 * 
	 * @param mot 
	 * 			la liste de lettres formant le mot � brouiller.
	 * @return le mot m�lang�.
	 */
	public String melangeMot(ArrayList<Character> mot){
		String s = "";
		
		// Seuls les mots de plus de trois lettres sont brouill�s.
		if(mot.size()>3){
			
			// La premi�re lettre est conserv�e.
			s += mot.remove(0);
			
			// La derni�re lettre est conserv�e.
			char c3 = mot.remove(mot.size()-1);
			
			// Le reste est m�lang�.
			Collections.shuffle(mot);
			
			// rajout de la derni�re lettre au reste.
			mot.add(c3);
		}
		
		// rajout du tout � la premi�re lettre.
		for(int j=0;j<mot.size();j++){
			s += mot.get(j); 
		}
		return s;
	}

	/**
	 * Retourne le texte.
	 * 
	 * @return le texte sous forme de cha�ne de caract�re.
	 */
	public String getTexte() {
		return this.texte;
	}
	
	/**
	 * Modifie le texte � brouiller.
	 * 
	 * @param s
	 * 			le nouveau texte suceptible d'�tre brouill�.
	 */
	public void setTexte(String s) {
		this.texte = s;
	}
	
}
