/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les cases occupées du labyrinthe.
 */
public class CaseOccupee extends Case{

	private Acteurs act;
	
	/**
	 * crée une case occupée contenant donc un acteur
	 * @param act l'acteur
	 */
	public CaseOccupee(Acteurs act){
		representation= new Representation(act.getRepresentation().getRep());


	}
	
	/**
	 * get
	 * @return la représentation de l'acteur qui occupe la case
	 */
	public Representation getRepresentation(){
		return(act.getRepresentation());
	}

}
