public class EvenementDRS extends Evenement {

    private Rame rame;

    public EvenementDRS(int d, Rame r) {
	super(d);
	rame = r;
    }

    public void afficheDetails(Metropolitain metropolitain) {
	System.out.print("DRS, R");
	System.out.print(rame.nom());
    }

    public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
    	rame.status='R';
    	echeancier.ajouter(new EvenementARR(date+tempsPourAvancerUneRameSurProchainRail,rame));
    	//aProgrammerPlusTard();
    }

}