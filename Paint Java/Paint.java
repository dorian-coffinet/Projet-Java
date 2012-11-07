import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Paint extends JFrame{




	//Menu ________________________
	private JMenuBar menuBar = new JMenuBar();
	JMenu figure = new JMenu ("Figure");
	JMenu dml = new JMenu ("Dessin");
	JMenu couleur = new JMenu("Couleur");
	JMenu aide_m = new JMenu("Aide");

	JMenuItem triangle = new JMenuItem("Triangle");
	JMenuItem cercle = new JMenuItem("Cercle");
	JMenuItem rectangle = new JMenuItem("Rectangle");
	JMenuItem quadrilatere = new JMenuItem("Quadrilatere");

	JMenuItem rouge = new JMenuItem("Rouge");
	JMenuItem vert = new JMenuItem("Vert");
	JMenuItem bleu = new JMenuItem("Bleu");
	JMenuItem jaune = new JMenuItem("Jaune");
	JMenuItem panel = new JMenuItem("Panel de couleur");

	JMenuItem dessin = new JMenuItem("Dessin main levée");

	JMenuItem aide_mi = new JMenuItem("Afficher l'aide");
	JMenuItem aide_auteur = new JMenuItem("A propos de paint");

	//Boutons radio _______________________

	JRadioButton b1 = new JRadioButton("Dessin Figure");
	JRadioButton b2 = new JRadioButton("Manipulation figure");
	JRadioButton b3 = new JRadioButton("Dessin main levé");

	ButtonGroup bg = new ButtonGroup();



	//Barre Outils


	JToolBar toolBar = new JToolBar();

	JButton 
	circle = new JButton(new ImageIcon("/paint_image/cercle_i.jpg")),
	rec = new JButton(new ImageIcon("/paint_image/rec_i.jpg")),
	quadri = new JButton(new ImageIcon("/paint_image/quadri_i.jpg")),
	tri = new JButton(new ImageIcon("/paint_image/tri_i.jpg")),

	color_tb = new JButton(new ImageIcon("/paint_image/color_tb.jpg")),
	dessin_tb = new JButton(new ImageIcon("/paint_image/dessin_tb.jpg")),
	manip_tb = new JButton(new ImageIcon("/paint_image/manip_tb.jpg")),
	aide = new JButton(new ImageIcon("/paint_image/aide.jpg"));
	
	


	private FigureListener fListener = new FigureListener();
	private DessinListener dListener = new DessinListener();
	private CouleurListener cListener = new CouleurListener();
	private MoveListener mListener = new MoveListener();
	private DefaultListener DListener = new DefaultListener();

	private DessinFigures d= new DessinFigures();
	private Color c = Color.BLACK;
	JPanel PanneauChoix = new JPanel();



	public Paint(){
		setSize(700,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initMenu();
		this.initToolBar();
		this.initAide();
		d.setBackground(Color.WHITE);
		this.getContentPane().add(d, BorderLayout.CENTER);
		this.getContentPane().add(PanneauChoix, BorderLayout.SOUTH);
		this.getContentPane().add(toolBar,BorderLayout.NORTH);
		this.setVisible(true);
		assistant();

	}

	private void initMenu(){
		figure.add(triangle);
		triangle.addActionListener(fListener);
		figure.add(cercle);
		cercle.addActionListener(fListener);
		figure.add(rectangle);
		rectangle.addActionListener(fListener);
		figure.add(quadrilatere);
		quadrilatere.addActionListener(fListener);

		dml.add(dessin);
		dessin.addActionListener(dListener);

		couleur.add(rouge);
		rouge.addActionListener(cListener);
		couleur.add(vert);
		vert.addActionListener(cListener);
		couleur.add(bleu);
		bleu.addActionListener(cListener);
		couleur.add(jaune);
		jaune.addActionListener(cListener);
		couleur.add(panel);
		panel.addActionListener(cListener);

		aide_m.add(aide_mi);
		aide_mi.addActionListener(DListener);
		aide_m.add(aide_auteur);
		aide_auteur.addActionListener(DListener);
		
		
		menuBar.add(figure);
		menuBar.add(couleur);
		menuBar.add(dml);
		menuBar.add(aide_m);

		setJMenuBar(menuBar);
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		PanneauChoix.add(b1);
		PanneauChoix.add(b2);
		PanneauChoix.add(b3);

		b1.setSelected(true);
		b2.addActionListener(mListener);
		b3.addActionListener(dListener);
		
		
		

		PanneauChoix.setBackground(Color.GRAY);


	}


	private void initToolBar(){



		circle.addActionListener(fListener);
		rec.addActionListener(fListener);
		tri.addActionListener(fListener);
		quadri.addActionListener(fListener);

		color_tb.addActionListener(cListener);
		dessin_tb.addActionListener(dListener);
		manip_tb.addActionListener(mListener);
		aide.addActionListener(DListener);
		
		toolBar.add(circle);
		toolBar.add(quadri);
		toolBar.add(rec);
		toolBar.add(tri);

		toolBar.addSeparator();

		toolBar.add(color_tb);

		toolBar.addSeparator();

		toolBar.add(dessin_tb);

		toolBar.addSeparator();

		toolBar.add(manip_tb);
		
		toolBar.addSeparator();

		toolBar.add(aide);
		
	}

	
	private void initAide(){
		
		cercle.setToolTipText("2 points , définissant le diamètre");
		circle.setToolTipText("2 points , définissant le diamètre");
		
		rec.setToolTipText("2 points , définissant la diagonale");
		rectangle.setToolTipText("2 points , définissant la diagonale");
		
		tri.setToolTipText("3 points , définissant les sommets");
		triangle.setToolTipText("3 points , définissant les sommets");
		
		quadri.setToolTipText("4 points , définissant les sommets");
		quadrilatere.setToolTipText("4 points , définissant les sommets");
		
		manip_tb.setToolTipText("Manipulations d'une figure");
		
		
	}
	
	
	public void assistant(){
		JOptionPane.showMessageDialog( 
				d, 
				"<html>" +
				"<center><font color=blue size=+2>Comment utiliser paint : </font></center>" +
				"<dl><dt><em>Dessiner une figure</em></dt><dd><p>Cercle 2 point de saisie<br /> Triangle 3 sommet<br /> Rectangle diagonale </p></dd>" +
				"<dt><em>Manipuler une figure</dt></em><dd>Cliquer sur la figure puis déplacer</dd><" +
				"dt><em>Dessiner à main levée</dt></em><dd>Clic gauche pour dessiner , clic droit pour effacer votre oeuvre</dd>" +
				"</dl>" +
				"Vous pouvre retrouver cette aide à tous moments en clicquant sur l'icone d'aide"+
				"</html>",  
				"Aide", 
				JOptionPane.INFORMATION_MESSAGE) ;
	}
	
	
	
	
	class FigureListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			d.casseLien();

			if ( e.getSource()==tri || e.getSource()==triangle ){
				b1.setSelected(true);
				FigureColoree f = new UnTriangle();
				f.changeCouleur(c);
				d.construit(f);
			} 
			if (e.getSource()==rec || e.getSource()==rectangle){
				b1.setSelected(true);
				FigureColoree f = new UnRectangle();
				f.changeCouleur(c);
				d.construit(f);

			}
			if (e.getSource()==circle || e.getSource()==cercle){
				b1.setSelected(true);
				FigureColoree f = new UnCercle();
				f.changeCouleur(c);
				d.construit(f);

			}
			if (e.getSource()==quadri || e.getSource()==quadrilatere){
				b1.setSelected(true);
				FigureColoree f = new UnQuadrilatere();
				f.changeCouleur(c);
				d.construit(f);
			}
			
		}
	}


	class DessinListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			d.casseLien();
			if (b3.isSelected() || e.getSource()==dessin || e.getSource()==dessin_tb){
				b3.setSelected(true);
				JOptionPane.showMessageDialog( 
						d, 
						"Clic Gauche pour dessiner," +
						"Clic droit pour effacer", 
						"Aide", 
						JOptionPane.INFORMATION_MESSAGE) ;
				d.trace(c);

			}	
			
		}
	}

	class CouleurListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==rouge){
				c = Color.RED;
			}else if (e.getSource()==vert){
				c = Color.GREEN;
			}else if (e.getSource()==jaune){
				c = Color.YELLOW;
			}else if (e.getSource()==bleu){
				c = Color.BLUE;
			}else if (e.getSource()==panel || e.getSource()==color_tb){
				Color c_panel= JColorChooser.showDialog(null,
						"Panel de couleur", null);
				c = c_panel;
			}
		}	

	}

	class MoveListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			d.casseLien();
			if (b2.isSelected() || e.getSource()==manip_tb){
				if (d.nbFigures()==0){
					JOptionPane.showMessageDialog( 
							d, 
							"Aucune figure créée",
							"Warning", 
							JOptionPane.WARNING_MESSAGE) ;
				}else{
					b2.setSelected(true);
					d.activeManipulationsSouris();
				}

			}	
			

		}
	}

	class DefaultListener implements ActionListener{

	
		public void actionPerformed(ActionEvent e) {
	
			if(e.getSource() == aide || e.getSource() == aide_mi){
				assistant();
			}
			if(e.getSource()== aide_auteur){
				JOptionPane.showMessageDialog( 
						d, 
						"<html><p>Réalisé par COFFINET Dorian et DUHAUT Anne-Sophie </p>" +
						" <p>Année 2010/2011, S2bis </p></html>", 
						"A propos de Paint", 
						JOptionPane.INFORMATION_MESSAGE) ;
			}
		}
		
	}
	

	
	public static void main(String[] args){
		Paint p = new Paint();
	}
}
