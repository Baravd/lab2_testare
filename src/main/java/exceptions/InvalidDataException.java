package exceptions;

public class InvalidDataException extends Exception{
	private static final long serialVersionUID = -69637829093235855L;


	public InvalidDataException(String message) {
		super(message);
	}
}
