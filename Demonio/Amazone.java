/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les amazones qui sont des héros.
 * Elles sont des combattantes redoutables. Elles allient force et intelligence.
 **/
public class Amazone extends Heros{

	/**
	 * constructeur vide qui initialise les attributs de l'amazone
	 */
	public Amazone (){
		super();
		representation = new Representation('#');
		PF=8;
		PR=1;
		PM=0;
		PI=4;
	}


}