package fr.esiea.main.ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PanneauDessin extends JPanel {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static int couleurComposant=5;
	
	
	// Source developpez.com
	private List drawables = new LinkedList();
	
	
	public PanneauDessin() {
		
		initialisation();
		configuration();
		
	}

	private void initialisation() {
		
			try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void configuration() {
		
		setPreferredSize(new Dimension(500,500));
	}
	
	public void paint(Graphics g) {
		
		
		for (Iterator iter = drawables.iterator(); iter.hasNext();) {
			IDrawable d = (IDrawable) iter.next();
			d.draw(g);	
		}
	
		
	}

	public void addDrawable(IDrawable d) {
		drawables.add(d);
		repaint();
	}

	public void removeDrawable(IDrawable d) {
		drawables.remove(d);
		repaint();
	}

	public void clear() {
		drawables.clear();
		repaint();
	}

	

}
