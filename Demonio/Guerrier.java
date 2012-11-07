/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les guerriers qui sont des héros.
 * Ils sont des combattants puissants leur force est considérable.
 **/
public class Guerrier extends Heros{
	/**
	 * constructeur vide qui initialise les attributs du guerrier
	 */
	public Guerrier (){
		super();
		representation =new Representation('@') ;
		PF=10;
		PR=1;
		PM=0;
		PI=0;

	}

}
