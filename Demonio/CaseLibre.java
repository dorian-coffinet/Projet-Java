/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les cases libres du labyrinthe.
 */
public class CaseLibre extends Case {

	/**
	 * constructeur vide
	 */
	public CaseLibre(){
		super();
		representation=new Representation( '.');
	}
	
	/**
	 * get
	 * @return la représentation de la case
	 */
	public Representation getRepresentation(){
		return(representation);
	}
	
}
