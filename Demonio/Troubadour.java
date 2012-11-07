/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les troubadours qui sont des h�ros.
 * Ce sont des artistes mais m�fiance, ils peuvent s'av�rer tr�s dou�e au combat et ils sont tr�s rapides.
 **/
public class Troubadour extends Heros {

	/**
	 * constructeur vide qui initialise les attributs du troubadour
	 */
	public Troubadour(){
		super();
		representation = new Representation('$');
		PF=4;
		PR=5;
		PM=6;
		PI=8;
	}

}