/**
 * <p>
 * Copyright © 2019 THALES Communications, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propriété de THALES Communications, France,
 * il ne peut être ni reproduit, ni utilisé, ni communiqué, ni distribué
 * à  des tiers sans son autorisation préalable.
 * </p>
 * <p>
 * Créé le 6 févr. 2019.
 * </p>
 */
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

