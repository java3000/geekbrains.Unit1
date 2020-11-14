import javax.script.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Stream;

//1.Доделать кнопку "С" - очищение строки
//2.Доделать кнопку "Submit", она же равно "=". По нажатию кнопки должно выполняться вычисление выражения.
//3.Реализовать вычисление выражения только для операций сложения и вычитания
//4** Попробовать применить ScriptEngine для вычисления математических выражений
//5** На основании задания №4, расширить добавить к списку операций умножение и деление

public class MainFrame extends JFrame implements ActionListener {

    private final String[] operations;
    private String firstOperand;
    private String secondOperand;
    private String operation;
    private boolean isFirstOperatorDone;
    private boolean isCalculationDone;
    JTextField inputField;

    public MainFrame() {

        firstOperand = "";
        secondOperand = "";
        operation = "";
        operations = new String[]{"+", "-", "*", "/", "^"};

        setTitle("Calculator");
        setBounds(100, 100, 200, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        inputField = new JTextField();

        add(top, BorderLayout.NORTH);
        top.setLayout(new BorderLayout());
        top.add(inputField, BorderLayout.CENTER);
        JButton clear = new JButton("C");
        clear.addActionListener(this);
        top.add(clear, BorderLayout.EAST);

        add(bottom, BorderLayout.CENTER);
        bottom.setLayout(new GridLayout(4, 3));

        createButtons(bottom);

        setVisible(true);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        StringBuilder sb = new StringBuilder(inputField.getText());
        JButton btn = (JButton) e.getSource();
        String command = btn.getText();

        if (isCalculationDone || command.equals("C")) {
            inputField.setText("");
            sb.setLength(0);
            firstOperand = "";
            secondOperand = "";
            operation = "";
            isFirstOperatorDone = false;
            isCalculationDone = false;
        }

        if (!command.equals("=") && !command.equals("C")) {
            if (!List.of(operations).contains(command)) {
                if (!isFirstOperatorDone) {
                    firstOperand += command;
                    sb.append(command);
                } else {
                    secondOperand += command;
                    sb.append(command);
                }
            } else {
                operation = command;
                isFirstOperatorDone = true;
                sb.append(" ").append(command).append(" ");
            }
        }

        if (command.equals("=")) {
            if (operation.equals("^")) {
                sb.append(" = ").append((int) (Math.pow(Double.parseDouble(firstOperand), Double.parseDouble(secondOperand))));
                isCalculationDone = true;
            } else {
                ScriptEngine engine = new ScriptEngineManager().getEngineByName("js");
                try {
                    sb.append(" = ").append(engine.eval(firstOperand + operation + secondOperand));
                    isCalculationDone = true;
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }
        }
        inputField.setText(sb.toString());
    }
}