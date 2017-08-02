package interpreteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.esiea.main.grammaire.FonctionLogo;
import fr.esiea.main.grammaire.OperationLogo;
import fr.esiea.main.ihm.PanneauDessin;

public class Interpreteur {

	private Map<String, Primitive> primitives;

	public Interpreteur(PanneauDessin pan) {

		primitives = new HashMap<String, Primitive>();
		primitives.put("TD", new TDPrimitive(pan));
		primitives.put("TG", new TGPrimitive(pan));
		primitives.put("AV", new AVPrimitive(pan));
		primitives.put("RE", new REPrimitive(pan));
		primitives.put("FCC", new FCCPrimivite(pan));
	}

	public void interprete(List<Object> programme) {

		for (int i = 0; i < programme.size(); i++) {

			OperationLogo op = null;
			Object o = programme.get(i);
			if (o.getClass().equals(OperationLogo.class) || programme.contains(OperationLogo.class)) {
				op = (OperationLogo) o;
				programme.remove(o);
				i--;
			}

			if (op != null) {
				for (int j = 0; j < op.getNombre(); j++) {
					for (int k = 0; k < programme.size(); k++) {
						List<FonctionLogo> l = (List<FonctionLogo>) programme
								.get(k);
						for (FonctionLogo f : l) {
							Primitive p = primitives.get(f.getNom());
							p.execute(this, f.getArgument());
						}
					}
				}

			}
			else{
				if(programme.get(i).getClass().equals(ArrayList.class)){
					ArrayList al = (ArrayList) programme.get(i);
					FonctionLogo fl = (FonctionLogo) al.get(0);;
					Primitive p = primitives.get(fl.getNom());
					p.execute(this, fl.getArgument());
				}
				else{
				FonctionLogo fl = (FonctionLogo) programme.get(i);
				Primitive p = primitives.get(fl.getNom());
				p.execute(this, fl.getArgument());
				}
				
			}
				

		}

	}

}
