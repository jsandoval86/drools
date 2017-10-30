package dominio;

public class Cuenta {
	
	public static final int AHORROS = 1;
	public static final int CORRIENTE = 2;
	
	private long cuentaNumero;
	private double balance;
	private int tipo;
	
	
	public long getCuentaNumero() {
		return cuentaNumero;
	}
	public void setCuentaNumero(long cuentaNumero) {
		this.cuentaNumero = cuentaNumero;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
		
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Cuenta [cuentaNumero=" + cuentaNumero + ", balance=" + balance + ", tipo=" + tipo + "]";
	}
	
}
