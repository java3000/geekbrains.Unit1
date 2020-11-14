import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Calculator extends JFrame implements ActionListener {

    private JTextArea textField;
    private String firstOperand;
    private String secondOperand;
    private String operation;
    private final String[] operations;
    private boolean isFirstOperatorDone;
    private boolean isCalculationDone;

    Calculator() {
        super("Куркулятер");

        operations = new String[]{"+", "-", "*", "/", "^"};
        firstOperand = "0";
        secondOperand = "0";
        operation = "";

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel contents = new JPanel();
        contents.setLayout(new BoxLayout(contents, BoxLayout.Y_AXIS));

        textField = new JTextArea();
        textField.setFont(new Font("Verdana", Font.BOLD, 15));
        textField.setEditable(false);
        textField.setBackground(Color.WHITE);
        contents.add(textField);

        JPanel keyboard = new JPanel();
        createButtons(keyboard);
        contents.add(keyboard);

        setContentPane(contents);

        pack();
        centerWindow(this);
        setSize(200, 300);
        setVisible(true);
    }

    public static void centerWindow(Window w) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((d.getWidth() - w.getWidth()) / 2);
        int y = (int) ((d.getHeight() - w.getHeight()) / 2);
        w.setLocation(x, y);
    }

    public void createButtons(JPanel buttons) {
        buttons.setSize(200, 300);
        buttons.setLayout(new GridBagLayout());
        buttons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        GridBagConstraints constraints = new GridBagConstraints();

        int x = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String title = String.valueOf(x++);
                JButton b = new JButton(title);
                b.setActionCommand(title);
                b.addActionListener(this);

                constraints.fill = GridBagConstraints.HORIZONTAL;
                constraints.gridx = j;
                constraints.gridy = i;
                constraints.ipady = 10;
                buttons.add(b, constraints);
            }
        }

        JButton b0 = new JButton(String.valueOf(0));
        b0.setActionCommand(String.valueOf(0));
        b0.addActionListener(this);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.ipady = 10;
        constraints.gridwidth = 3;
        buttons.add(b0, constraints);

        for (int i = 0; i < operations.length; i++) {
            JButton b1 = new JButton(operations[i]);
            b1.setActionCommand(operations[i]);
            b1.addActionListener(this);

            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.gridx = 4;
            constraints.gridy = i;
            constraints.ipady = 10;
            buttons.add(b1, constraints);
        }

        JButton b2 = new JButton("=");
        b2.setActionCommand("=");
        b2.addActionListener(this);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.ipady = 10;
        constraints.gridwidth = 3;
        buttons.add(b2, constraints);
    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String command = button.getActionCommand();

        if (isCalculationDone) {
            textField.setText("");
            firstOperand = "0";
            secondOperand = "0";
            operation = "";
            isFirstOperatorDone = false;
            isCalculationDone = false;
        }

        if (!isFirstOperatorDone) {
            if (!List.of("+", "-", "*", "/", "^", "=").contains(command)) {
                firstOperand += command;
                textField.append(command);
            }
        }

        if (isFirstOperatorDone) {
            if (!List.of("+", "-", "*", "/", "^", "=").contains(command)) {
                secondOperand += command;
                textField.append(command);
            }
        }

        if (List.of("+", "-", "*", "/", "^").contains(command)) {
            operation = command;
            isFirstOperatorDone = true;
            textField.append(" " + command + " ");
        }

        if (command.equals("=")) {
            switch (operation) {
                case "+":
                    textField.append(" = " + (Integer.parseInt(firstOperand) + Integer.parseInt(secondOperand)));
                    isCalculationDone = true;
                    break;
                case "-":
                    textField.append(" = " + (Integer.parseInt(firstOperand) - Integer.parseInt(secondOperand)));
                    isCalculationDone = true;
                    break;
                case "*":
                    textField.append(" = " + Integer.parseInt(firstOperand) * Integer.parseInt(secondOperand));
                    isCalculationDone = true;
                    break;
                case "/":
                    try {
                        textField.append(" = " + Integer.parseInt(firstOperand) / Integer.parseInt(secondOperand));
                    } catch (NumberFormatException | ArithmeticException ex) {
                        textField.append(" = NaN");
                    }
                    isCalculationDone = true;
                    break;
                case "^":
                    textField.append(" = " + (int) (Math.pow(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand))));
                    isCalculationDone = true;
                    break;
                default:
                    break;
            }
        }
    }
}