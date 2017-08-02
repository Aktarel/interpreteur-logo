package fr.esiea.main.ihm;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

public class LigneDrawable implements IDrawable {

	
	protected Point coordonneDepart;
	protected Point coordonneArrive;
	protected int couleur;
	
	public LigneDrawable(Point depart,Point arrive, int couleur) {
		
		this.coordonneArrive=arrive;
		this.coordonneDepart=depart;
		this.couleur = couleur;
	}
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        RenderingHints.VALUE_ANTIALIAS_ON);
	    
	    
	    switch (couleur) {
		case 1:
			g2.setPaint(Color.black);
			break;
		case 2:
			g2.setPaint(Color.darkGray);
			break;
		case 3:
			g2.setPaint(Color.LIGHT_GRAY);
			break;
		case 4:
			g2.setPaint(Color.white);
			break;
		case 5:
			g2.setPaint(Color.BLUE);
			break;
		case 6:
			g2.setPaint(Color.cyan);
			break;
		case 7:
			g2.setPaint(Color.yellow);
			break;
		case 8:
			g2.setPaint(Color.green);
			break;
		case 9:
			g2.setPaint(Color.red);
			break;
		case 10:
			g2.setPaint(Color.ORANGE);
			break;
		case 11:
			g2.setPaint(Color.MAGENTA);
			break;
		default:
			g2.setPaint(Color.black);
			break;
		}
	    
	    
	    
	    final BasicStroke dashed =   new BasicStroke(3f);
	    g2.setStroke(dashed);
	    g2.draw(new Line2D.Double(coordonneDepart.x, coordonneDepart.y, coordonneArrive.x, coordonneArrive.y));
		
		
	}

	public Point getCoordonneDepart() {
		return coordonneDepart;
	}

	public void setCoordonneDepart(Point coordonneDepart) {
		this.coordonneDepart = coordonneDepart;
	}

	public Point getCoordonneArrive() {
		return coordonneArrive;
	}

	public void setCoordonneArrive(Point coordonneArrive) {
		this.coordonneArrive = coordonneArrive;
	}
	

}
