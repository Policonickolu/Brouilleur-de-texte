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
	 * Le texte à brouiller.
	 */
	private String texte = "";
	

	/**
	 * Brouille le texte.
	 * 
	 * La chaîne de caractères est changée en un tableau de caractères.
	 * Le tableau est parcouru. 
	 * Si le caractère à l'indice i est une lettre, il est stocké dans une liste "mot".
	 * Si le caractère à l'indice i n'est pas une lettre ou est le dernier caractère de la chaîne,
	 * cela marque la fin du "mot".
	 * La liste "mot" est mélangée après avoir été privée du premier et du dernier élément.
	 * La première lettre puis, le mot mélangé puis, la dernière lettre puis, le caractère pécial
	 * sont concaténés à la nouvelle chaîne de caractère qui remplace le texte original.
	 * La liste "mot" est réinitialisée pour contenir le prochain mot à mélanger.
	 */
	public void brouillage(){
		
		// Le texte à brouiller est un tableau de caractères.
		char[] c1 = this.texte.toCharArray();
		
		// La liste "mot" représente le mot du texte en cours de traitement.
		ArrayList<Character> mot = new ArrayList<Character>(); 
		
		// Le nouveau texte qui remplacera l'actuel avec les mots brouillés.
		String s1 = "";
		
		// Chaque caractère est testé.
		for(int i=0;i<c1.length;i++){
			
			// Si c'est une lettre, il fait donc parti du "mot" et est stocké dans la liste.
			if(Character.isLetter(c1[i])){
				mot.add(c1[i]);
				
				// Si c'est le dernier caractère du tableau, le mot est terminé et est donc mélangé.
				if(i==c1.length-1) s1 += melangeMot(mot);
			}
			
			// Sinon, c'est un caractère spécial (espace, tiret, chiffre et autres) et le mot est terminé et est donc mélangé.
			else{
				
				// brouillage du mot.
				String s2 = melangeMot(mot);
				
				// ajout du caractère spécial à la fin du mot
				s2 += c1[i];
				
				// ajout du mot brouillé au nouveau texte.
				s1 += s2;
				
				// réinitialisation pour le prochain mot.
				mot.clear();

			}
			
		}
		
		// remplacement du texte actuel par le nouveau brouillé.
		this.texte = s1;
						
	}
	
	/**
	 * Brouille un mot.
	 * Mélange les éléments de la liste entrée en argument,
	 * sauf le premier et le dernier élement.
	 * Retourne un mot dit brouillé sous forme de chaîne de caractères.
	 * 
	 * Seuls les mots de plus de trois lettres sont brouillés.
	 * 
	 * @param mot 
	 * 			la liste de lettres formant le mot à brouiller.
	 * @return le mot mélangé.
	 */
	public String melangeMot(ArrayList<Character> mot){
		String s = "";
		
		// Seuls les mots de plus de trois lettres sont brouillés.
		if(mot.size()>3){
			
			// La première lettre est conservée.
			s += mot.remove(0);
			
			// La dernière lettre est conservée.
			char c3 = mot.remove(mot.size()-1);
			
			// Le reste est mélangé.
			Collections.shuffle(mot);
			
			// rajout de la dernière lettre au reste.
			mot.add(c3);
		}
		
		// rajout du tout à la première lettre.
		for(int j=0;j<mot.size();j++){
			s += mot.get(j); 
		}
		return s;
	}

	/**
	 * Retourne le texte.
	 * 
	 * @return le texte sous forme de chaîne de caractère.
	 */
	public String getTexte() {
		return this.texte;
	}
	
	/**
	 * Modifie le texte à brouiller.
	 * 
	 * @param s
	 * 			le nouveau texte suceptible d'être brouillé.
	 */
	public void setTexte(String s) {
		this.texte = s;
	}
	
}
