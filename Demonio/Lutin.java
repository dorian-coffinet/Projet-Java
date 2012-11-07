/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les lutins qui sont des monstres.
 * Il s'agit de monstres plutôt bêtes et méchants, ils sont en général très
 * nombreux dans le labyrinthe.
 **/
public class Lutin extends Monstre{

	/**
	 * constructeur vide qui initialise les attributs du lutin
	 */		
	public Lutin (){
		super(); 
		representation = new Representation('L');
		PF=2;
		PM=0;
		PR=1;
		PI=0;
	}
}
