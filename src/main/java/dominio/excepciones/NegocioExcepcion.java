package dominio.excepciones;

public class NegocioExcepcion extends RuntimeException {

	public NegocioExcepcion(String message) {
		super(message);
	}
	
}
