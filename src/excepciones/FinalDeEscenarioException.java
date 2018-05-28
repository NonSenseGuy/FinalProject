package excepciones;

public class FinalDeEscenarioException extends Exception{
	
	public final int INICIO_ESCENARIO = 0;
	public final int FINAL_ESCENARIO = 1180;
	
	public FinalDeEscenarioException(int pos) {
		super("No se puede ir mas alla de " + pos);
	}
}
