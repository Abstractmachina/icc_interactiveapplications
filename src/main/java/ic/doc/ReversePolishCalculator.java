package ic.doc;

import java.util.Stack;

public class ReversePolishCalculator {

  private String displayTxt = "";
  private Stack<Integer> stack;

  private Updatable observer;

  public ReversePolishCalculator() {
    stack = new Stack<Integer>();
  }

  public void addValue(int v) {
    stack.push(v);
    stackToText();
    observer.update(this);
    System.out.print(stack);
  }

  public void performAddition() {
    if (stack.size() <2) return;
    stack.push(stack.pop() + stack.pop());
    System.out.print(stack);
    stackToText();
  }

  private void stackToText() {
    displayTxt = "";
    for (int val : stack) {
      displayTxt += Integer.toString(val);
      displayTxt += " ";
    }
  }

  public void performSubtraction() {
    if (stack.size() <2) return;
    int subtrahend = stack.pop();
    int minuend = stack.pop();
    stack.push((minuend - subtrahend));
    stackToText();
    System.out.print(stack);
  }

  public void reset() {
    stack.clear();
    displayTxt = "";
  }

  public String text() {
    return displayTxt;
  }

  public void addObserver(Updatable observer) {
    this.observer = observer;
  }
}
