/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les cases du labyrinthe.
 */
public abstract class Case {

	/**
	 * representation de la case
	 */
	protected Representation representation;

	/**
	 * constructeur vide
	 */
	public Case(){

	}
	/**
	 * affiche le contenu de la case, fait appel � toString() de Representation
	 */
	public void afficheCase(){
		System.out.print(representation);
	}
	
	/**
	 * get
	 * @return la repr�sentation de la case
	 */
	public abstract Representation getRepresentation();
	
	/**
	 * set
	 * @param rep la nouvelle repr�sentation 
	 */
	public void setRepresentation(Representation rep){
		representation = rep;
	}
	
}


