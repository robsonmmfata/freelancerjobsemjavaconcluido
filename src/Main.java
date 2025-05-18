import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public Main() {
        setTitle("Calculadora de Emergía");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem calculatorMenuItem = new JMenuItem("Calculadora");
        JMenuItem conceptMenuItem = new JMenuItem("Conceito de Emergía");
        JMenuItem simulationMenuItem = new JMenuItem("Simulação de Emergía");
        JMenuItem chartMenuItem = new JMenuItem("Fluxos de Energia");
        JMenuItem reportMenuItem = new JMenuItem("Gerar Relatório");

        menu.add(calculatorMenuItem);
        menu.add(conceptMenuItem);
        menu.add(simulationMenuItem);
        menu.add(chartMenuItem);
        menu.addSeparator();
        menu.add(reportMenuItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Painéis
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(new CalculatorPanel(), "Calculator");
        mainPanel.add(new EmergyConceptPanel(), "Concept");
        mainPanel.add(new EmergySimulationPanel(), "Simulation");
        mainPanel.add(new EnergyFlowChartPanel(), "Chart");

        add(mainPanel);

        // Ações do menu
        calculatorMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "Calculator"));
        conceptMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "Concept"));
        simulationMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "Simulation"));
        chartMenuItem.addActionListener(e -> cardLayout.show(mainPanel, "Chart"));
        reportMenuItem.addActionListener(e -> {
            ReportGenerator.generateReport();
            JOptionPane.showMessageDialog(this, "Relatório gerado com sucesso!", "Relatório", JOptionPane.INFORMATION_MESSAGE);
        });

        // Mostrar painel inicial
        cardLayout.show(mainPanel, "Calculator");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainFrame = new Main();
            mainFrame.setVisible(true);
        });
    }
}
