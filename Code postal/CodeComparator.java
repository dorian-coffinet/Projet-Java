import java.util.Comparator;

/**
 * Cette classe décrit comment se fait la comparaison des codes postaux de ville. Elle hérite de la classe Comparator<Ville>
 * @author Anne-Sophie DUHAUT, Dorian COFFINET
 * 
 *
 */
public class CodeComparator implements Comparator<Ville>{

		public int compare(Ville o1, Ville o2){
			String n1=o1.getCodePostal();
			String n2=o2.getCodePostal();
			return ( n1.compareTo(n2));
		}
}
