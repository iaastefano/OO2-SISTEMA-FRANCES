package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestEliminarPrestamo {
	public static void main(String[] args) {
		PrestamoABM abmPrestamo = new PrestamoABM();
		try {
			long idPrestamo = 2;
			abmPrestamo.eliminar(idPrestamo);
			System.out.println("Eliminar Prestamo --> " + idPrestamo);
		} catch (Exception e) {
			System.out.println("Error al Eliminar Prestamo --> " + e.getMessage());
		}
	}
}