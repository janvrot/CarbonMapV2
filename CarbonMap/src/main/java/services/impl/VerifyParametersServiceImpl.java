package services.impl;

import java.util.Arrays;
import java.util.List;

import services.VerifyParametersService;

public class VerifyParametersServiceImpl implements VerifyParametersService {

	@Override
	public boolean checkNumberParameters(int number, String[] params) {
		if (params.length != number)
			return false;
		else
			return true;
	}

	@Override
	public boolean isNumericAndMoreThanZero(String param) {
		try {
			int coordinate = Integer.parseInt(param);
			if (coordinate > 0)
				return true;
			else
				return false;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}
	
	@Override
	public boolean isNumericAndPositive(String param) {
		try {
			int coordinate = Integer.parseInt(param);
			if (coordinate >= 0)
				return true;
			else
				return false;
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
	}

	@Override
	public boolean hasValuesIncludedInDefaultValues(String param, List<String> defaultValues) {
		if (param.length() > 0) {
			long count = Arrays.stream(param.split("")).filter(s -> defaultValues.contains(s)).count();
			if (count == param.length())
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	@Override
	public boolean isNotEmptyString(String param) {
		if (param.length() > 0)
			return true;
		else
			return false;
	}

}