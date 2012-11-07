import java.util.*;

public class Metropolitain extends Constantes {

    private Rail haut; // Celle qui est tout en haut sur l'affichage.

    private Rail bas; // Celle qui est tout en bas sur l'affichage.

    private Rame[] rames;

    private Station[] stations;

    public Metropolitain (Echeancier echeancier) {
	int c = nombreDeStations * 4;
	// Fabrication d'un cercle de c Rails:
	haut = new Rail();
	Rail r1 = haut;
	Rail r2 = null;
	c--;
	while ( c > 0 ) {
	    r2 = new Rail();
	    r1.avance = r2;
	    r2.recule = r1;
	    r1 = r2;
	    c--;
	}
	r1.avance = haut;
	haut.recule = r1;
	// Initialisation du bas:
	bas = haut;
	c = nombreDeStations * 2;
	while ( c > 0 ) {
	    bas = bas.avance;
	    c--;
	}
	// Placement des Stations;
	r1 = haut.recule;
	r2 = haut.avance;
	c = nombreDeStations;
	stations = new Station[nombreDeStations];
	while ( c > 0) {
	    Station station = new Station(r1,r2,echeancier,this);
	    r1.station = station;
	    r2.station = station;
	    r1 = r1.recule.recule;
	    r2 = r2.avance.avance;
	    compteurDePassagers = compteurDePassagers + station.nbPassagersAGauche;
	    compteurDePassagers = compteurDePassagers + station.nbPassagersADroite;
	    c--;
	    stations[c] = station;
	}
	// Placement des Rames:
	c = nombreDeRames;
	rames = new Rame[nombreDeRames];
	while ( c > 0) {
	    Rail r = haut;
	    int i = random.intSuivant(nombreDeStations * 8);
	    while ( i > 0 ) {
		r = r.avance;
		i--;
	    }
	    if ( r.rame == null ) {
		r.rame = new Rame(echeancier, r);
		c--;
		rames[c] = r.rame;
	    }
	}
	debugCheck();
    }
    
    public void affiche () {
	int marge = 4;
	printChar(' ', marge * 2 + longueurAffichageCase + 2);
	haut.affiche();
	System.out.println();
	//
	Rail r1 = haut.recule;
	Rail r2 = haut.avance;
	while ( r1 != bas ) {
	    this.afficheAux(marge, r1, r2);
	    r1 = r1.recule;
	    r2 = r2.avance;
	}
	//
	printChar(' ', marge * 2 + longueurAffichageCase + 2);
	bas.affiche();
	System.out.println();
	// Details des rames:
	int i = rames.length;
	while ( i > 0 ) {
	    i--;
	    printChar(' ', marge);
	    rames[i].afficheDetails();
	    System.out.println();
	}
	//
	System.out.print("Compteur de passagers = ");
	System.out.print(compteurDePassagers);
	System.out.println();
	//
	debugCheck();
    }

    private static void afficheAux (int marge, Rail r1, Rail r2) {
	Station station = r1.station;
	printChar(' ', marge);
	if ( station == null ) {
	    printChar(' ', marge);
	} else {
	    String str = "" + station.nbPassagersAGauche + ' ';
	    while ( str.length() < marge ) {
		str = ' ' + str;
	    }
	    System.out.print(str);
	}
	r1.affiche();
	printChar(' ', 2);
	if ( station == null ) {
	    printChar(' ', longueurAffichageCase);
	} else {
	    station.affiche();
	}
	printChar(' ', 2);
	r2.affiche();
	if ( station != null ) {
	    System.out.print(' ');
	    System.out.print(station.nbPassagersADroite);
	}
	System.out.println();
    }
    
    private static PressRandomNumberGenerator random = new PressRandomNumberGenerator(76);

    private static void printChar (char c, int times) {
	while ( times > 0 ) {
	    System.out.print(c);
	    times--;
	}
    }

    public void debugCheck () {
	int nbRails = 1;
	// La grande boucle dans un sens:
	Rail r = haut.avance;
	while ( r != haut ) {
	    nbRails ++;
	    r = r.avance;
	}
	// La grande boucle dans l'autre sens:
	r = haut.recule;
	while ( r != haut ) {
	    r = r.recule;
	}
	// Les stations:
	int i = stations.length;
	if ( i != nombreDeStations ) {
	    incoherenceOuTrucBizarre();
	}
	while ( i > 0 ) {
	    i--;	    
	    Station s = stations[i];
	    if ( s.railGauche == null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railDroite == null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railGauche.station != s) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railDroite.station != s) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railGauche.avance.station != null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railGauche.recule.station != null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railDroite.avance.station != null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( s.railDroite.recule.station != null) {
		incoherenceOuTrucBizarre();
	    }
	}
	// Les rames:
	i = rames.length;
	if ( i != nombreDeRames ) {
	    incoherenceOuTrucBizarre();
	}
	while ( i > 0 ) {
	    i--;	    
	    Rame rame = rames[i];
	    if ( rame.nbPassagers() < 0 ) {
		incoherenceOuTrucBizarre();
	    }
	    if ( rame.rail == null) {
		incoherenceOuTrucBizarre();
	    }
	    if ( rame.rail.rame != rame) {
		incoherenceOuTrucBizarre();
	    }
	}
	// Le haut:
	if ( haut.rame != null ) {
	    if ( haut.rame.nbPassagers() > 0 ) {
		incoherenceOuTrucBizarre();
	    }
	}
	// Le bas:
	if ( bas.rame != null ) {
	    if ( bas.rame.nbPassagers() > 0 ) {
		incoherenceOuTrucBizarre();
	    }
	}
    }

    private int compteurDePassagers = 0;

    public char nouveauPassager(Station s) {
	char direction;
	compteurDePassagers++;
	if ( random.intSuivant(10) <= 5 ) {
	    direction = 'd';
	} else {
	    direction = 'g';
	}
	if ( this.enHaut(s) ) {
	    direction = 'd';	    
	} else if ( this.enBas(s) ) {
	    direction = 'g';
	}
	return direction;
    }

    public boolean enHaut(Station s) {
	return haut == s.railGauche.avance;
    }

    public boolean enBas(Station s) {
	return bas == s.railDroite.avance;
    }

    public Rame rameAuHazard() {
	return rames[random.intSuivant(rames.length - 1)];
    }
    
    public boolean estEnBoutDeLigne(Rame rame){
    	Station station = rame.rail.station;
    	if(station==null){
    		return false;
    	}
    	if(station.numero()==1){
    		return true;
    	}
    	if(station.numero()==nombreDeStations){
    		return true;
    	}
    	return false;
    }

}
