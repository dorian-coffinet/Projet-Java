/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente le labyrinthe du jeu d'aventure dans lequel se déplacent les acteurs.
 **/

public class Labyrinthe {
	
	/**
	 * largeur du labyrinthe
	 */
	private int dimension_X;
	
	/**
	 * hauteur du labyrinthe
	 */
	private int dimension_Y;
	
	/**
	 * le labyrinthe représenté par un tableau à deux dimensions des cases
	 */
	private Case laby  [][]  ; 


	/**
	 * crée un labyrinthe
	 * @param dimX
	 * @param dimY
	 */
	public Labyrinthe(int dimX, int dimY){
		this.dimension_X=dimX;
		this.dimension_Y=dimY;

		laby = new Case[this.dimension_X][this.dimension_Y];
		//cest plus tard qu'il faudra dire si case libre ou non

		for (int i=0; i<this.dimension_X;i++){
			for (int j=0; j<this.dimension_X;j++){
				//instencie tout les objets dans le laby
				laby[i][j]= new CaseLibre();


			}
		}

	}
	/**
	 * affiche le labyrinthe
	 */
	public void afficherLabyrinthe(){
		for (int i=0; i<this.dimension_X;i++){
			for (int j=0; j<this.dimension_X;j++){
				laby[i][j].afficheCase();
				System.out.print(' ');
			}
			System.out.println();
		}	
	}

	public void changerCase(Position pos, Acteurs act){
		Position libre = act.getPosition_dans_labytinthe();
		int x = libre.getX();
		int y = libre.getY();
		laby[x][y]= new CaseLibre();
		act.setPosition_dans_labyrinthe(pos);
		laby[pos.getX()][pos.getY()] = new CaseOccupee(act);

	}


}
