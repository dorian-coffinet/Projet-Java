import java.awt.Graphics;


public abstract class Polygone extends FigureColoree {

	public Polygone(){
		super();
	}

	public void affiche(Graphics g){
		super.affiche(g);
		int tx[]=new int [gettab().length];
		int ty[]=new int [gettab().length];
		for (int i=0 ; i<gettab().length ; i++){
			tx[i] = gettab()[i].rendreX();
			ty[i] = gettab()[i].rendreY();
		}
		g.drawPolygon(tx , ty , gettab().length);
	}

	public void modifierPoints(UnPoint[] tab_saisie){
		settab(tab_saisie);

	}

}
