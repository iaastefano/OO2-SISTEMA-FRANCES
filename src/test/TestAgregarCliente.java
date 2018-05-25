package test;

import java.util.GregorianCalendar;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {
		String apellido = "CARLOS";
		String nombre = "PEREZ";
		int documento = 14000000;
		GregorianCalendar fechaDeNacimiento = new GregorianCalendar(1998,5,23); // tu fecha de nacimiento
		ClienteABM abm = new ClienteABM();
		try {
			long ultimoIdCliente = abm.agregar(apellido, nombre, documento, fechaDeNacimiento);
			System.out.println("Agregar Cliente --> " + ultimoIdCliente);
		} catch (Exception e) {
			System.out.println("Error al agregar Cliente --> " + e.getMessage());
		}
	}
}