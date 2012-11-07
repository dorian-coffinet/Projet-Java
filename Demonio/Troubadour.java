/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les troubadours qui sont des héros.
 * Ce sont des artistes mais méfiance, ils peuvent s'avérer très douée au combat et ils sont très rapides.
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