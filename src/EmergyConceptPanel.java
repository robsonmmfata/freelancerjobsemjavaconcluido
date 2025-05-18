import javax.swing.*;
import java.awt.*;

public class EmergyConceptPanel extends JPanel {
    public EmergyConceptPanel() {
        setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Serif", Font.PLAIN, 16));
        textArea.setText(
                "Conceito de Emergía:\n\n" +
                "Emergia é uma medida da energia utilizada direta e indiretamente para produzir um bem ou serviço. " +
                "Ela considera toda a energia incorporada em um processo, incluindo energia solar, química, térmica, " +
                "entre outras, expressa em uma única unidade comum para facilitar comparações.\n\n" +
                "Este conceito é útil para avaliar a sustentabilidade e eficiência dos sistemas naturais e humanos."
        );

        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
}
