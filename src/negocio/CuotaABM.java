package negocio;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import dao.CuotaDao;
import datos.Cuota;
import datos.Prestamo;
import dao.PrestamoDao;

public class CuotaABM {
	CuotaDao dao = new CuotaDao();
	PrestamoDao daoPrestamo = new PrestamoDao();
	public Cuota traerCuota(long idCuota) throws Exception {
		Cuota c = dao.traerCuota(idCuota);
		if (c == null)
		{
			throw new Exception("La Cuota de id " + idCuota + " no existe.");
		}
		return c;
	}

	public Cuota traerCuota(long idPrestamo, int nroCuota) throws Exception {
		Prestamo p = daoPrestamo.traerPrestamo(idPrestamo);
		if (p == null)
		{
			throw new Exception("El prestamo de id " + idPrestamo + " que quiere traer no existe.");
		}
		Cuota c = dao.traerCuota(idPrestamo, nroCuota);
		if (c == null)
		{
			throw new Exception("La Cuota nro" + nroCuota + " del prestamo de id " + idPrestamo + " que quiere traer no existe.");
		}
		return c;
	}

	public void modificar(Cuota c) throws Exception
	{
		try 
		{
			dao.actualizar(c);
		}
		catch(Exception ex)
		{
			throw new Exception("Error al modificar la cuota de id " + c.getIdCuota());
		}
		
	}



	public List<Cuota> traerCuotas(long idPrestamo) {
		return dao.traerCuotas(idPrestamo);
	}
	
}
