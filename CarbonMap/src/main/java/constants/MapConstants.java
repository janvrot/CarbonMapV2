package constants;

import java.util.Arrays;
import java.util.List;

/**
 * Contient les constantes utilitaires
 *
 * @author Antoine Janvrot
 * @version 23 août 2019
 */
public final class MapConstants {

	/**
	 * Bloquage de l'instanciation
	 */
	private MapConstants() {

	}

	/**
	 * Le chemin par défaut du fichier
	 */
	public static final String DEFAULT_FILE_PATH = "src/main/resources/Map.txt";

	/**
	 * Le sdifférentes orientations possibles
	 */
	public static final List<String> ORIENTATIONS = Arrays.asList("N", "E", "S", "W");

	/**
	 * Les différents identifiants pour les objets
	 */
	public static final List<String> OBJECTS_IDENTIFIER = Arrays.asList("C", "M", "T", "A");

	/**
	 * Les différents mouvements de l'aventurier
	 */
	public static final List<String> MOVEMENTS = Arrays.asList("A", "D", "G");
}
