package ic.doc;

public class Calculator {

  private int val1 = 0;
  private int val2 = 0;
  private String displayTxt = "";

  public Calculator() {}

  public void addValue(int v) {
    String vs = Integer.toString(v);
    if (val1 == 0) {
      val1 = v;
      displayTxt += vs;
      displayTxt += " ";
    } else {
      if (val2 == 0) {
        val2 = v;
        displayTxt += vs;
        displayTxt += " ";
      } else {
        val1 = val2;
        val2 = v;
        displayTxt = String.format("%d %d ", val1, val2);
      }
    }
  }

  public void performAddition() {
    int sum = val1+val2;
    displayTxt = Integer.toString(sum);
  }

  public void performSubtraction() {
    int diff = val1-val2;
    displayTxt = Integer.toString(diff);
  }

  public void reset() {
    val1 = 0;
    val2 = 0;
    displayTxt = "";
  }

  public String text() {
    return displayTxt;
  }
  public int getVal1() {return val1;}
  public int getVal2() { return val2;}
}
