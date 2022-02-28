package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import ic.doc.Calculator;
import org.junit.Test;

public class CalculatorTest {

  @Test
  public void addingFirstValueStoresInCorrectOrder() {
    Calculator calc = new Calculator();
    calc.addValue(1);

    assertThat(calc.getVal1(), is(1));
  }

  @Test
  public void addingSecondValueStoresInCorrectOrder() {
    Calculator calc = new Calculator();
    calc.addValue(1);
    calc.addValue(2);

    assertThat(calc.getVal1(), is(1));
    assertThat(calc.getVal2(), is(2));
  }

  @Test
  public void addingSubsequentValuesStoreInCorrectOrder() {
    Calculator calc = new Calculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.addValue(3);

    assertThat(calc.getVal1(), is(2));
    assertThat(calc.getVal2(), is(3));
  }

  @Test
  public void calculateSumOfTwoNumbers() {
    Calculator calc = new Calculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.performAddition();

    assertThat(calc.text(), is("3"));
  }
}
