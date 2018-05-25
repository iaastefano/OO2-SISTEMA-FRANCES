package test;

import java.util.GregorianCalendar;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminarCliente {
	public static void main(String[] args) {
		ClienteABM abmCliente = new ClienteABM();
		try {
			long idCliente = 8;
			abmCliente.eliminar(idCliente);
			System.out.println("Eliminar Cliente --> " + idCliente);
		} catch (Exception e) {
			System.out.println("Error al Eliminar Cliente --> " + e.getMessage());
		}
	}
}