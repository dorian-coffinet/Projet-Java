/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les orcs qui sont des monstres.
 * Ce sont des pi�tres combattants, mais ils adorent ramasser les objets qu'ils trouvent
 * un peu partout dans le labyrinthe. S'ils ne peuvent pas se servir de ces objets, ils
 * emp�chent le h�ros de se procurer des objets qui peuvent lui �tre fort utiles dans sa qu�te.
 **/
public class Orc extends Monstre{

	/**
	 * sac contenant les articles ramass�s
	 */
	private Objet sac;

	/**
	 * constructeur vide qui initialise les attributs de l'orc
	 */	
	public Orc (){
		super(); 
		representation = new Representation('O');
		PF=0;
		PM=0;
		PR=1;
		PI=0;
	}
}


