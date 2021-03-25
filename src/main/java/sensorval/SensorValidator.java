package sensorval;

import java.util.List;

import org.apache.commons.lang3.Validate;


public class SensorValidator {

  public static boolean isSubstractionOfNextValueMinusPreviousValueGreaterThanMaxDelta(double value, double nextValue,
      double maxDelta) {
    boolean result = Boolean.TRUE;
    if (nextValue - value > maxDelta) {
      result = Boolean.FALSE;
    }
    return result;
  }

  public static boolean validateSOCreadings(List<Double> values) {
    Validate.notNull(values, "Please provide proper 'SOC reading' values, Provided value is null!", values);
    Validate.notEmpty(values, "Please provide proper 'SOC reading' values, Provided value is empty!", values);
    boolean result = Boolean.TRUE;
    int lastButOneIndex = values.size() - 1;
    for (int i = 0; i < lastButOneIndex; i++) {
      if (!isSubstractionOfNextValueMinusPreviousValueGreaterThanMaxDelta(values.get(i), values.get(i + 1), 0.05)) {
        result = Boolean.FALSE;
      }
    }
    return result;
  }

  public static boolean validateCurrentreadings(List<Double> values) {
    Validate.notNull(values, "Please provide proper 'Current reading' values, Provided value is null!", values);
    Validate.notEmpty(values, "Please provide proper 'Current reading' values, Provided value is empty!", values);
    boolean result = Boolean.TRUE;
    int lastButOneIndex = values.size() - 1;
    for (int i = 0; i < lastButOneIndex; i++) {
      if (!isSubstractionOfNextValueMinusPreviousValueGreaterThanMaxDelta(values.get(i), values.get(i + 1), 0.1)) {
        result = Boolean.FALSE;
      }
    }
    return result;
  }
}

