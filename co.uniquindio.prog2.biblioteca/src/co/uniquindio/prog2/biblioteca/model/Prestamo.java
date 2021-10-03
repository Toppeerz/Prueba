package co.uniquindio.prog2.biblioteca.model;

public class Prestamo {


	private String fechaPrestamo;
	private String codigo;
	private String fechaDevolucion;

	private Estudiante estudiante;
	
	private Bibliotecario bibliotecario;

	private DetallePrestamo detallePrestamo1;
	private DetallePrestamo detallePrestamo2;

	/**
	 * ESte es el metodo constructor
	 * @param fechaPrestamo
	 * @param codigo
	 * @param fechaDevolucion
	 * @param libro1
	 * @param libro2
	 * @param estudiante
	 * @param bibliotecario
	 */
	public Prestamo(String fechaPrestamo, String codigo, String fechaDevolucion,
			Estudiante estudiante, Bibliotecario bibliotecario) {
		this.fechaPrestamo = fechaPrestamo;
		this.codigo = codigo;
		this.fechaDevolucion = fechaDevolucion;
		this.estudiante = estudiante;
		this.bibliotecario = bibliotecario;
	}

	public Prestamo(String fechaPrestamo, String codigo, String fechaDevolucion) {
		this.fechaPrestamo = fechaPrestamo;
		this.codigo = codigo;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Prestamo() {

	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}


	public DetallePrestamo getDetallePrestamo1() {
		return detallePrestamo1;
	}

	public void setDetallePrestamo1(DetallePrestamo detallePrestamo1) {
		this.detallePrestamo1 = detallePrestamo1;
	}

	public DetallePrestamo getDetallePrestamo2() {
		return detallePrestamo2;
	}

	public void setDetallePrestamo2(DetallePrestamo detallePrestamo2) {
		this.detallePrestamo2 = detallePrestamo2;
	}



	public boolean verificarEstudiante(String nombre) {

		boolean estudianteVerificado = false;
		if(estudiante != null) {
			estudianteVerificado = estudiante.verificarNombre(nombre);
			if(estudianteVerificado == true) {
				return true;
			}
		}

		return false;
	}

	//----------------------------------------------------------------------
	//1.0 Consultar la cantidad de libros de la editorial “Uniquindio”
		//que han sido prestados  en la biblioteca y su título empiece por una vocal.
	public int obtenerCantidadLibrosEditorial(String editorial) {

		int cantidad = 0;

		if(detallePrestamo1 != null){
			cantidad += detallePrestamo1.obtenerCantidadLibrosEditorialVocal(editorial);
		}
		if(detallePrestamo2 != null){
			cantidad += detallePrestamo2.obtenerCantidadLibrosEditorialVocal(editorial);
		}
		return cantidad;
	}
		public boolean obtenerPrestamoEstudiantesP2(Modalidad modalidad) 
		{boolean verificado=false;
	       if(estudiante != null)
	       {
	    	verificado=estudiante.verificarEstudiantesDistancia(modalidad) ;  
	       }
	return verificado; 
	}
}




