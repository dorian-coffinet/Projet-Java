/**
 * Cette classe représente une liste de villes avec un attribut supplémentaire. 
 * Elle hérite de la classe ListeDeVilles
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 *
 */
public class VillesDeDepartement extends ListeDeVilles{

	/**
	 * nom du département
	 */
	private String nom_dep;

	/**
	 * retourne le nom du département
	 * @return le nom du département
	 */
	public String getNomDep(){
		return nom_dep;
	}

	/**
	 * modifie le nom du département
	 * @param n le nouveau nom du département
	 */
	public void setNomDep(String n){
		nom_dep=n;
	}



}
