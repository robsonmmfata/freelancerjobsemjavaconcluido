import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    private JTextField display;
    private double result;
    private String lastOperator;
    private boolean start;

    public CalculatorPanel() {
        setLayout(new BorderLayout());
        result = 0;
        lastOperator = "=";
        start = true;

        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.addActionListener(new ButtonListener());
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789.".contains(command)) {
                if (start) {
                    display.setText("");
                    start = false;
                }
                if (command.equals(".") && display.getText().contains(".")) {
                    return;
                }
                display.setText(display.getText() + command);
            } else {
                if (start) {
                    if (command.equals("-")) {
                        display.setText(command);
                        start = false;
                    } else {
                        lastOperator = command;
                    }
                } else {
                    calculate(Double.parseDouble(display.getText()));
                    lastOperator = command;
                    start = true;
                }
            }
        }
    }

    private void calculate(double x) {
        switch (lastOperator) {
            case "+":
                result += x;
                break;
            case "-":
                result -= x;
                break;
            case "*":
                result *= x;
                break;
            case "/":
                if (x == 0) {
                    JOptionPane.showMessageDialog(this, "Divisão por zero não é permitida", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result /= x;
                break;
            case "=":
                result = x;
                break;
        }
        display.setText("" + result);
    }
}
