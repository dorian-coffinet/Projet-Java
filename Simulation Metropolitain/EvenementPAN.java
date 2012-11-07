public class EvenementPAN extends Evenement {

    public EvenementPAN() {
	super(PAN_suivant(0));
    }

    public void afficheDetails(Metropolitain metropolitain) {
	System.out.print("PAN");
    }

    public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
	aProgrammerPlusTard();
    }

    private static LoiDePoisson poissonFrequencePanne = new LoiDePoisson(35,frequencePanneDeRame);

    private static int PAN_suivant(int d) {
	return d + poissonFrequencePanne.suivant(); 
    }

}