/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les orcs qui sont des monstres.
 * Ce sont des piètres combattants, mais ils adorent ramasser les objets qu'ils trouvent
 * un peu partout dans le labyrinthe. S'ils ne peuvent pas se servir de ces objets, ils
 * empêchent le héros de se procurer des objets qui peuvent lui être fort utiles dans sa quête.
 **/
public class Orc extends Monstre{

	/**
	 * sac contenant les articles ramassés
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


