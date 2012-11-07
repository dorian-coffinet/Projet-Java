public class EvenementRAP extends Evenement {

    private Rame rame;

    public EvenementRAP(int d, Rame r) {
	super(d);
	rame = r;
    }

    public void afficheDetails(Metropolitain metropolitain) {
	System.out.print("RAP, R");
	System.out.print(rame.nom());
    }

    public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
	if (rame.rail.station != null ) {
	    incoherenceOuTrucBizarre();
	}
	aProgrammerPlusTard();
    }

}