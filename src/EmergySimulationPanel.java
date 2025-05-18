import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmergySimulationPanel extends JPanel {
    private JTextField inputEnergyField;
    private JTextField inputResourceField;
    private JTextArea resultArea;

    public EmergySimulationPanel() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        inputPanel.add(new JLabel("Energia de entrada (Joules):"));
        inputEnergyField = new JTextField();
        inputPanel.add(inputEnergyField);

        inputPanel.add(new JLabel("Recursos utilizados (unidade arbitrária):"));
        inputResourceField = new JTextField();
        inputPanel.add(inputResourceField);

        JButton calculateButton = new JButton("Calcular Emergía");
        inputPanel.add(calculateButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Serif", Font.PLAIN, 16));
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularEmergia();
            }
        });
    }

    private void calcularEmergia() {
        try {
            double energia = Double.parseDouble(inputEnergyField.getText());
            double recurso = Double.parseDouble(inputResourceField.getText());

            // Simulação simples: emergia = energia * recurso * fator (exemplo)
            double fator = 1.5; // fator arbitrário para simulação
            double emergia = energia * recurso * fator;

            resultArea.setText("Resultado da simulação de emergía:\n");
            resultArea.append(String.format("Energia de entrada: %.2f J\n", energia));
            resultArea.append(String.format("Recursos utilizados: %.2f\n", recurso));
            resultArea.append(String.format("Emergía calculada: %.2f\n", emergia));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
