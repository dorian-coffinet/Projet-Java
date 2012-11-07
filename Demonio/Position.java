/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les positions
 **/
public class Position {

	/**
	 * abscisse de la position
	 */
	private int x;

	/**
	 * ordonnée de la position
	 */
	private int y;

	/**
	 * constructeur vide
	 */
	public Position(){
		x=0;
		y=0;
	}
	
	/**
	 * crée une position
	 * @param abs
	 * @param ord
	 */
	public Position (int abs, int ord){
		this.x=abs;
		this.y=ord;
	}

	

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}

