import java.awt.Color;
import java.awt.Graphics;


public class UnRectangle extends UnQuadrilatere {
	
	public UnRectangle(){
		super();
		this.modifierPoints(gettab());
	}
	
	public int nbPointsSaisie(){
		return 2;
	}
	
	public int nbPointsMem(){
		return 4;
	}
	
	public void modifierPoints(UnPoint[] tab_saisie){
		UnPoint[] tab=new UnPoint[4];
		tab[0]=tab_saisie[0];
		tab[2]=tab_saisie[1];
		int x=tab_saisie[1].rendreX();
		int y=tab_saisie[0].rendreY();
		tab[1]=new UnPoint(x,y);
		int xx=tab_saisie[0].rendreX();
		int yy=tab_saisie[1].rendreY();
		tab[3]=new UnPoint(xx,yy);
		settab(tab);
	}
		
}
