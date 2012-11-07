public class EvenementAPS extends Evenement {

	private Station station;

	public EvenementAPS(int d, Station s) {
		super(d);
		station = s;
	}

	public void afficheDetails(Metropolitain metropolitain) {
		System.out.print("APS, ");
		System.out.print(station.numero());
	}

	public void traiter(Metropolitain metropolitain, Echeancier echeancier) {
		char direction = metropolitain.nouveauPassager(station);
		switch (direction){
		case 'd':
			if(station.railDroite.rame==null){
				station.nbPassagersADroite++;
			}else{
				if(station.railDroite.rame.impossibleDeRentrer()==false){
					





					
				}else{
					station.nbPassagersADroite++;
					//aProgrammerPlusTard();
				}
			}


			break;
		case 'g':
			if(station.railGauche.rame==null){
				station.nbPassagersAGauche++;

			}else{
				if(station.railGauche.rame.impossibleDeRentrer()==false){
					
				}else{
					station.nbPassagersAGauche++;
					//aProgrammerPlusTard();
				}

			}

			break;

		default :
			incoherenceOuTrucBizarre();


		}
		echeancier.ajouter(new EvenementAPS(station.APS_suivant(this.date),station));

	}
}