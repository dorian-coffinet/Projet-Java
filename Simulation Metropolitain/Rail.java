import java.util.*;

public class Rail extends Constantes {

    private int numero;

    public int numero () {
	return numero;
    }

    public Rail avance;

    public Rame rame;

    public Station station;

    public Rail recule;
    
    public Rail () {
	compteurGlobalDeStations++;
	numero = compteurGlobalDeStations;
	avance = null;
	rame = null;
	station = null;
	recule = null;
    }
    
    public void affiche () {
	String str = null;
	if ( rame == null ) {
	   str = "";
	} else {
	    str = " " + rame.affiche() + ' ';
	}
	while ( str.length() < longueurAffichageCase ) {
	    str = "+" + str;
	    if ( str.length() < longueurAffichageCase ) {
		str = str + "+";
	    }
	}
	System.out.print(str);
    }

    private static int compteurGlobalDeRails = 0;

    private static int compteurGlobalDeStations = 0;
    
    
   
    
}