/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les ballrog qui sont des monstres.
 * Il n'y a qu'un seul ballrog dans le labyrinthe. Une rencontre avec lui et le héro aura peu de
 * chances de s'en tirer. Seul un héro aguerri et expérimenté pourra venir à bout de cette salle bête. 
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

