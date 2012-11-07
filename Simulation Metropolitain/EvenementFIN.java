public class EvenementFIN extends Evenement {

    public EvenementFIN() {
	super(dateDeFinDeLaSimulation);
    }

    public void afficheDetails(Metropolitain metropolitain) {
	System.out.print("FIN");
    }

    public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
	while ( !echeancier.estVide() ) {
	    echeancier.retourneEtEnlevePremier();
	}
    }

}