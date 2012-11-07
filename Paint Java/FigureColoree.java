import java.awt.*;


public abstract class FigureColoree {
	private UnPoint[] tab_mem;
	private boolean selected;
	private Color couleur;
	
	public FigureColoree(){
		couleur=Color.black;
		tab_mem=new UnPoint[nbPointsMem()];
		for(int i=0;i<nbPointsMem();i++){
			tab_mem[i]=new UnPoint();
		}
		selected=false;
		
	}
	public abstract int nbPointsSaisie();
	
	public abstract int nbPointsMem();
	
	public abstract void modifierPoints(UnPoint[] ps);
	
	public void affiche(Graphics g){
		g.setColor(Color.red);
		if (this.selected){
			for (int i=0 ; i<tab_mem.length ; i++)
				g.drawRect( tab_mem[i].rendreX()-5 , tab_mem[i].rendreY()-5 , 10, 10 );	
		}
		g.setColor(couleur);
	}
	
	public void selectionne(){
		selected=true;
	}
	
	public void deSelectionne(){
		selected=false;
	}
	
	public void translation(int dx, int dy){
		for(int i=0;i<nbPointsMem();i++){
			tab_mem[i].translation(dx,dy);
		}
	}
	
	public UnPoint[] gettab(){
		return tab_mem;
	}
	public void changeCouleur(Color c){
		couleur=c;
	}
	public void settab(UnPoint[] tab){
		for(int i=0;i<nbPointsMem();i++){
			tab_mem[i]=tab[i];
		}
	}
	
	public boolean getSelected(){
		return selected;
	}
	
	public boolean estPres(int abs, int ord){
		boolean proxi = false;
		UnPoint p = new UnPoint(abs, ord);
		for(int i=0; i<tab_mem.length; i++){
			if (tab_mem[i].distance(p)<25)
				proxi = true;
		}
		return proxi ;
	}
	
	public int pointProxi(int abs, int ord){
		int min = -1 ;
		int max = 25 ;
		int ind = 0;
		UnPoint p = new UnPoint(abs, ord);
		for (int i = 0 ; i<tab_mem.length; i++){
			if(tab_mem[i].distance(p)<max && tab_mem[i].distance(p)>min){
				ind = i;
				max =(int)tab_mem[i].distance(p);
			}
		}
		return ind;
	}
	
		
	
}
