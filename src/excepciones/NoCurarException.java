package excepciones;

public class NoCurarException extends Exception{
	public NoCurarException() {
		super("El personaje ya esta al maximo de vida");
	}
}
