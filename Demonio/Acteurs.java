/**
 * @author DUHAUT Anne-Sophie, COFFINET Dorian
 * Cette classe représente les acteurs du jeu d'aventure

 **/
public abstract class Acteurs {

	
	/**
	 * nom de l'acteur
	 */
	protected String nom;

	/**
	 * nombre de points de vie de l'acteur
	 */
	protected int HP;

	/**
	 * nombre de points d'expérience
	 */
	protected int P_xp;

	/**
	 * nombre de points de force de l'acteur
	 */
	protected int PF;

	/**
	 *nombre de points de rapidité de l'acteur 
	 */
	protected int PR;

	/**
	 * nombre de points de magie de l'acteur
	 */
	protected int PM;

	/**
	 * nombre de points d'intelligence de l'acteur
	 */
	protected int PI;

	/**
	 * position de l'acteur dans le labyrinthe
	 */
	protected Position position_dans_labytinthe;

	/**
	 * représentation de l'acteur dans le labyrinthe
	 */
	protected Representation representation;


	/**
	 * @return la representation
	 */
	public Representation getRepresentation() {
		return representation;
	}

	/**
	 * 
	 * @param rep la nouvelle représentation
	 */
	public void setRepresentation(Representation rep) {
		representation=rep;
	}


	public void seDeplacer(int dir, Labyrinthe laby, Acteurs act){
		
		switch(dir){
		
			case 1 :	
				Position p = this.getPosition_dans_labytinthe();
				int x = p.getX()+1;
				int y = p.getY()-1;
				y=changer_XY(y);
				x=changer_XY(x);
				Position p1= new Position(x,y);
				laby.changerCase(p1, act);

				break; 
			case 2 : 
				Position p2 = act.getPosition_dans_labytinthe();
				int x1 = p2.getX()+1;
				int y1 = p2.getY();
				x1=changer_XY(x1);
				Position p3 = new Position(x1,y1);
				laby.changerCase(p3, act);

				break;
			case 3 : 
				Position p4 = act.getPosition_dans_labytinthe();
				int x2 = p4.getX()+1;
				int y2 = p4.getY()+1;
				y2=changer_XY(y2);
				x2=changer_XY(x2);
				Position p5 = new Position(x2,y2);
				laby.changerCase(p5, act);

				break;
			case 4 : 
				Position p6 = act.getPosition_dans_labytinthe();
				int x3 = p6.getX();
				int y3 = p6.getY()-1;
				y3=changer_XY(y3);
				Position p7 = new Position(x3,y3);
				laby.changerCase(p7, act);
				break;
			case 5 : 	

				break;
			case 6 : 
				Position pa = act.getPosition_dans_labytinthe();
				int x5 = pa.getX();
				int y5 = pa.getY()+1;
				y5=changer_XY(y5);
				Position pb = new Position(x5,y5);
				laby.changerCase(pb, act);

				break;
			case 7 : 
				Position pc = act.getPosition_dans_labytinthe();
				int x6 = pc.getX()-1;
				int y6 = pc.getY()-1;
				y6=changer_XY(y6);
				x6=changer_XY(x6);
				Position pd = new Position(x6,y6);
				laby.changerCase(pd, act);

				break;
			case 8 : 
				Position pe = act.getPosition_dans_labytinthe();
				int x7 = pe.getX()-1;
				int y7 = pe.getY();
				x7=changer_XY(x7);
				Position pf = new Position(x7,y7);
				laby.changerCase(pf, act);
				break;
			case 9 : 
				Position pg = act.getPosition_dans_labytinthe();
				int x8 = pg.getX()-1;
				int y8 = pg.getY()+1;
				y8=changer_XY(y8);
				x8=changer_XY(x8);
				Position ph = new Position(x8,y8);
				laby.changerCase(ph, act);

				break; 
			default:
				System.out.println("erreur");
		}
	}


	private int changer_XY(int i) {
		if (i == -1)
			i=29;
		if (i== 30)
			i=0;
		return i;
	}
	
	/**
	 * constructeur vide
	 */
	public Acteurs (){
		
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the hP
	 */
	public int getHP() {
		return HP;
	}


	/**
	 * @param hP the hP to set
	 */
	public void setHP(int hP) {
		HP = hP;
	}


	/**
	 * @return the p_xp
	 */
	public int getP_xp() {
		return P_xp;
	}


	/**
	 * @param p_xp the p_xp to set
	 */
	public void setP_xp(int p_xp) {
		P_xp = p_xp;
	}


	/**
	 * @return the pF
	 */
	public int getPF() {
		return PF;
	}


	/**
	 * @param pF the pF to set
	 */
	public void setPF(int pF) {
		PF = pF;
	}


	/**
	 * @return the pR
	 */
	public int getPR() {
		return PR;
	}


	/**
	 * @param pR the pR to set
	 */
	public void setPR(int pR) {
		PR = pR;
	}


	/**
	 * @return the pM
	 */
	public int getPM() {
		return PM;
	}


	/**
	 * @param pM the pM to set
	 */
	public void setPM(int pM) {
		PM = pM;
	}


	/**
	 * @return the pI
	 */
	public int getPI() {
		return PI;
	}


	/**
	 * @param pI the pI to set
	 */
	public void setPI(int pI) {
		PI = pI;
	}


	/**
	 * @return the position_dans_labytinthe
	 */
	public Position getPosition_dans_labytinthe() {
		return position_dans_labytinthe;
	}


	/**
	 * @param position_dans_labytinthe the position_dans_labytinthe to set
	 */
	public void setPosition_dans_labyrinthe(Position position_dans_labytinthe) {
		this.position_dans_labytinthe = position_dans_labytinthe;
	}



	

	
	
	
	
	
}
