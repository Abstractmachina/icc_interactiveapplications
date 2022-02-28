package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SingleSelectionModel;
import javax.swing.WindowConstants;

public class ReversePolishCalculatorApp {

  private int val1 = 0;
  private int val2 = 0;
  private String displayTxt = "";

  private JTextField textField;

  public static void main(String[] args) {
    new ReversePolishCalculatorApp().display();
  }

  private void addValue(int v) {
    String vs = Integer.toString(v);
    if (val1 == 0) {
      val1 = v;
      displayTxt += vs;
      displayTxt += " ";
    }
    else {
      if (val2 == 0) {
        val2 = v;
        displayTxt += vs;
        displayTxt += " ";
      }
      else {
        val1 = val2;
        val2 = v;
        displayTxt = String.format("%d %d ", val1, val2);
      }
    }
  }

  private void addToDisplay(int value) {
    displayTxt += Integer.toString(value);
    displayTxt += " ";
  }

  private void reset() {
    val1 = 0;
    val2 = 0;
    displayTxt = "";
  }

  private void clear() {
    reset();
    textField.setText("");
  }

  private void display() {

    JFrame frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(400, 300);

    JPanel panel = new JPanel();

    JButton b_one = new JButton("1");
    JButton b_two = new JButton("2");
    JButton b_three = new JButton("3");
    JButton b_four = new JButton("4");
    JButton b_plus = new JButton("+");
    JButton b_minus = new JButton("-");
    JButton b_clear = new JButton("clear");


    textField = new JTextField(10);

    b_one.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addValue(1);
            textField.setText(displayTxt);
          }
        });

    b_two.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addValue(2);
            textField.setText(displayTxt);
          }
        });

    b_three.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addValue(3);
            textField.setText(displayTxt);
          }
        });

    b_four.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            addValue(4);
            textField.setText(displayTxt);
          }
        });

    b_plus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            int sum = val1+val2;
            displayTxt = Integer.toString(sum);
            textField.setText(displayTxt);
            reset();
          }
        });
    b_minus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            int diff = val1-val2;
            displayTxt = Integer.toString(diff);
            textField.setText(displayTxt);
            reset();
          }
        });

    b_clear.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            clear();
          }
        });

    panel.add(b_one);
    panel.add(b_two);
    panel.add(b_three);
    panel.add(b_four);
    panel.add(b_plus);
    panel.add(b_minus);
    panel.add(b_clear);

    panel.add(textField);

    frame.add(panel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
