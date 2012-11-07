/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les représentations des acteurs
 **/
public class Representation {
	
	/**
	 * représentation par un caractère
	 */
	private char rep;
	
	
	/**
	 * crée une représentation
	 * @param rep
	 */
	public Representation(char rep){
		this.rep=rep;
	}


	/**
	 * get
	 * @return rep la représentation
	 */
	public char getRep() {
		return rep;
	}
	
	/**
	 * set
	 * @param rep la nouvelle représentation
	 */
	public void setRep(char rep){
		this.rep=rep;
	}
	
	/**
	 * affiche la représentation
	 */
	public String toString(){
		char car[];
		car = new char[1];
		car[0]=rep;
		return (new String(car));
	}
	
	
}
