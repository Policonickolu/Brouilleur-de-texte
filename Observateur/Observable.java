package Observateur;

import Modele.Texte;

/**
 * Interface Observable.
 * 
 * @author BEN YAHIA HEIDY
 * @author SAINTPIERRE CHARLOTTE
 *
 */
public interface Observable {
	
	public void notifyObservateur(Texte[] t);
	public void addObservateur(Observateur o);
	public void removeObservateur();

}
