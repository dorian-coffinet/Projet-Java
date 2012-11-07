/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les repr�sentations des acteurs
 **/
public class Representation {
	
	/**
	 * repr�sentation par un caract�re
	 */
	private char rep;
	
	
	/**
	 * cr�e une repr�sentation
	 * @param rep
	 */
	public Representation(char rep){
		this.rep=rep;
	}


	/**
	 * get
	 * @return rep la repr�sentation
	 */
	public char getRep() {
		return rep;
	}
	
	/**
	 * set
	 * @param rep la nouvelle repr�sentation
	 */
	public void setRep(char rep){
		this.rep=rep;
	}
	
	/**
	 * affiche la repr�sentation
	 */
	public String toString(){
		char car[];
		car = new char[1];
		car[0]=rep;
		return (new String(car));
	}
	
	
}
