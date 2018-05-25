package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import dao.ClienteDao;
import dao.PrestamoDao;
import datos.Cliente;
import datos.Prestamo;

public class PrestamoABM {
	PrestamoDao dao = new PrestamoDao();
	ClienteDao daoCliente = new ClienteDao();
	
	public Prestamo traerPrestamo(long idPrestamo) throws Exception{
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if (p == null)
		{
			throw new Exception("El prestamo de id " + idPrestamo + " no existe.");
		}
		return p;
	}

	public List<Prestamo> traerPrestamo(Cliente c) {
		return dao.traerPrestamo(c);
	}
	
	public int agregar(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) throws Exception {
		if(daoCliente.traerCliente(cliente.getIdCliente())==null)
		{
			throw new Exception("El cliente de dni " + cliente.getDni() + " al que le quiere agregar un prestamo no existe.");
		}
		Prestamo p = new Prestamo(fecha,monto,interes,cantCuotas,cliente);
		return dao.agregar(p);
	}

	public void modificar(Prestamo p) throws Exception{
		try
		{
			dao.modificar(p);
		}	
		catch(Exception ex)
		{
			throw new Exception("El prestamo " + p.toString() + " no se pudo modificar.");
		}
		
	}

	public void eliminar(long idPrestamo) throws Exception { 
		
		Prestamo p = dao.traerPrestamo(idPrestamo);
		if(p == null)
		{
			throw new Exception("El prestamo de id " + idPrestamo + " que quiere eliminar no existe.");
		}
		dao.eliminar(p);
	}
}
