package test;

import java.util.List;
import datos.Cliente;
import datos.Prestamo;
import negocio.ClienteABM;
import negocio.PrestamoABM;

public class TestTraerPrestamo {
	public static void main(String[] args) {
		
		PrestamoABM prestamoABM = new PrestamoABM();
		long idPrestamo = 1;
		System.out.println("\n---> TraerPrestamo idPrestamo=" + idPrestamo + "\n\n");
		Prestamo p;
		try {
			p = prestamoABM.traerPrestamo(idPrestamo);
			System.out.println(p.toString() + "\nPertenece a " + p.getCliente());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		ClienteABM clienteABM = new ClienteABM();
		int dni=35000001;
		Cliente c;
		try {
			c = clienteABM.traerCliente(dni);
			System.out.println("\"\\n---> TraerPrestamos del Cliente=" + c.toString() + "\n\n");
			List<Prestamo> prestamos = prestamoABM.traerPrestamo(c);
			for(Prestamo prestamo: prestamos) {
				System.out.println(prestamo.toString() + "\nPertenece a " + prestamo.getCliente());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
}