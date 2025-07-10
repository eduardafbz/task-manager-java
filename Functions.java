import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    
    private List<String> array = new ArrayList<>();
    private final String filePath = "tasks.txt"; //criação do file txt

    public Functions() {
        carregarDoArquivo(); //construtor para que todos os objetos carreguem direto o arquivo
    }

    public void add(String task) {
        array.add(task);
        salvarNoArquivo();
    }
    
    public void read() {
        System.out.println("Tasks adicionadas: ");
        for (int i = 0; i < array.size(); i++) {
            System.out.printf("[%d] %s\n", i, array.get(i));
        }
    } 

    public void update(int index, String task) {
        if (index >= 0 && index < array.size()) {
            array.set(index, task);
            salvarNoArquivo(); //todas as mudanças são salvas no arquivo com o método
            System.out.printf("Task no índice %d atualizada com sucesso!\n", index);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < array.size()) {
            array.remove(index);
            salvarNoArquivo();
            System.out.printf("Task de índice %d removida com sucesso!\n", index);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    private void salvarNoArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String task: array) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    private void carregarDoArquivo() {
        File file = new File(filePath);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                array.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar tarefas: " + e.getMessage());
        }
    }

}
