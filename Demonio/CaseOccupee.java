/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe repr�sente les cases occup�es du labyrinthe.
 */
public class CaseOccupee extends Case{

	private Acteurs act;
	
	/**
	 * cr�e une case occup�e contenant donc un acteur
	 * @param act l'acteur
	 */
	public CaseOccupee(Acteurs act){
		representation= new Representation(act.getRepresentation().getRep());


	}
	
	/**
	 * get
	 * @return la repr�sentation de l'acteur qui occupe la case
	 */
	public Representation getRepresentation(){
		return(act.getRepresentation());
	}

}
