package excepciones;

public class PartidaNoGuardadaException extends Exception {
	public PartidaNoGuardadaException() {
		super("No hay partidas guardadas");
	}
}
