package interpreteur;

import java.awt.Point;

import fr.esiea.main.ihm.LigneDrawable;
import fr.esiea.main.ihm.PanneauDessin;
import fr.esiea.main.model.Cursor;

public class REPrimitive implements Primitive{
	
	
	private PanneauDessin panneauDessin;
	
	public REPrimitive(PanneauDessin panneauDessin) {
		
		this.panneauDessin = panneauDessin;
		
	}
	
	@Override
	public void execute(Interpreteur i, Object arg) {

		Cursor curs = Cursor.getInstance();
		float angle = curs.getOrientation();
		double longueurHypo = new Double(String.valueOf(arg));
		double coodronneArriveX = longueurHypo * Math.cos(Math.PI*angle/180);
		double coodronneArriveY = longueurHypo * Math.sin(Math.PI*angle/180);
		
		Point pointArrive;
		Point coordonnesDepart = curs.getPosition();
		
		int couleur = PanneauDessin.couleurComposant;
		
		pointArrive = new Point(coordonnesDepart.x
				+ (int) coodronneArriveX * -1,
				coordonnesDepart.y + (int) coodronneArriveY
						* -1);
		panneauDessin.addDrawable(new LigneDrawable(
				coordonnesDepart, pointArrive,couleur));
		curs.setPosition(pointArrive);

	}
	
	
	
}
