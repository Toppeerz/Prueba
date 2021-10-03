package co.uniquindio.prog2.biblioteca.test;

import javax.swing.JOptionPane;

import co.uniquindio.prog2.biblioteca.model.Biblioteca;
import co.uniquindio.prog2.biblioteca.model.Bibliotecario;
import co.uniquindio.prog2.biblioteca.model.DetallePrestamo;
import co.uniquindio.prog2.biblioteca.model.Estudiante;
import co.uniquindio.prog2.biblioteca.model.Libro;
import co.uniquindio.prog2.biblioteca.model.Modalidad;
import co.uniquindio.prog2.biblioteca.model.Prestamo;

public class Test {

	public static void main(String[] args) {

		Biblioteca biblioteca = new Biblioteca("XX", "");

		Estudiante estudiante1 = new Estudiante("Juan","103883","calle 2","31353647");
		Estudiante estudiante2 = new Estudiante("Pedro","103883","calle 2","31353647");
		estudiante2.setModalidad(Modalidad.DISTANCIA);


		biblioteca.setEstudiante1(estudiante1);
		biblioteca.setEstudiante2(estudiante2);

		Bibliotecario bibliotecario = new Bibliotecario("Luis","103883","calle 2","31353647");
		biblioteca.setBibliotecario(bibliotecario);

		Libro libro1 = new Libro("1","13444","El olvido que seremos" , "El olvido que seremos es una película dramática de 2020, dirigida por el español Fernando Trueba y basada en la novela homónima del colombiano Héctor Abad ", 10,"Uniquindio","disponible", "21-09-21", 10);
		Libro libro2 = new Libro("2","657585","Cien años de soledad" , "Es probablemente, la obra más importante de la literatura hispanoamericana del siglo XX y es la máxima exponente del realismo mágico que envuelve a los paisajes de nuestro país. ", 10,"Uniquindio","disponible", "21-09-21", 20);

		biblioteca.setLibro1(libro1);
		biblioteca.setLibro2(libro2);



		Prestamo prestamo1 = new Prestamo();
		prestamo1.setCodigo("1");
		prestamo1.setEstudiante(estudiante1);
		prestamo1.setFechaDevolucion("01-10-2021");
		prestamo1.setFechaPrestamo("16-08-21");

		DetallePrestamo detallePrestamo1 = new DetallePrestamo(3, libro1);
		DetallePrestamo detallePrestamo2 = new DetallePrestamo(4, libro2);

		prestamo1.setDetallePrestamo1(detallePrestamo1);
		prestamo1.setDetallePrestamo2(detallePrestamo2);

		biblioteca.setPrestamo1(prestamo1);



		Prestamo prestamo2 = new Prestamo();
		prestamo2.setCodigo("1");
		prestamo2.setEstudiante(estudiante1);
		prestamo2.setFechaDevolucion("01-10-2021");
		prestamo2.setFechaPrestamo("26-08-21");

		DetallePrestamo detallePrestamo3 = new DetallePrestamo(3, libro1);
		DetallePrestamo detallePrestamo4 = new DetallePrestamo(4, libro2);

		prestamo2.setDetallePrestamo1(detallePrestamo3);
		prestamo2.setDetallePrestamo2(detallePrestamo4);

		biblioteca.setPrestamo2(prestamo2);


		int cantidadLibros = biblioteca.obtenerCantidadLibros("Uniquindio");

		System.out.println(cantidadLibros);
	}


	/**
	 * Permite imprimir un mensaje
	 * @param mensaje El mensaje a imprimir
	 */
	public static void imprimir (String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje);
	}


	public static String  leerStringVentana(String mensaje) {
		String respuesta = "";
		respuesta  = JOptionPane.showInputDialog(mensaje);
		return respuesta;

	}


}
