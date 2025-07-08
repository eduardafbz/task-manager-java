import java.util.ArrayList;
import java.util.List;

public class Functions {
    
    List<String> array = new ArrayList<>();

    public void add(String task) {
        array.add(task);
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
            System.out.printf("Task no índice %d atualizada com sucesso!\n", index);
        } else {
            System.out.println("Índice inválido!");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < array.size()) {
            array.remove(index);
            System.out.printf("Task de índice %d removida com sucesso!\n", index);
        } else {
            System.out.println("Índice inválido!");
        }
    }

}
