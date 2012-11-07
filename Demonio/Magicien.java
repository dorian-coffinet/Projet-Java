/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les magiciens qui sont des héros.
 * Ce sont des combattants intelligents dotés de pouvoirs mystiques redoutables.
 **/
public class Magicien extends Heros {

	/**
	 * constructeur vide qui initialise les attributs du magicien
	 */
	public Magicien (){
		super();
		representation = new Representation ( 'M') ;
		PF=4;
		PR=1;
		PM=10;
		PI=6;
}

	
}
