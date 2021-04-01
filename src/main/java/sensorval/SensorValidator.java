package sensorval;

import java.util.List;

import org.apache.commons.lang3.Validate;


public class SensorValidator {

  public static boolean isDifferenceGreaterThanThreshold(double value, double nextValue, double maxDelta) {
	    boolean result = Boolean.TRUE;
	    if (nextValue - value > maxDelta) {
	      result = Boolean.FALSE;
	    }
	    return result;
	  }

  public static boolean validateSOCreadings(List<Double> values) {
	    Validate.notNull(values, getValidationMsg("'SOC reading'", null), values);
	    Validate.notEmpty(values, getValidationMsg("'SOC reading'", "empty"), values);
	    return validateReadings(values, 0.05);
	  }

	  public static boolean validateCurrentreadings(List<Double> values) {
	    Validate.notNull(values, getValidationMsg("'Current reading'", null), values);
	    Validate.notEmpty(values, getValidationMsg("'Current reading'", "empty"), values);
	    return validateReadings(values, 0.1);
	  }
  
  private static boolean validateReadings(List<Double> values, double threshold) {
	    boolean result = Boolean.TRUE;
	    int lastButOneIndex = values.size() - 1;
	    for (int i = 0; i < lastButOneIndex; i++) {
	      if (!isDifferenceGreaterThanThreshold(values.get(i), values.get(i + 1), threshold)) {
	        result = Boolean.FALSE;
	      }
	    }
	    return result;
	  }
  
  public static String getValidationMsg(String value1, String value2) {
	    return String.format("Please provide proper %s values, Provided value is %s!", value1, value2);
	  }
}

