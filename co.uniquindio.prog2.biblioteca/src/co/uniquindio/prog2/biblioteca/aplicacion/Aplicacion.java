package co.uniquindio.prog2.biblioteca.aplicacion;//nameSpace

import javax.swing.JOptionPane;

import co.uniquindio.prog2.biblioteca.model.Biblioteca;
import co.uniquindio.prog2.biblioteca.model.Bibliotecario;
import co.uniquindio.prog2.biblioteca.model.Estudiante;
import co.uniquindio.prog2.biblioteca.model.Libro;

public class Aplicacion {

	
	
	
	public static void main(String[] args) {
		int opcion = 0;
		String nombreBiblioteca = "";
		String direccionBiblioteca = "";
		Biblioteca biblioteca = null;
		
		//variables estudiante
		String nombreEstudiante;
		String identificacionEstudiante;
		String direccionEstudiante;
		String telefonoEstudiante;
		
		//variables Libro
		String codigoLibro;
		String isbnLibro;
		String tituloLibro;
		String autorLibro;
		int numeroPaginasLibro;
		String editorialLibro;
		String estadoLibro;
		String fechaPublicacionLibro;
		int cantidadDisponibleLibro;
		Libro libro;

		//variables Bibliotecario
		String nombreBibliotecario;
		String identificacionBibliotecario;
		String direccionBibliotecario;
		String telefonoBibliotecario;

		String mensaje = "";
		boolean resultado = false;
	
		imprimir("Bienvenidos a la aplicacion Biblioteca");
	
		nombreBiblioteca = leerStringVentana("Ingrese el nombre de la biblioteca");
		direccionBiblioteca = leerStringVentana("Ingrese la direccion de la biblioteca");
		biblioteca = new Biblioteca(nombreBiblioteca,direccionBiblioteca);
		
		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1:
				//crear estudiante
				nombreEstudiante = leerStringVentana("Ingrese el nombre del estudiante");
				identificacionEstudiante = leerStringVentana("\"Ingrese la identificacion del estudiante\"");
				direccionEstudiante = leerStringVentana("\"Ingrese la direccion del estudiante\"");
				telefonoEstudiante = leerStringVentana("\"Ingrese el telefono del estudiante\"");
				
				resultado = validarInformacionEstudiante(nombreEstudiante,identificacionEstudiante,direccionEstudiante,telefonoEstudiante);
				if(resultado == true) {
					mensaje = biblioteca.crearEstudiante(nombreEstudiante,identificacionEstudiante,direccionEstudiante,telefonoEstudiante);
					imprimir(mensaje);
				}else {
					imprimirError(mensaje);
				}
				break;
			case 2:
				mensaje=(""+ libro.cantidadLibrosDisponibles());
				imprimir(mensaje);
			 System.out.println(libro.cantidadLibrosDisponibles());
				break;
			default:
				break;
			}
		}while(opcion!=3);

	}


	
	private static boolean validarInformacionEstudiante(String nombreEstudiante, String identificacionEstudiante,
			String direccionEstudiante, String telefonoEstudiante) {
		
		boolean valido = true;
		if(nombreEstudiante.equalsIgnoreCase("") || identificacionEstudiante.equalsIgnoreCase("")
				||direccionEstudiante.equalsIgnoreCase("") ||telefonoEstudiante.equalsIgnoreCase("")) {
			valido = false;
		}
		
		if(!isNumeric(telefonoEstudiante)) {
			valido = false;
		}
		return valido;
	}



	private static void imprimirError(String mensaje) {
		JOptionPane.showInputDialog(null, "Por favor ingresar datos validos", "Error!", JOptionPane.ERROR_MESSAGE);
		
	}



	private static int mostrarMenu() {
		//CRUD create, Read, update,delete
		int opcion = 0;
		String menu = "Seleccione la opción que desea realizar :\n"
				+ " Opciones Estudiantes\n"
				+ "1 Crear un Estudiante\n"
				+ "2 Consultar un Estudiante\n"
				+ "3 Eliminar un Estudiante\n"
				+ "4 Actualizar un Estudiante\n\n"
				+ " Opciones Libros\n";
		
		opcion = leerEnteroVentana(menu);
		return opcion;
	}



	/**
	 * Permite leer un numero entero mediante una caja de dialogo 
	 * @param mensaje El mensaje que verá el usuario 
	 * @return el numero ingresado por el usuario
	 */
	public static int leerEnteroVentana (String mensaje)
	{
		int dato= Integer.parseInt(JOptionPane.showInputDialog(mensaje));
		return dato;
	}

	/**
	 * Permite imprimir un mensaje
	 * @param mensaje El mensaje a imprimir
	 */
	public static void imprimir (String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje);
	}

	/**
	 * Permite leer un numero double mediante una caja de dialogo 
	 * @param mensaje El mensaje que verá el usuario 
	 * @return el numero ingresado por el usuario
	 */	

	public static double leerDouble (String mensaje)
	{
		double dato= Double.parseDouble(JOptionPane.showInputDialog(mensaje));
		return dato;
	}

	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}

	public static String  leerStringVentana(String mensaje) {
		String respuesta = "";
		respuesta  = JOptionPane.showInputDialog(mensaje);
		return respuesta;

	}







}
