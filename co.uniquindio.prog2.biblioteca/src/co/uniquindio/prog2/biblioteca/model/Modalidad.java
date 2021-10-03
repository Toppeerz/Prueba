package co.uniquindio.prog2.biblioteca.model;

public enum Modalidad {

	PRESENCIAL(0),DISTANCIA(1);

	private int modalidad;

	private Modalidad(int numModalidad) {
		this.modalidad = numModalidad;
	}

	public int getModalidad() {
		return modalidad;
	}



}
