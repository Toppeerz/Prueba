package co.uniquindio.prog2.biblioteca.model;


/**
 * Clase Biblioteca
 * @author Admin
 *
 */
public class Biblioteca {

	//------------LISTA DE ATRIBUTOS
	private String nombre;// encapsulamiento
	private String direccion;

	private Libro libro1;
	private Libro libro2;

	private Prestamo prestamo1;
	private Prestamo prestamo2;

	private Estudiante estudiante1;
	private Estudiante estudiante2;

	private Bibliotecario bibliotecario;
	//-----------------------------

	/**
	 * Metodo constructor de la clase Biblioteca
	 * @param nombre
	 * @param direccion
	 */
	public Biblioteca(String nombre,String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}




	public Biblioteca() {

	}


	/**
	 * Metodo get del atributo nombre
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo set del atributo nombre
	 * @return
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo get del atributo direccion
	 * @return
	 */
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Libro getLibro1() {
		return libro1;
	}

	public void setLibro1(Libro libro1) {
		this.libro1 = libro1;
	}

	public Libro getLibro2() {
		return libro2;
	}

	public void setLibro2(Libro libro2) {
		this.libro2 = libro2;
	}

	public Prestamo getPrestamo1() {
		return prestamo1;
	}

	public void setPrestamo1(Prestamo prestamo1) {
		this.prestamo1 = prestamo1;
	}

	public Prestamo getPrestamo2() {
		return prestamo2;
	}

	public void setPrestamo2(Prestamo prestamo2) {
		this.prestamo2 = prestamo2;
	}

	public Estudiante getEstudiante1() {
		return estudiante1;
	}

	public void setEstudiante1(Estudiante estudiante1) {
		this.estudiante1 = estudiante1;
	}

	public Estudiante getEstudiante2() {
		return estudiante2;
	}

	public void setEstudiante2(Estudiante estudiante2) {
		this.estudiante2 = estudiante2;
	}

	public Bibliotecario getBibliotecario() {
		return bibliotecario;
	}

	public void setBibliotecario(Bibliotecario bibliotecario) {
		this.bibliotecario = bibliotecario;
	}

	@Override
	public String toString() {
		return "Biblioteca [nombre=" + nombre + ", direccion=" + direccion + ", libro1=" + libro1 + ", libro2=" + libro2
				+ ", prestamo1=" + prestamo1 + ", prestamo2=" + prestamo2 + ", estudiante1=" + estudiante1
				+ ", estudiante2=" + estudiante2 + ", bibliotecario=" + bibliotecario + "]";
	}




	/**
	 * Crear un estudiante
	 * @param nombreEstudiante
	 * @param identificacionEstudiante
	 * @param direccionEstudiante
	 * @param telefonoEstudiante
	 * @return
	 */
	public String crearEstudiante(String nombreEstudiante, String identificacionEstudiante, String direccionEstudiante,
			String telefonoEstudiante) {

		String mensaje = "No es posible crear mas estudiantes";
		if(estudiante1 == null ) {
			estudiante1 = new Estudiante(nombreEstudiante, identificacionEstudiante, direccionEstudiante, telefonoEstudiante);
			mensaje = "Estudiante creado con exito";
		}else {
			if(estudiante2 == null ) {
				estudiante2 = new Estudiante(nombreEstudiante, identificacionEstudiante, direccionEstudiante, telefonoEstudiante);
				mensaje = "Estudiante creado con exito";
			}
		}

		return mensaje;
	}


	/**
	 * Consultar un estudiante
	 * @param identificacionEstudiante
	 * @return
	 */
	public Estudiante consultarEstudiante( String identificacionEstudiante) {

		Estudiante estudianteEncontrado = null;
		if(estudiante1 != null ) {
			if(estudiante1.getIdentificacion().equals(identificacionEstudiante)) {
				estudianteEncontrado = estudiante1;

			}
		}
		if(estudianteEncontrado == null && estudiante2 != null ) {
			if(estudiante2.getIdentificacion().equals(identificacionEstudiante)) {
				estudianteEncontrado = estudiante2;
			}
		}

		return estudianteEncontrado;
	}

