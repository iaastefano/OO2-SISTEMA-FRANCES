package test;

import java.util.List;
import datos.Cliente;
import negocio.ClienteABM;

public class TestTraerCliente {
	public static void main(String[] args) {

		ClienteABM clienteABM = new ClienteABM();

		try {
			long idCliente = 1;
			System.out.println("\n---> TraerCliente idCliente=" + idCliente + "\n\n");
			Cliente c;
			c = clienteABM.traerCliente(idCliente);
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("\"\\n---> TraerCliente (todos) = \n\n");
			List<Cliente> clientes = clienteABM.traerCliente();
			for(Cliente c : clientes) {
				System.out.println(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		int dni=14000000;
		try {
			System.out.println("\"\\n---> TraerCliente dni = " + dni + "\n\n");
			Cliente c = clienteABM.traerCliente(dni);
			System.out.println(c);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}
}