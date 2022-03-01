package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class ReversePolishCalculatorTest {

  @Test
  public void addingFirstValueStoresInCorrectOrder() {
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);

    assertThat(calc.getVal1(), is(1));
  }

  @Test
  public void addingSecondValueStoresInCorrectOrder() {
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);
    calc.addValue(2);

    assertThat(calc.getVal1(), is(1));
    assertThat(calc.getVal2(), is(2));
  }

  @Test
  public void addingSubsequentValuesStoreInCorrectOrder() {
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.addValue(3);

    assertThat(calc.getVal1(), is(2));
    assertThat(calc.getVal2(), is(3));
  }

  @Test
  public void calculateSumOfTwoNumbers() {
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.performAddition();

    assertThat(calc.text(), is("3"));
  }

  @Test
  public void calculateDifferenceOfTwoNumbers() {
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.performSubtraction();

    assertThat(calc.text(), is("-1"));
  }

  @Test
  public void resetEverything(){
    ReversePolishCalculator calc = new ReversePolishCalculator();
    calc.addValue(1);
    calc.addValue(2);
    calc.performSubtraction();
    calc.reset();

    assertThat(calc.text(), is(""));
    assertThat(calc.getVal1(), is(0));
    assertThat(calc.getVal2(), is(0));
  }
}
