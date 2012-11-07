import java.io.BufferedReader;
import java.util.InputMismatchException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String args[]) {
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	Echeancier echeancier = new Echeancier();
	echeancier.ajouter(new EvenementPAN());
	echeancier.ajouter(new EvenementFIN());
	Metropolitain metropolitain = new Metropolitain(echeancier);
	int loop = 1;
	int simulationStepCounter = 0;
     	// Boucle principale du simulateur: 
	while ( ! echeancier.estVide() ) {
	    if ( loop == 1 ) {
		System.out.print("----- Etat actuel du simulateur (nombre total de pas = ");
		System.out.print(simulationStepCounter);
		System.out.println(") -----");
		metropolitain.affiche();
		echeancier.affiche(metropolitain);
	    }
	    if (loop == 1) {
		System.out.println(
                "Taper \"Enter\" ou le nombre de pas de simulation que vous voulez réaliser");
		try {
		    loop = Integer.parseInt(input.readLine());
		    if (loop < 0) {
			loop = 1;
		    }
		} catch (Exception e) {
		    loop = 1;
		}
	    } else {
		loop--;
	    }
	    Evenement evenement = echeancier.retourneEtEnlevePremier();
	    evenement.traiter(metropolitain, echeancier);
	    // metropolitain.debugCheck();
	    simulationStepCounter++;
	}
	System.out.println("********** SIMULATION TERMINEE **********");
    }
}
