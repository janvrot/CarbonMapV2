package services;

import java.util.List;

/**
 * Verification des parametres des objets
 * 
 * @author antoinejanvrot
 *
 */
public interface VerifyParametersService {

	/**
	 * Verifie le nombre de parametres
	 * 
	 * @param number le nombre de parametres souhaite
	 * @param params la liste de parametres
	 * @return Les parametres sont au bon nombre
	 */
	public boolean checkNumberParameters(int number, String[] params);

	/**
	 * Verification si le parametre est superieur a zero et est un entier
	 * 
	 * @param param le parametre
	 * @return le parametre est conforme
	 */
	public boolean isNumericAndMoreThanZero(String param);

	/**
	 * Verifie si le parametre contient les valeurs disponibles
	 * 
	 * @param param         le parametre
	 * @param defaultValues les valeurs par defaut
	 * @return le parametre est conforme
	 */
	public boolean hasValuesIncludedInDefaultValues(String param, List<String> defaultValues);

	/**
	 * Verifie aue le parametre n'est pas vide
	 * 
	 * @param param le prametre
	 * @return le parametre est conforme
	 */
	public boolean isNotEmptyString(String param);

	/**
	 * Le parametre est un entier positif
	 * 
	 * @param param Le parametre
	 * @return le parametre est conforme
	 */
	public boolean isNumericAndPositive(String param);
}
