package test;

import java.util.GregorianCalendar;
import datos.Cliente;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestAgregarPrestamo {
	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		PrestamoABM abmPrestamo = new PrestamoABM();
		try {
			GregorianCalendar fecha = new GregorianCalendar(2018,5,23);
			double monto = 10000;
			double interes = 0.1;
			int cantCuotas = 12;
			int dni = 14000000;
			Cliente cliente = abmCliente.traerCliente(dni); 
			long ultimoIdPrestamo = abmPrestamo.agregar(fecha, monto, interes, cantCuotas, cliente);
			System.out.println("Agregar Prestamo--> " + ultimoIdPrestamo);
		} catch (Exception e) {
			System.out.println("Error al agregar Prestamo--> " + e.getMessage());
		}
	}
}