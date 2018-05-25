package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traerCliente(long idCliente) throws Exception {
		Cliente c = dao.traerCliente(idCliente);
		if (c == null)
		{
			throw new Exception("El cliente de id " + idCliente + " no existe.");
		}
		return c;
	}

	public Cliente traerCliente(int dni) throws Exception {
		Cliente c = dao.traerCliente(dni);
		if (c == null)
		{
			throw new Exception("El cliente de dni " + dni + " que quiere traer no existe.");
		}
		return c;
	}

	public int agregar(String apellido, String nombre, int dni, GregorianCalendar fechaDeNacimiento) throws Exception {
		if(dao.traerCliente(dni)!=null)
		{
			throw new Exception("El cliente de dni " + dni + " que quiere agregar ya existe.");
		}
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) throws Exception{
		String mensaje = "";
		Cliente cAux = dao.traerCliente(c.getDni());
		if(cAux!=null && c.getIdCliente() != cAux.getIdCliente())
		{
			mensaje = "El dni " + c.getDni() + "que le quiere modificar al cliente " 
					+ c.getNombre() + " " + c.getApellido() + " ya esta asignado al cliente " + cAux.getNombre() + " " + c.getApellido();
		}
		cAux = dao.traerCliente(c.getIdCliente());
		if(cAux!=null && c.getDni() != c.getDni())
		{
			mensaje += "El id " + c.getIdCliente() + "que le quiere modificar al cliente " 
					+ c.getNombre() + " " + c.getApellido() + " ya esta asignado al cliente " + cAux.getNombre() + " " + c.getApellido();
			
		}
		if (!mensaje.isEmpty())
		{
			throw new Exception(mensaje);
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception { 
		
		Cliente c = dao.traerCliente(idCliente);
		if(c == null)
		{
			throw new Exception("El cliente de id " + idCliente + " que quiere eliminar no existe.");
		}
		dao.eliminar(c);
	}

	public List<Cliente> traerCliente() {
		return dao.traerCliente();
	}
}
