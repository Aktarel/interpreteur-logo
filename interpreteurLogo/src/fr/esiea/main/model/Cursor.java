package fr.esiea.main.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import fr.esiea.main.ihm.IDrawable;

/**
 * 
 * Notre curseur est un singleton pour pouvoir être rappelé sans avoir a en crée un nouveau
 * @author lebec
 *
 */

public class  Cursor implements IDrawable {

	private Point position;
	private float orientation;
	private static Cursor instance;

	public static Cursor getInstance() {
		if (null == instance) { // Premier appel

			instance = new Cursor();
		}

		return instance;

	}

	private Cursor() {
		;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public float getOrientation() {
		return orientation;
	}

	public void setOrientation(float orientation) {
		this.orientation = orientation;
	}

	@Override
	public void draw(Graphics g) {

		Shape circle = new Ellipse2D.Float(position.x-10f,position.y-10f,20f,20f);
		
		Graphics2D g2 = (Graphics2D) g;
	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	        RenderingHints.VALUE_ANTIALIAS_ON);
	    g2.setPaint(Color.green);
	    
		double longueurHypo = 10;
		
		
		double coordonneArriveX = longueurHypo * Math.cos(Math.PI*orientation/180);
		double coordonneArriveY = longueurHypo * Math.sin(Math.PI*orientation/180);
		
	    g2.draw(new Line2D.Double(position, new Point(position.x+(int)coordonneArriveX,position.y+(int)coordonneArriveY)));
	    
	    final BasicStroke dashed =   new BasicStroke(2f);
	    g2.setStroke(dashed);
	    g2.draw(circle);
		
		
	}
	

}
