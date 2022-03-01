package ic.doc;

import java.util.Stack;

public class ReversePolishCalculator {

  private String displayTxt = "";
  private final Stack<Integer> stack;
  private Updatable observer;

  public ReversePolishCalculator(Updatable observer) {
    stack = new Stack<>();
    addObserver(observer);
  }

  public void addValue(int v) {
    stack.push(v);
    updateDisplayText();
  }

  public void performAddition() {
    if (stack.size() < 2) {
      return;
    }
    stack.push(stack.pop() + stack.pop());
    updateDisplayText();
  }

  public void performSubtraction() {
    if (stack.size() < 2) {
      return;
    }
    int subtrahend = stack.pop();
    int minuend = stack.pop();
    stack.push((minuend - subtrahend));
    updateDisplayText();
  }

  private void updateDisplayText() {
    stackToText();
    observer.update(this);
  }

  private void stackToText() {
    StringBuilder result = new StringBuilder();
    for (int val : stack) {
      result.append(val);
      result.append(" ");
    }
    displayTxt = result.toString();
  }

  public void reset() {
    stack.clear();
    displayTxt = "";
    observer.update(this);
  }

  public void addObserver(Updatable observer) {
    this.observer = observer;
  }

  public String text() {
    return displayTxt;
  }

  public Stack<Integer> stack() {
    return stack;
  }
}
