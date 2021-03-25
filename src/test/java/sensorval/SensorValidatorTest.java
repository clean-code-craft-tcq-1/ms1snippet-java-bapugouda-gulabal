package sensorval;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SensorValidatorTest {
  
  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void reportsErrorWhenSOCjumps() {
    Double[] readings = { 0.0, 0.01, 0.5, 0.51 };
    List<Double> socs = Arrays.asList(readings);
    assertFalse(SensorValidator.validateSOCreadings(socs));
  }
  
  @Test
  public void reportsErrorWhenSOCReadingIsNull() {
    exceptionRule.expect(NullPointerException.class);
    exceptionRule.expectMessage("Please provide proper 'SOC reading' values, Provided value is null!");
    assertFalse(SensorValidator.validateSOCreadings(null));
  }
  
  @Test
  public void reportsErrorWhenSOCReadingIsEmpty() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Please provide proper 'SOC reading' values, Provided value is empty!");
    Double[] readings = { };
    List<Double> socs = Arrays.asList(readings);
    assertFalse(SensorValidator.validateSOCreadings(socs));
  }
  
  @Test
  public void reportsErrorWhenCurrentjumps() {
    Double[] readings = { 0.03, 0.03, 0.03, 0.33 };
    List<Double> currents = Arrays.asList(readings);
    assertFalse(SensorValidator.validateCurrentreadings(currents));
  }
  
  @Test
  public void reportsErrorWhenCurrentReadingIsNull() {
    exceptionRule.expect(NullPointerException.class);
    exceptionRule.expectMessage("Please provide proper 'Current reading' values, Provided value is null!");
    List<Double> currents = null;
    assertFalse(SensorValidator.validateCurrentreadings(currents));
  }
  
  @Test
  public void reportsErrorWhenCurrentReadingIsEmpty() {
    exceptionRule.expect(IllegalArgumentException.class);
    exceptionRule.expectMessage("Please provide proper 'Current reading' values, Provided value is empty!");
    List<Double> currents = Arrays.asList();
    assertFalse(SensorValidator.validateCurrentreadings(currents));
  }
}
