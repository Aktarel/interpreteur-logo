package fr.esiea.main.ihm;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.StringReader;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.esiea.main.grammaire.LogoGram;
import fr.esiea.main.grammaire.ParseException;
import fr.esiea.main.model.Cursor;


public class PanneauInterpreteur extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea champsCommande;
	private JLabel titrePanel,infoAngle;
	private JButton submitCommande;
	private GridBagLayout gridBag;
	private GridBagConstraints contraintes;
	private	LogoGram parser ;
	private StringReader reader;
	private Font f ;
	
	public PanneauInterpreteur() {

		initialisation();
		configuration();
		
		
	}

	private void initialisation() {
		f = new Font("Tahoma", Font.BOLD, 16);
		gridBag = new GridBagLayout();
		contraintes = new GridBagConstraints();
		champsCommande = new JTextArea(3,20);
		submitCommande = new JButton("Valider");
		titrePanel = new JLabel("Panneau interpreteur Logo");
		reader = new StringReader("");
		parser = new LogoGram(reader);
		infoAngle = new JLabel("Angle de ");
	}

	private void configuration() {
		
		titrePanel.setFont(f);
		
		setLayout(gridBag);
		
		submitCommande.addActionListener(this);
		
		contraintes.insets = new Insets(10, 10, 10, 100);
	    contraintes.gridx=0;
	    contraintes.gridy=2;
	    contraintes.gridwidth=1;
	    add(infoAngle,contraintes);
		
		contraintes.insets = new Insets(10, 10, 10, 10);
	    contraintes.gridx=1;
	    contraintes.gridy=0;
	    contraintes.gridwidth=3;
	    add(titrePanel,contraintes);
		
	    
	    contraintes.insets = new Insets(10, 10, 10, 10);
	    contraintes.gridx=1;
	    contraintes.gridy=1;
	    contraintes.gridwidth=2;
	    add(champsCommande,contraintes);
	    
	    champsCommande.setText(" x=100 y=90 n=4 couleur=5 ;\n FCC :couleur REPETE :n [ AV :x TD :y ]");
	    
	    contraintes.insets = new Insets(10, 10, 10, 10);
	    contraintes.gridx=1;
	    contraintes.gridy=2;
	    contraintes.gridwidth=3;
	    add(submitCommande,contraintes);
	    
	
	    
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submitCommande){
			
			String s = champsCommande.getText();
			reader = new StringReader(s);
			parser.ReInit(reader);
			List<Object> liste = null;
			
			try {
				liste = parser.Programme();
			} catch (ParseException e1) {
				JOptionPane.showMessageDialog(null, "Erreur de parsing", "La synthaxe que vous utilisez n'est pas reconnue", JOptionPane.ERROR_MESSAGE);
				e1.printStackTrace();
			}
			
			FenetrePrincipale f = (FenetrePrincipale) getTopLevelAncestor();
			f.ajouterLignes(liste);
			
			infoAngle.setText("Angle de "+Cursor.getInstance().getOrientation());
			getTopLevelAncestor().repaint();
		}
		
	}
}
