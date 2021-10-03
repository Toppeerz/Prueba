package co.uniquindio.prog2.biblioteca.model;

public class DetallePrestamo {


	private int cantidad;
	private Libro libro;


	public DetallePrestamo(int cantidad, Libro libro) {
		super();
		this.cantidad = cantidad;
		this.libro = libro;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	@Override
	public String toString() {
		return "DetallePrestado [cantidad=" + cantidad + ", libro=" + libro + "]";
	}

	//1.0 Consultar la cantidad de libros de la editorial “Uniquindio”
		//que han sido prestados  en la biblioteca y su título empiece por una vocal.
	public int obtenerCantidadLibrosEditorialVocal(String editorial) {

		int cantidad =0;
		boolean verificado = false;

		if(libro != null){
			verificado = libro.verificarEditorialLetraVocal(editorial);
			if(verificado == true){
				cantidad = this.cantidad;
			}
		}
		return cantidad;
	
	}
    
    
}
