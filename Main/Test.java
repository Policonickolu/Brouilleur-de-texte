package Main;

import java.util.ArrayList;

import Modele.Texte;


/**
 * Classe de test.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public class Test {
	
	/**
	 * M�thode de test.
	 */
	public Test(){
		
		// Test de la m�thode m�lange de mot
		Texte t1 = new Texte();
		ArrayList<Character> al1 = new ArrayList<Character>();
		al1.add('t');
		al1.add('�');
		al1.add('l');
		al1.add('�');
		al1.add('p');
		al1.add('h');
		al1.add('o');
		al1.add('n');
		al1.add('e');
		String s1 = t1.melangeMot(al1);
		System.out.println(s1);
		
		// Test de la m�thode brouillage de texte.
		Texte t2 = new Texte();
		t2.setTexte("La maison du chasseur a br�l� � cause du porte-manteau !!?!!");
		t2.brouillage();
		System.out.println(t2.getTexte());
		
	}
	
}