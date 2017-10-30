package dominio;

import java.util.Date;

public class FlujoCaja {
	
	public static final String MSG = "Su cuenta es de ahorros no puede generar un crédito";
	
	public static final int CREDITO = 1;
	public static final int DEBITO = 2;
	
	private Date fecha;
	private double monto;
	private int tipo;
	private long cuentaNumero;
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public long getCuentaNumero() {
		return cuentaNumero;
	}
	public void setCuentaNumero(long cuentaNumero) {
		this.cuentaNumero = cuentaNumero;
	}
	@Override
	public String toString() {
		return "FlujoCaja [fecha=" + fecha + ", monto=" + monto + ", tipo=" + tipo + ", cuentaNumero=" + cuentaNumero
				+ "]";
	}
	
}