	/**
	 * Eliminar estudiante
	 * @param identificacionEstudiante
	 * @return
	 */
	public String eliminarEstudiante( String identificacionEstudiante) {
		String mensaje = "Estudiante no eliminado";
		Estudiante estudianteEncontrado = null;

		estudianteEncontrado = consultarEstudiante(identificacionEstudiante);
		if(estudianteEncontrado != null) {
			if(estudiante1 == estudianteEncontrado) {
				estudiante1 = null;
				mensaje = "Estudiante eliminado";
			}else {
				if(estudiante2 == estudianteEncontrado) {
					estudiante2 = null;
					mensaje = "Estudiante eliminado";
				}
			}
		}
		return mensaje;
	}
	/**
	 * Actualizar estudiante
	 * @param identificacionEstudiante
	 * @return
	 */
	public String actualizarEstudiante( String identificacionEstudiante,String nombreEstudiante, String direccionEstudiante,
			String telefonoEstudiante) {
		String mensaje = "Estudiante no actualizado";
		Estudiante estudianteEncontrado = null;

		estudianteEncontrado = consultarEstudiante(identificacionEstudiante );
		if(estudianteEncontrado != null) {
			estudianteEncontrado.setNombre(nombreEstudiante);
			estudianteEncontrado.setDireccion(direccionEstudiante);
			estudianteEncontrado.setTelefono(telefonoEstudiante);
			mensaje = "Estudiante actualizado";
		}
		return mensaje;
	}


	//Hacer un metodo que consulte el prestamo donde el estudiante sea robinson

	public Prestamo consultarPrestamo(String nombre) {

		Prestamo prestamoEncontrado = null;
		boolean estudianteEncontrado = false;

		if(prestamo1 != null) {
			estudianteEncontrado = prestamo1.verificarEstudiante(nombre);
			if(estudianteEncontrado == true) {
				prestamoEncontrado = prestamo1;
			}
		}
		if(prestamoEncontrado == null && prestamo2 != null) {
			estudianteEncontrado = prestamo2.verificarEstudiante(nombre);
			if(estudianteEncontrado == true) {
				prestamoEncontrado = prestamo2;
			}
		}

		return prestamoEncontrado;

	}

	public String consultarLibroCantidad() {

		boolean libroVerificado  = false;
		String librosEncontrados = "";

		if(libro1 != null ) {

			libroVerificado = libro1.verificarRango();

			if(libroVerificado == true) {
				librosEncontrados = libro1.toString();
			}
		}

		if(libro2 != null ) {

			libroVerificado = false;

			libroVerificado = libro2.verificarRango();

			if(libroVerificado == true) {
				librosEncontrados += libro2.toString();
			}
		}
		return librosEncontrados;
	}

	//1.0 Consultar la cantidad de libros de la editorial “Uniquindio”
	//que han sido prestados  en la biblioteca y su título empiece por una vocal.

	public int obtenerCantidadLibros(String editorial){
		int cantidad = 0;

		if(prestamo1 != null){
			cantidad += prestamo1.obtenerCantidadLibrosEditorial(editorial);
		}

		if(prestamo2 != null){
			cantidad += prestamo2.obtenerCantidadLibrosEditorial(editorial);
		}

		return cantidad;
	}
//Consultar los estudiantes de modalidad Distancia que hayan prestado el libro de programacion 2 o cualquier otro titulo que sea ingresado en el parametro.

	public String obtenerEstudiantesProgramacion2(String titulo){
String estudianteDistanciaP2 = "No hay estudiantes de modalidad distancia con ese libro prestado";
		if(prestamo1 != null && estudiante1 !=null && libro1 !=null && libro1.getTitulo().toLowerCase().equals(titulo) && estudiante1.verificarEstudiantesDistancia()==true )
		{
			 estudianteDistanciaP2= estudiante1.toString(); 
		}
		
		if(prestamo2 != null && estudiante2 !=null && libro2 !=null && libro2.getTitulo().toLowerCase().equals(titulo) && estudiante2.verificarEstudiantesDistancia()==true )
		{
			 estudianteDistanciaP2= estudiante2.toString();
		}
		return estudianteDistanciaP2;
}
	//Metodo para obtener la cantidad de libros disponibles
	public int obtenerCantidadLibrosDisponibles(){
		int cantidad = 0;
        if (libro1 != null)
        {
        	cantidad += libro1.getCantidadDisponible();
        }
        if (libro2 != null)
        {
        	cantidad += libro2.getCantidadDisponible();
        }

		return cantidad;
}
}
