package test;

import datos.Prestamo;
import negocio.PrestamoABM;

public class TestActualizarPrestamo {
	public static void main(String[] args) {
		try
		{
			PrestamoABM abm = new PrestamoABM();
			long id = 1;
			// traer el obj a modificar
			Prestamo p = abm.traerPrestamo(id);
			System.out.println("Prestamo a Modificar --> " + p);
			// modificar por set los atributos
			p.setCantCuotas(24);
			abm.modificar(p); // update del objeto
			Prestamo pModif = abm.traerPrestamo(id);
			System.out.println("Prestamo Modificado --> " + pModif);
	
		}
		catch (Exception e) {
			System.out.println("Error al modificar Cliente --> " + e.getMessage());
		}
	}
}