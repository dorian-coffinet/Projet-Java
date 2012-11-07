/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les fisk qui sont des monstres.
 * Ce sont des voleurs. Plut�t nuls au combat, ils adorent les pi�ces d'or.
 * Une rencontre avec ces monstres et les pi�ces d'or s'envoleront.
 * La rapidit� est leur atout majeur.
 **/

public class Fisk extends Monstre {
	
	/**
	 * bourse contenant les pi�ces d'or
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
