package fr.esiea.main.grammaire;


public class OperationLogo  {

	private String operation;
	private int nombre;
    
    public OperationLogo(String operation, int nombre) {

    	this.setOperation(operation);
    	this.setNombre(nombre);
    
    }

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getOperation() {
		return operation;
	}
    
    
	

}
