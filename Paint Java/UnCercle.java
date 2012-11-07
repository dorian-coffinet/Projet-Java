import java.awt.*;


public class UnCercle extends ConiqueCentree{

	public UnCercle(){
		super();
	}
	public double rendreRayon(){
		return gettab()[0].distance(gettab()[1]);
	}

	public int nbPointsSaisie(){
		return 2;

	}
	
	public int nbPointsMem(){
		return 2;

	}

	public void affiche(Graphics g){
		super.affiche(g);
		g.drawOval(gettab()[0].rendreX()-(int)rendreRayon(), gettab()[0].rendreY()-(int)rendreRayon(), 
				(int)rendreRayon()*2, (int)rendreRayon()*2); 		
	}

	public void modifierPoints(UnPoint[] tab_saisie){
		settab(tab_saisie);

	}
}
