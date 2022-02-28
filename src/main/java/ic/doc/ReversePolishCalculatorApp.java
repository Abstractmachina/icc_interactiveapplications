package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ReversePolishCalculatorApp {

  public static void main(String[] args) {
    new ReversePolishCalculatorApp().display();
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

    JTextField textField = new JTextField(10);


    b_one.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    b_two.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    b_three.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    b_four.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });

    b_plus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

      }
    });
    b_minus.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        textField.setText("tada");
      }
    });

    panel.add(b_one);
    panel.add(b_two);
    panel.add(b_three);
    panel.add(b_four);
    panel.add(b_plus);
    panel.add(b_minus);

    panel.add(textField);

    frame.add(panel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }
}
