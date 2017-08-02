package interpreteur;

import java.awt.Point;

import fr.esiea.main.ihm.LigneDrawable;
import fr.esiea.main.ihm.PanneauDessin;
import fr.esiea.main.model.Cursor;

public class FCCPrimivite implements Primitive {

	
	private PanneauDessin panneauDessin;
	
	public FCCPrimivite(PanneauDessin panneauDessin) {
		
		this.panneauDessin = panneauDessin;
		
	}
	@Override
	public void execute(Interpreteur i, Object arg) {
		panneauDessin.couleurComposant=((Integer) arg);
	}

}
