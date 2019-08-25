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
 * Créé le 23 août 2019.
 * </p>
 */
package constants;

import java.util.Arrays;
import java.util.List;

/**
 * 
 *
 * @author Antoine Janvrot
 * @version 23 août 2019
 */
public final class MapConstants {
	
	private MapConstants() {
		
	}
	
	public static final String DEFAULT_FILE_PATH = "src/main/resources/Map.txt";
	
	public static final List<String> ORIENTATIONS = Arrays.asList("N", "E", "S", "W");
	
	public static final List<String> OBJECTS_IDENTIFIER = Arrays.asList("C", "M", "T", "A");
}

