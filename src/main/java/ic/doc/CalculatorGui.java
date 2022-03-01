package ic.doc;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class CalculatorGui implements Updatable {

  private final JFrame frame;
  private final JPanel panel;
  private final JTextField textField;

  private final List<JButton> buttons = new ArrayList<>();

  public CalculatorGui() {
    frame = new JFrame("Reverse Polish Calculator");
    frame.setSize(400, 300);
    panel = new JPanel();
    textField = new JTextField(10);
  }

  public void display() {
    frame.setVisible(true);
  }

  @Override
  public void update(ReversePolishCalculator calculator) {
    textField.setText(calculator.text());
  }

  private void addButtonController(String buttonLabel, ActionListener controller) {
    JButton button = new JButton(buttonLabel);
    button.addActionListener(controller);
    buttons.add(button);
  }

  private void init() {
    for (JButton button : buttons) {
      panel.add(button);
    }
    panel.add(textField);
    frame.add(panel);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }

  public static void main(String[] args) {
    CalculatorGui gui = new CalculatorGui();
    ReversePolishCalculator calculator = new ReversePolishCalculator(gui);

    // setup controller
    //number buttons
    for (int i = 1; i <= 4; i++) {
      int finalI = i;
      gui.addButtonController(Integer.toString(i), e -> calculator.addValue(finalI));
    }
    //calculation buttons
    gui.addButtonController("+", e -> calculator.performAddition());
    gui.addButtonController("-", e -> calculator.performSubtraction());
    gui.addButtonController("clear", e -> calculator.reset());

    gui.init();

    gui.display();
  }
}
