/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les ballrog qui sont des monstres.
 * Il n'y a qu'un seul ballrog dans le labyrinthe. Une rencontre avec lui et le h�ro aura peu de
 * chances de s'en tirer. Seul un h�ro aguerri et exp�riment� pourra venir � bout de cette salle b�te. 
 **/
public class Ballrog extends Monstre{



	/**
	 * constructeur vide qui initialise les attributs de Ballrog
	 */	
	public Ballrog (){
		super();
		representation = new Representation('B');
		PF=10;
		PM=5;
		PR=1;
		PI=5;
	}

}

