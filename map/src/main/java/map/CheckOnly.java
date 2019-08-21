package map;

import entities.Carte;

public class CheckOnly {

	// Verification des coordonnees en abscisse des objets
	public static boolean checkXArg(Carte carte, String param) {
		if (CheckOnly.isNotEmpty(param) && CheckOnly.isInteger(param)) {
			if (Integer.parseInt(param) < carte.getLengthMap()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Verification des coordonnees en ordonnee des objets
	public static boolean checkYArg(Carte carte, String param) {
		if (CheckOnly.isNotEmpty(param) && CheckOnly.isInteger(param)) {
			if (Integer.parseInt(param) < carte.getHighMap()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Verifie si un parametre est un chiffre > 0
	public static boolean checkNumber(String param) {
		if (CheckOnly.isNotEmpty(param) && CheckOnly.isInteger(param)) {
			if (Integer.parseInt(param) > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	// Verification de la position d'un aventurier
	public static boolean checkPosition(String str) {
		String[] positions = { "S", "N", "O", "E" };
		boolean result = false;
		for (int i = 0; i < positions.length; i++) {
			if (str.equals(positions[i])) {
				result = true;
			}
		}
		return result;
	}

	// Verifie si un parametre existe
	public static boolean isNotEmpty(String str) {
		if (str.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	// Verifie si un parametre est un entier
	public static boolean isInteger(String s) {
		boolean isValidInteger = false;
		try {
			Integer.parseInt(s);
			isValidInteger = true;
		} catch (NumberFormatException ex) {
		}

		return isValidInteger;
	}
}
