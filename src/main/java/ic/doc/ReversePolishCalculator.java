package ic.doc;

import java.util.Stack;

public class ReversePolishCalculator {

  private String displayTxt = "";
  private Stack<Integer> stack;
  private Updatable observer;

  public ReversePolishCalculator(Updatable observer) {
    stack = new Stack<Integer>();
    addObserver(observer);
  }

  public void addValue(int v) {
    stack.push(v);
    stackToText();
    observer.update(this);
  }

  public void performAddition() {
    if (stack.size() <2) return;
    stack.push(stack.pop() + stack.pop());
    stackToText();
    observer.update(this);
  }

  public void performSubtraction() {
    if (stack.size() <2) return;
    int subtrahend = stack.pop();
    int minuend = stack.pop();
    stack.push((minuend - subtrahend));
    stackToText();
    observer.update(this);
  }

  private void stackToText() {
    displayTxt = "";
    for (int val : stack) {
      displayTxt += Integer.toString(val);
      displayTxt += " ";
    }
  }

  public void reset() {
    stack.clear();
    displayTxt = "";
  }

  public void addObserver(Updatable observer) {
    this.observer = observer;
  }

  public String text() {
    return displayTxt;
  }

  public Stack<Integer> stack() {return stack;}
}
