public abstract class Evenement extends Constantes {
    
    protected int date; // en dixieme de secondes
    
    public Evenement (int d) {
    	date = d;
    }
    
    public abstract void traiter (Metropolitain metropolitain, Echeancier echeancier);
    
    public void affiche (Metropolitain metropolitain) {
	System.out.print('[');
	System.out.print(date);
	System.out.print(',');
	this.afficheDetails(metropolitain);
	System.out.print(']');
    }
    
    public abstract void afficheDetails (Metropolitain metropolitain);
    
}
