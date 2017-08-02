package fr.esiea.main.grammaire;

public class FonctionLogo {

	private String nom;
	private Integer argument;
	
	public FonctionLogo(String nom,int argument) {
	
		this.nom=nom;
		this.argument=argument;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getArgument() {
		return argument;
	}

	public void setArgument(Integer argument) {
		this.argument = argument;
	}
	
	@Override
	public String toString() {
		return "Fonction "+nom +" "+argument;
	}
	
	
}
