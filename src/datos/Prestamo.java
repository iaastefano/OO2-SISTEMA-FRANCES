package datos;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.HashSet;
import java.util.TimeZone;
import java.util.TreeSet;

import funciones.Funciones;

public class Prestamo {
	private long idPrestamo;
	private GregorianCalendar fecha;
	private double monto;
	private double interes;
	private int cantCuotas;
	private boolean cancelado;
	private Cliente cliente;
	private Set<Cuota> cuotas;
	
	public Prestamo()
	{
		
	}
	
	public boolean isCancelado() {
		return cancelado;
	}

	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Prestamo(GregorianCalendar fecha, double monto, double interes, int cantCuotas, Cliente cliente) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.interes = interes;
		this.cantCuotas = cantCuotas;
		this.cliente = cliente;
		this.cancelado = false;
		this.setCuotas();
	}

	public long getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(long idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public Set<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(Set<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public int getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(int cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fecha=" + Funciones.traerFechaCorta(fecha) + ", monto=" + monto + ", interes=" + interes
				+ ", cantCuotas=" + cantCuotas + ", cliente=" + cliente + "]";
	}
	
	public void setCuotas()
	{
		int nroCuota;
		GregorianCalendar fechaVencimiento = this.fecha;
		double saldoPendiente = this.monto;
		double amortizacion;
		double interesCuota;
		double cuota;
		double deuda;
		for(int i = 1; i <= this.cantCuotas; i++)
		{
			cuotas = new HashSet<Cuota>();
			nroCuota = i;
			fechaVencimiento = fecha;
			fechaVencimiento.add(Calendar.MONTH, i);
			while(!Funciones.esDiaHabil(fechaVencimiento))
			{
				fechaVencimiento.add(Calendar.DATE, 1);
			}
			amortizacion = (saldoPendiente * this.interes) / (Math.pow(1 + this.interes, this.cantCuotas + 1 - i) - 1);
			interesCuota = saldoPendiente * this.interes;
			cuota = amortizacion + interesCuota;
			deuda = saldoPendiente - amortizacion;
			saldoPendiente = saldoPendiente - amortizacion;
			Cuota c = new Cuota(nroCuota, fechaVencimiento, saldoPendiente, amortizacion,
					interesCuota, cuota, deuda, this);
			cuotas.add(c);
		}
	}
	
}
