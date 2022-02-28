package ic;

import static org.junit.Assert.*;

import ic.doc.Calculator;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CalculatorTest {

  @Test
  public void addingFirstValueStoresInCorrectOrder() {
    Calculator calc = new Calculator();
    calc.addValue(1);

    assertThat(calc.getVal1(), is(1));
  }

}