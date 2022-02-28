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

  private Calculator calculator = new Calculator();

  private JTextField textField;

  public static void main(String[] args) {
    new ReversePolishCalculatorApp().display();
  }



  private void clear() {
    calculator.reset();
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
            calculator.addValue(1);
            textField.setText(calculator.text());
          }
        });

    b_two.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(2);
            textField.setText(calculator.text());
          }
        });

    b_three.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(3);
            textField.setText(calculator.text());
          }
        });

    b_four.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(4);
            textField.setText(calculator.text());
          }
        });

    b_plus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.performAddition();
            textField.setText(calculator.text());
            calculator.reset();
          }
        });
    b_minus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.performSubtraction();
            textField.setText(calculator.text());
            calculator.reset();
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
