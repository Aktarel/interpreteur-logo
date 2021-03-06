package interpreteur;

import fr.esiea.main.ihm.PanneauDessin;
import fr.esiea.main.model.Cursor;

public class TGPrimitive implements Primitive {

	private PanneauDessin panneauDessin;
	
	public TGPrimitive(PanneauDessin panneauDessin) {
		
		this.panneauDessin = panneauDessin;
		
	}
	@Override
	public void execute(Interpreteur i, Object arg) {
		
		float argument = new Float(String.valueOf(arg));
		
		Cursor curs = Cursor.getInstance();
		float angle = curs.getOrientation();
		curs.setOrientation(angle - argument);
		
		panneauDessin.addDrawable(curs);

	}

}
