package interpreteur;

import java.awt.Point;

import fr.esiea.main.ihm.LigneDrawable;
import fr.esiea.main.ihm.PanneauDessin;
import fr.esiea.main.model.Cursor;



/**
 * 
 * 
 * @author lebec
 * AV primitive est la classe utilisée pour tracer une droite
 *
 */
public class AVPrimitive implements Primitive {

	private PanneauDessin panneauDessin;
	
	/**
	 * Constructeur - Permet de tracer une droite si .execute(interpreteur, +argument)
	 * @param panneauDessin - obejt necessaire pour tracer dans le composant
	 */
	public AVPrimitive(PanneauDessin panneauDessin) {
		
		this.panneauDessin = panneauDessin;
		
	}
	
	/**
	 * 
	 * @param arg : est de type objet, represente un int de combien avance le curseur
	 */
	public void execute(Interpreteur i, Object arg) {
		
		Cursor curs = Cursor.getInstance();
		float angle = curs.getOrientation();
		double longueurHypo = new Double(String.valueOf(arg));
		double coodronneArriveX = longueurHypo * Math.cos(Math.PI*angle/180);
		double coodronneArriveY = longueurHypo * Math.sin(Math.PI*angle/180);
		
		int couleur= panneauDessin.couleurComposant;
		
		Point pointArrive;
		Point coordonnesDepart = curs.getPosition();
		

		pointArrive = new Point(coordonnesDepart.x
				+ (int) coodronneArriveX, coordonnesDepart.y
				+ (int) coodronneArriveY);
		
		//On dessine la ligne
		panneauDessin.addDrawable(new LigneDrawable(
				coordonnesDepart, pointArrive,couleur));
		curs.setPosition(pointArrive);
		
		
		//On dessine notre curseur
		panneauDessin.addDrawable(curs);

		
	}

}
