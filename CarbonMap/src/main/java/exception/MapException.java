package exception;

/**
 * STARS Exception class
 *
 * @author Antoine Janvrot
 * @version 7 févr. 2019
 */
public class MapException extends Exception {

	/** Serial ID. */
	private static final long serialVersionUID = 1L;

	/** Default message. */
	private static final String DEFAULT_MAP_EXCEPTION_MESSAGE = "Un problème est survenu";

	/**
	 * Ctor with default message.
	 */
	public MapException() {
		super(DEFAULT_MAP_EXCEPTION_MESSAGE);
	}

	/**
	 * Ctor with message parameter.
	 *
	 * @param message
	 *            the message of the exception.
	 */
	public MapException(final String message) {
		super(message);
	}
	
	/**
	 * Ctor with message parameter.
	 * @param message the message of the exception.
	 * @param e originating exception
	 */
	public MapException(final String message, Throwable e) {
		super(message, e);
	}
}

