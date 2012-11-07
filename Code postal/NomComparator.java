import java.util.Comparator;

/**
 * Cette classe décrit comment se fait la comparaison des noms de ville. Elle hérite de la classe Comparator<Ville>
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 *
 */
public class NomComparator implements Comparator<Ville>{


	public int compare(Ville o1, Ville o2){
		String n1=o1.getNom();
		String n2=o2.getNom();
		return ( n1.compareTo(n2));
	}
}