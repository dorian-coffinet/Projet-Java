
public class EvenementARR extends Evenement {

	private Rame rame;

	private static PressRandomNumberGenerator random;

	public EvenementARR(int d, Rame r) {
		super(d);
		rame = r;
	}

	public void afficheDetails(Metropolitain metropolitain) {
		System.out.print("ARR, R");
		System.out.print(rame.nom());
	}

	public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
		Rail rail_avant=rame.rail;
		Rail rail_suivant=rail_avant.avance;
		if(rail_suivant.rame != null){
			incoherenceOuTrucBizarre();
		}else{
			rame.rail=rail_suivant;
			rail_suivant.rame=rame;
			rail_avant.rame=null;
		}




		random = new PressRandomNumberGenerator(rail_suivant.numero());


		if(rame.rail.station!=null){
			rail_suivant.rame.status='S';


			if(metropolitain.estEnBoutDeLigne(rame)==true){
				rame.nbPassagers=0;
			}else{
				if(rame.rail == rame.rail.station.railDroite){
					while(rame.rail.station.nbPassagersADroite>0 && rame.nbPassagers()<nombreDePlacesDansUneRame){
						rame.nbPassagers++;
						rame.rail.station.nbPassagersADroite--;
					}
				}else{
					if(rame.rail == rame.rail.station.railGauche){
						while(rame.rail.station.nbPassagersAGauche>0 && rame.nbPassagers()<nombreDePlacesDansUneRame){
							rame.nbPassagers++;
							rame.rail.station.nbPassagersAGauche--;
						}
					}
				}

			}

			echeancier.ajouter(new EvenementDRS(date+tempsArretRameEnStation, rame));
		}else{
			rail_suivant.rame.status='R';
			echeancier.ajouter(new EvenementARR(date+tempsPourAvancerUneRameSurProchainRail,rame));
		}

	}

}