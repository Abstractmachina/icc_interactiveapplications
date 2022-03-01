package ic.doc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class CalculatorGUI implements Updatable {

  private final ReversePolishCalculator calculator = new ReversePolishCalculator();

  private final JFrame frame;
  private final JPanel panel;

  private final JTextField textField;

  private final JButton bOne;
  private final JButton bTwo;
  private final JButton bThree;
  private final JButton bFour;
  private final JButton bPlus;
  private final JButton bMinus;
  private final JButton bClear;



  public CalculatorGUI() {

    frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(400, 300);

    panel = new JPanel();

    textField = new JTextField(10);

    bOne = new JButton("1");
    bTwo = new JButton("2");
    bThree = new JButton("3");
    bFour = new JButton("4");
    bPlus = new JButton("+");
    bMinus = new JButton("-");
    bClear = new JButton("clear");

    bOne.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(1);
            textField.setText(calculator.text());
          }
        });

    bTwo.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(2);
            textField.setText(calculator.text());
          }
        });

    bThree.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(3);
            textField.setText(calculator.text());
          }
        });

    bFour.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.addValue(4);
            textField.setText(calculator.text());
          }
        });

    bPlus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.performAddition();
            textField.setText(calculator.text());
          }
        });
    bMinus.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            calculator.performSubtraction();
            textField.setText(calculator.text());
          }
        });

    bClear.addActionListener(
        new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            clear();
          }
        });

    panel.add(bOne);
    panel.add(bTwo);
    panel.add(bThree);
    panel.add(bFour);
    panel.add(bPlus);
    panel.add(bMinus);
    panel.add(bClear);

    panel.add(textField);

    frame.add(panel);

    frame.setVisible(true);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    calculator.addObserver(this);

  }

  private void clear() {
    calculator.reset();
    textField.setText("");
  }

  @Override
  public void update(ReversePolishCalculator calculator){
    textField.setText(calculator.text());
  }

  public static void main(String[] args) {
    CalculatorGUI gui = new CalculatorGUI();
  }



}
