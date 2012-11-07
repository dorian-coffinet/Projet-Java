import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


public class DessinFigures extends JPanel {

	private FigureColoree[] figures;
	private int nbf;
	private int sel;
	private String pointerType;

	public DessinFigures(){
		nbf=0;
		figures=new FigureColoree[100];
		sel=-1;
	}

	public void ajoute(FigureColoree f){
		if(f!=null){
			figures[nbf]=f;
			if(sel!=-1)
				figures[sel].deSelectionne();	
			sel=nbf;
			f.selectionne();
			nbf++;
			repaint();
		}	
	}

	public int nbFigures(){
		return nbf;
	}



	public  FigureColoree figureSelection(){
		return figures[sel];
	}


	public void selectionProchaineFigure(){
		int i = 0;
		while(figures[i].getSelected()==false && sel < nbf ){
			i++;
		}

		if(i == nbf-1){
			figures[i].deSelectionne();
			figures[0].selectionne();
		}else{
			figures[i].deSelectionne();
			figures[i+1].selectionne();
		}

	}



	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.white);
		for(int i=0;i<nbFigures();i++)
			figures[i].affiche(g);

	}

	public void trace(Color c){
		TraceurForme t=new TraceurForme(getGraphics(), c);
		addMouseListener(t);
		addMouseMotionListener(t);
	}
	public void construit(FigureColoree f){
		FabricantFigure ff= new FabricantFigure(f);
		addMouseListener(ff);
	}

	public void activeManipulationsSouris(){
		ManipulateurFormes mf = new ManipulateurFormes ();
		addMouseMotionListener(mf);
		addMouseListener(mf);
	}

	public void casseLien(){
		MouseMotionListener [] mml = (MouseMotionListener[])(getListeners(MouseMotionListener.class));
		MouseListener [] ml = (MouseListener[])(getListeners(MouseListener.class));
		for(int i=0 ; i<ml.length ; i++)
			removeMouseListener(ml[i]);
		for(int i=0 ; i<mml.length ; i++)
			removeMouseMotionListener(mml[i]);
	} 

	public void changecouleur (Color c){
		figureSelection().changeCouleur(c);
	}

	public class ManipulateurFormes implements MouseListener,
	MouseMotionListener {

		private int indice;
		private UnPoint p;
		private DessinFigures d;
		private Color c;
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(SwingUtilities.isRightMouseButton(e)){
				DessinFigures dess = (DessinFigures)e.getSource();
				removeMouseMotionListener(this);
				removeMouseListener(this);
				repaint();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (SwingUtilities.isLeftMouseButton(e)){
				for (int i =0; i<nbf; i++ ){
					if (figures[i].estPres(e.getX(), e.getY())){
						if (sel != i){
							figures[sel].deSelectionne();
							figures[i].selectionne();
							sel = i;
						}
					}
				}
				this.indice = figures[sel].pointProxi(e.getX(), e.getY());
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if (SwingUtilities.isLeftMouseButton(e) && figures[sel].estPres(e.getX(), e.getY())){

				int dx = e.getX() - figures[sel].gettab()[indice].rendreX();
				int dy = e.getY() - figures[sel].gettab()[indice].rendreY();
				figures[sel].translation(dx, dy);
				figures[sel].gettab()[indice]= new UnPoint(e.getX(), e.getY());
			}

			repaint();

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}



	};


}
