import java.util.*;

public class Rame extends Constantes {

    private char nom;

    public char nom () {
	return nom;
    }

    public char status;

    public int nbPassagers;

    public int nbPassagers () {
	return nbPassagers;
    }

    public Rail rail;

    public Rame (Echeancier echeancier, Rail r) {
    poissonFrequenceArrivee=new LoiDePoisson(nom,tempsPourAvancerUneRameSurProchainRail);
	rail = r;
	nom = globalPourInitialiserLeNom;
	globalPourInitialiserLeNom++;
	random = new PressRandomNumberGenerator(r.numero());
	if ( r.avance.rame == null ) {
	    status = 'R';
	    echeancier.ajouter(new EvenementARR(random.intSuivant(tempsPourAvancerUneRameSurProchainRail),this));
	} else {
	    aProgrammerPlusTard();
	}
	nbPassagers = 0;
    }
    
    public String affiche () {	
	String str = "R";
	if ( this.enPanne() ) {
	    str = str + "#?";
	}	
	str = str + nom;
	char lastChar;
	if ( this.portesOuvertes() ) {
	    str = str + ']';
	    lastChar = '[';
	} else {
	    str = str + '[';
	    lastChar = ']';
	}
	str = str + nbPassagers + lastChar;
	return str;
    }

    public void afficheDetails () {
	String str = this.affiche();
	while ( str.length()  < 9 ) {
	    str = str + ' ';
	}
	System.out.print(str);
	System.out.print(": ");
	switch (status) {
	case 'R': 
	    System.out.print("Roulante. ");
	    break;
	case 'P': 
	case 'O': 
	    System.out.print("En Panne. ");
	    break;
	case 'S': 
	    System.out.print("En Station. ");
	    break;
	default:
	    incoherenceOuTrucBizarre();
	}
	if ( this.portesOuvertes() ) {
	    System.out.print("Portes ouvertes.");
	} else {
	    System.out.print("Portes closes.");
	}
    }

    private static char globalPourInitialiserLeNom = 'a';

    private PressRandomNumberGenerator random;

    public boolean portesOuvertes () {
	if ( rail.station == null ) {
	    return false;
	} else if ( status == 'S' ) {
	    return true;
	} else if ( status == 'P') {
	    return false;
	} else if ( status == 'O') {
	    return true;
	} else if ( status == 'R') {
	    return false;
	} else {
	    incoherenceOuTrucBizarre();
	}
	return false;
    }

    public void set_panne (boolean flag) {
	if ( flag ) {
	    if ( this.rail.station == null ) {
		status = 'P';
	    } else {
		status = 'O';
	    }
	} else {
	    if ( this.rail.station == null ) {
		status = 'R';
	    } else if ( status == 'O') {
		status = 'S';
	    } else if ( status == 'P') {
		status = 'R';
	    }
	}
    }

    public boolean enPanne () {
	if ( status == 'P' ) {
	    return true;

	} else if ( status == 'O' ) {
	    return true;
	}
	return false;
    }

    public boolean impossibleDeRentrer () {
	if ( this.portesOuvertes() ) {
	    if ( nbPassagers < nombreDePlacesDansUneRame ) {
		nbPassagers++;
		return false;
	    }
	}
	return true;
    }
    
    private LoiDePoisson poissonFrequenceArrivee;

    public int ARR_suivant(int d) {
    	return d + poissonFrequenceArrivee.suivant(); 
        }
  
 
}