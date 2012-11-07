/**
 * Cette classe représente une ligne du fichier "codePost.txt", c'est-à-dire une ville et son département
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 *
 */
public class Ville {
	/**
	 * le nom de la ville
	 */
	private String nom;

	/**
	 * le code postal de la ville
	 */
	private String code_postal;

	/**
	 * crée une ville 
	 * @param n nom de la ville
	 * @param c_p code postal de la ville
	 */
	public Ville(String n, String c_p){
		nom=n;
		code_postal=c_p;
	}

	/**
	 * retourne le nom de la ville
	 * @return le nom
	 */
	public String getNom(){
		return nom;
	}

	/**
	 * retourne le code postal de la ville
	 * @return le code postal
	 */
	public String getCodePostal(){
		return code_postal; 
	}

	/**
	 * retourne une chaîne de caractères caractérisant une ligne du fichie "codePost.txt"
	 */
	public String toString(){
		return("Ville : "+nom+", "+"Departement : "+code_postal);
	}

}
