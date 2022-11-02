package com.math;
import static org.testng.AssertJUnit.assertEquals;
import org.testng.annotations.Test;

public class CalculatorTest {

  @Test
  public void testAdd() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(1, 4));  // expected, actual
  }

  @Test
  public void testDivide() {
    Calculator calc = new Calculator();
    assertEquals(1.0, calc.divide(2,2));
  }

  @Test
  public void testIsEven(){
    Calculator calc = new Calculator();
    assertEquals(true, calc.isEven(4));
  }

}