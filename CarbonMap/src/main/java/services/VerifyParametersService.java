package services;

import java.util.List;

public interface VerifyParametersService {

	public boolean checkNumberParameters(int number, String[] params);
	
	public boolean isNumericAndMoreThanZero(String param);
	
	public boolean hasValuesIncludedInDefaultValues(String param, List<String> defaultValues);
	
	public boolean isNotEmptyString(String param);
	
	public boolean isNumericAndPositive(String param);
}
