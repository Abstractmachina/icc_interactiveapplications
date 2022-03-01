package ic.doc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class ReversePolishCalculatorTest {

  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  private final Updatable observer = context.mock(Updatable.class);


  private final ReversePolishCalculator calc = new ReversePolishCalculator(observer);

  @Test
  public void addingFirstValueStoresInCorrectOrder() {

    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);

    assertThat(calc.stack().size(), is(1));
    assertThat(calc.stack().peek(), is(1));
  }

  @Test
  public void addingSecondValueStoresInCorrectOrder() {
    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);
    calc.addValue(2);

    assertThat(calc.stack().size(), is(2));
    assertThat(calc.stack().peek(), is(2));
  }

  @Test
  public void addingSubsequentValuesStoreInCorrectOrder() {
    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);
    calc.addValue(2);
    calc.addValue(3);

    assertThat(calc.stack().size(), is(3));
    assertThat(calc.stack().peek(), is(3));
  }

  @Test
  public void calculateSumOfTwoNumbers() {
    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);
    calc.addValue(2);
    calc.performAddition();

    assertThat(calc.stack().peek(), is(3));
  }

  @Test
  public void calculateDifferenceOfTwoNumbers() {
    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);
    calc.addValue(2);
    calc.performSubtraction();

    assertThat(calc.stack().peek(), is(-1));
  }

  @Test
  public void resetEverything(){
    context.checking(new Expectations() {{
      allowing(observer).update(calc);
    }});

    calc.reset();
    calc.addValue(1);
    calc.addValue(2);
    calc.reset();

    assertThat(calc.text(), is(""));
    assertThat(calc.stack().size(), is(0));
  }
}
