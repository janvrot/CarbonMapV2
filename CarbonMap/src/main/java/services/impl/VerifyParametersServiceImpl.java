package services.impl;

import java.util.Arrays;
import java.util.List;

import services.VerifyParametersService;

public class VerifyParametersServiceImpl implements VerifyParametersService {

	@Override
	public boolean checkNumberParameters(int number, String[] params) {
		return params.length == number;
	}

	@Override
	public boolean isNumericAndMoreThanZero(String param) {
		try {
			int coordinate = Integer.parseInt(param);
			return coordinate > 0;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}
	
	@Override
	public boolean isNumericAndPositive(String param) {
		try {
			int coordinate = Integer.parseInt(param);
			return coordinate >= 0;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}

	@Override
	public boolean hasValuesIncludedInDefaultValues(String param, List<String> defaultValues) {
		if (param.length() > 0) {
			long count = Arrays.stream(param.split("")).filter(s -> defaultValues.contains(s)).count();
			return count == param.length();
		} else {
			return false;
		}
	}

	@Override
	public boolean isNotEmptyString(String param) {
		return param.length() > 0;
	}

}