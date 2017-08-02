package fr.esiea.main.ihm;

import interpreteur.Interpreteur;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import fr.esiea.main.grammaire.FonctionLogo;
import fr.esiea.main.grammaire.OperationLogo;
import fr.esiea.main.model.Cursor;

public class FenetrePrincipale extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanneauInterpreteur panneauInterpreteur;
	private PanneauDessin panneauDessin;
	private JPanel panneauNord;
	private JPanel panneauSud;
	private BarreMenu menubar;
	private Interpreteur interpreteur;

	private Point coordonnesDepart = new Point(250, 250);

	public FenetrePrincipale(String titre) {

		super(titre);
		initialisation();
		configuration();

	}

	private void initialisation() {

		panneauInterpreteur = new PanneauInterpreteur();
		panneauDessin = new PanneauDessin();
		panneauNord = new JPanel();
		panneauSud = new JPanel(new BorderLayout());
		menubar = new BarreMenu();
		interpreteur = new Interpreteur(panneauDessin);

	}

	private void configuration() {

		setIconImage(new ImageIcon(this.getClass().getResource("/tortue.png"))
				.getImage());

		// Panels
		panneauNord.add(panneauDessin);
		panneauSud.add(panneauInterpreteur, BorderLayout.CENTER);

		// Fenetre principale
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(400, 450);

		add(panneauNord, BorderLayout.NORTH);
		add(new JSeparator(), BorderLayout.CENTER);
		add(panneauSud, BorderLayout.SOUTH);

		Cursor cursor = Cursor.getInstance();
		cursor.setOrientation(0);
		cursor.setPosition(coordonnesDepart);

		setJMenuBar(menubar);

		pack();
		setLocationRelativeTo(getParent());
	}

	public void ajouterLignes(List<Object> liste) {

		HashMap<String, Integer> variables = null;
		
		
		//Extraction de la map
		for(int i=0;i<liste.size();i++){
			if(liste.get(i).getClass().equals(HashMap.class)){
				variables = (HashMap<String, Integer>) liste.get(i);
				liste.remove(i);
			}
		}
		
		// Lecture des listes de listes
		for (Object o : liste) {

			// On a une liste de fonction
			// REPETE 4 [ AV 100 RE 100]
			ArrayList<Object> obj = (ArrayList<Object>) o;
			interpreteur.interprete(obj);

		}

	}

}
