/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les fisk qui sont des monstres.
 * Ce sont des voleurs. Plutôt nuls au combat, ils adorent les pièces d'or.
 * Une rencontre avec ces monstres et les pièces d'or s'envoleront.
 * La rapidité est leur atout majeur.
 **/

public class Fisk extends Monstre {
	
	/**
	 * bourse contenant les pièces d'or
	 */
	private Or bourse;
	
	/**
	 * constructeur vide qui initialise les attributs de Fisk
	 */	
	public Fisk (){
		super(); 
		representation = new Representation('F');
		PF=1;
		PM=0;
		PR=10;
		PI=0;
		
}

}
