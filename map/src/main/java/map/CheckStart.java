package map;

import entities.Carte;

public class CheckStart {

	// Premiere verification des parametres
	public static boolean checkIfEnoughParams(String str) {
		String[] params = str.split(" - ");
		if (params.length < 3 || params.length > 6) {
			return false;
		} else {
			return true;
		}
	}

	// Verification des parametres de la carte
	public static boolean checkMap(String oneObject) {
		String[] params = oneObject.split(" - ");
		boolean result = false;
		if (params.length == 3) {
			if (params[0].equals("C")) {
				for (int i = 1; i < params.length; i++) {
					if (CheckOnly.isNotEmpty(params[i]) && CheckOnly.isInteger(params[i])) {
						result = true;
					} else {
						result = false;
					}
				}
			}
		}
		return result;
	}

	// Verification des parametres des montagnes
	public static boolean checkMountain(String oneObject, Carte carte) {
		String[] params = oneObject.split(" - ");
		boolean result = false;
		if (carte != null) {
			if (params.length == 3) {
				if (CheckOnly.checkXArg(carte, params[1]) && CheckOnly.checkYArg(carte, params[2])) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	// Verification des parametres des tresors
	public static boolean checkTresor(String oneObject, Carte carte) {
		String[] params = oneObject.split(" - ");
		boolean result = false;
		if (carte != null) {
			if (params.length == 4) {
				if (CheckOnly.checkXArg(carte, params[1]) && CheckOnly.checkYArg(carte, params[2]) && CheckOnly.checkNumber(params[3])) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	// Verification des parametres des aventuriers
	public static boolean checkExplorer(String oneObject, Carte carte) {
		String[] params = oneObject.split(" - ");
		boolean result = false;
		if (carte != null) {
			if (params.length == 6) {
				if (CheckOnly.isNotEmpty(params[1]) && CheckOnly.checkXArg(carte, params[2]) && CheckOnly.checkYArg(carte, params[3]) && CheckOnly.checkPosition(params[4]) && CheckOnly.isNotEmpty(params[4])) {
					result = true;
				} else {
					result = false;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

}
