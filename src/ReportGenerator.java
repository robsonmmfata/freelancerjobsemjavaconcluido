import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {

    public static void generateReport() {
        String filename = "relatorio_emergia.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Relatório de Simulação de Emergía\n");
            writer.write("===============================\n");
            writer.write("Este relatório contém os resultados das simulações feitas na aplicação.\n\n");
            writer.write("Exemplo de resultado:\n");
            writer.write("Energia de entrada: 1000 J\n");
            writer.write("Recursos utilizados: 5\n");
            writer.write("Emergía calculada: 7500\n");
            writer.write("\nObrigado por usar a calculadora de emergía.\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
