import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;


public class FabricantFigure implements MouseListener {
	
	private int nbclick ;
	private UnPoint psaisie[];
	private FigureColoree fc ;
	
	
	public FabricantFigure(FigureColoree figure){
		fc = figure;
		int taille = figure.nbPointsSaisie();
		psaisie = new UnPoint[taille];
		nbclick = 0;
	}

	
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)){
			ajoutePoints(e.getX(), e.getY());
		}
		if (nbclick == psaisie.length){
			fc.modifierPoints(psaisie);
			DessinFigures dess = (DessinFigures)e.getSource();
			dess.ajoute(fc);
			dess.repaint();
			dess.removeMouseListener(this);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void ajoutePoints(int x, int y){
		UnPoint p = new UnPoint(x, y);
		psaisie[nbclick] = p ;
		nbclick++;
	}
	

}
