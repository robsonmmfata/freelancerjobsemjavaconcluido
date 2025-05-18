import javax.swing.*;
import java.awt.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class EnergyFlowChartPanel extends JPanel {

    public EnergyFlowChartPanel() {
        setLayout(new BorderLayout());

        // Criar dataset de exemplo
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Energia Solar", 40);
        dataset.setValue("Energia Química", 30);
        dataset.setValue("Energia Térmica", 20);
        dataset.setValue("Outros", 10);

        // Criar gráfico de pizza
        JFreeChart chart = ChartFactory.createPieChart(
                "Fluxos de Energia",
                dataset,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel, BorderLayout.CENTER);
    }
}

/*
Instruções para adicionar JFreeChart:

1. Baixe a biblioteca JFreeChart em: https://sourceforge.net/projects/jfreechart/files/latest/download
2. Adicione o arquivo jar ao classpath do seu projeto.
3. Se estiver usando IDE como Eclipse ou IntelliJ, adicione o jar nas bibliotecas do projeto.
4. Para compilar e executar via linha de comando, inclua o jar no classpath.

Exemplo de compilação:
javac -cp ".;jfreechart-x.y.z.jar;jcommon-x.y.z.jar" src/*.java

Exemplo de execução:
java -cp ".;jfreechart-x.y.z.jar;jcommon-x.y.z.jar" Main
*/
