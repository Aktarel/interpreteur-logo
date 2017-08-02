package fr.esiea.main.ihm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sun.audio.AudioData;

public class BarreMenu extends JMenuBar implements ActionListener {
	
	private List<JMenuItem> items = new ArrayList<JMenuItem>();
	private List<JMenu> menus = new ArrayList<JMenu>();
	
	public BarreMenu() {
	
		initialisation();
	
	}
	
	private void initialisation(){
		
		JMenu menu1 = new JMenu("Fichier");
		JMenu menu2 = new JMenu("Options");
		
		JMenuItem item = new JMenuItem("Aide");
		JMenuItem item2 = new JMenuItem("A propos");
		JMenuItem item3 = new JMenuItem("Quitter");
		
		items.add(item);
		items.add(item2);
		items.add(item3);
		
		menu2.add(item);
		menu2.add(item2);
		
		menu1.add(item3);
		
		menus.add(menu1);
		menus.add(menu2);

		add(menu1);
		add(menu2);
			
		for(JMenuItem unItem : items)
			unItem.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==items.get(0)){
			StringBuffer sb = new StringBuffer();
		
				Clip clip = null;
				AudioInputStream ais;
				try {
					ais = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource("queen.wav"));
					Line.Info linfo = new Line.Info(Clip.class);
				    Line line = AudioSystem.getLine(linfo);
				    clip = (Clip) line;
					clip.open(ais);
				    clip.start();
			
				} catch (UnsupportedAudioFileException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LineUnavailableException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			
			
			sb.append("<HTML><h1><center>Aide</center></h1>");
			sb.append("<br>");
			sb.append("<h2>Objectif</h2>");
			sb.append("<p>Mettre en place un traducteur Logo en Java dans le cadre du cours de <br> François Dechelle, professeurde compilation à l'ESIEA</p>");
			sb.append("<h2>Qu'est ce que Logo ?</h2>");
			sb.append("<p>C'est un language de programmation à but pédagogique permettant de <br> dessiner des formes et à initierles plus débutants à la programmation</p>");
			sb.append("<h2>Fontions de base</h2>");
			sb.append("<ul><li>AV <Nombre> permet de faire avancer le curseur de <NOMBRE> pixel</li>");
			sb.append("<li>RE n permet de faire reculer le curseur de <NOMBRE> pixel</li>");
			sb.append("<li>TG n permet de tourner le curseur à gauche de n degrés</li>");
			sb.append("<li>TD n permet de tourner le curseur à droite de n degrés</li>");
			sb.append("<li>FCC n permet de changer de couleur (n compris entre 1 à 10)</li>");
			sb.append("</ul>");
			sb.append("<h2>Operation implementé</h2>");
			sb.append("<p>REPETE n [ mesExpressions ] permet de repeter n fois une une liste d'opération </p>");
			sb.append("<h2>Déclaration de variable</h2>");
			sb.append("<p> Il est possible de déclarer une variable et de lui affecter une valeur (ex : x=15) <br> en remplacement le nombre par :nomvariable. Pensez à terminer la déclaration par un point virgule! </p>");
			sb.append("</HTML>");
			JOptionPane.showMessageDialog(getRootPane(), sb.toString(),"Aide",JOptionPane.PLAIN_MESSAGE,new ImageIcon(ClassLoader.getSystemResource("fred.jpg")));
		}
		if(e.getSource()==items.get(1)){
			
			JOptionPane.showMessageDialog(getRootPane(), "<HTML></br><p>Ce projet a été réalisé par deux étudiants passionés de l'ESIEA <br> dans le cadre du cours de compilaton de <a href='http://www.dechelle.net/' >M. Dechelle</a> : <ul><li>Remy OUADAH</li><li>Nicolas LEBEC</li></ul></br> Les outils employés sont : <ul><li>JavaCC</li><li>JDK 1.7</li></ul></p></HTML>","L'équipe",JOptionPane.PLAIN_MESSAGE,new ImageIcon(ClassLoader.getSystemResource("esiea.png")));
			
		}
		if(e.getSource()==items.get(2)){
			System.exit(0);
		}
	}


	

}
