import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;


public class TraceurForme implements MouseListener, MouseMotionListener{

	private int lastx;
	private int lasty;
	private Graphics g;
	private Color col ;
	public TraceurForme(Graphics r, Color c){
		g = r ;
		lastx = 0 ;
		lasty = 0 ;
		col = c ;

	}





	public void mouseClicked(MouseEvent e) {
		if ( SwingUtilities.isRightMouseButton(e)){
			((DessinFigures) e.getSource()).removeMouseListener(this);
			((DessinFigures) e.getSource()).removeMouseMotionListener(this);
			((DessinFigures) e.getSource()).repaint();
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		if ( SwingUtilities.isLeftMouseButton(e)){
			lastx=e.getX();
			lasty=e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {


	}

	@Override
	public void mouseEntered(MouseEvent e) {


	}

	@Override
	public void mouseExited(MouseEvent e) {

	}



	@Override
	public void mouseDragged(MouseEvent e) {
		if ( SwingUtilities.isLeftMouseButton(e)){
			g.setColor(col);
			g.drawLine(lastx, lasty, e.getX(), e.getY());
			lastx=e.getX();
			lasty=e.getY();
		}
	

	}

	@Override
	public void mouseMoved(MouseEvent e) {


	}


}

