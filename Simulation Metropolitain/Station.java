import java.util.*;

public class Station extends Constantes {

    private int numero;

    public int numero () {
	return numero;
    }

    public Rail railGauche;

    public int nbPassagersAGauche;

    public Rail railDroite;

    public int nbPassagersADroite;

    public Station (Rail g, Rail d, Echeancier echeancier, Metropolitain metropolitain) {
	compteurGlobalDeStations++;
	numero = compteurGlobalDeStations;
	poissonFrequenceArrivee = new LoiDePoisson(numero,frequenceArriveePassagerStation);
	random = new PressRandomNumberGenerator(numero);
	railGauche = g;
	if ( metropolitain.enHaut(this) ) {
	    nbPassagersAGauche = 0;
	} else {
	    nbPassagersAGauche = random.intSuivant(20);
	}
	echeancier.ajouter(new EvenementAPS(APS_suivant(0),this));
	railDroite = d;
	if ( metropolitain.enBas(this) ) {
	    nbPassagersADroite = 0;
	} else {
	    nbPassagersADroite = random.intSuivant(20);
	}
    }
    
    public void affiche () {
	String str = " S" + numero() + ' ';
	while ( str.length() < longueurAffichageCase ) {
	    str = "-" + str;
	    if ( str.length() < longueurAffichageCase ) {
		str = str + "-";
	    }
	}
	System.out.print(str);
    }

    private LoiDePoisson poissonFrequenceArrivee;

    public int APS_suivant(int d) {
	return d + poissonFrequenceArrivee.suivant(); 
    }

    private PressRandomNumberGenerator random;
    
    private static int compteurGlobalDeStations = 0;

}