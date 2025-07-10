package service;

import java.util.List;

import exceptions.InvalidIndexException;
import model.Task;
import repository.TaskRepository;

public class TaskService {
    
    TaskRepository taskRepository = new TaskRepository();
    private List<Task> array;

    public TaskService(){
       array = taskRepository.carregarDoArquivo(); 
       if (array == null) {
            array = new java.util.ArrayList<>();
       }
    }

    public void add(Task task) {
        array.add(task);
        taskRepository.salvarNoArquivo(array);
    }
    
    public void read() {
        for (int i = 0; i < array.size(); i++) {
            System.out.printf("[%d] %s\n", i, array.get(i));
        }
    } 

    public void update(int index, Task task) throws InvalidIndexException {
        if (index >= 0 && index < array.size()) {
            array.set(index, task);
            taskRepository.salvarNoArquivo(array); 
        } else {
            throw new InvalidIndexException("Índice inválido. Tarefa não foi atualizada!");
        }
    }

    public void delete(int index) throws InvalidIndexException {
        if (index >= 0 && index < array.size()) {
        array.remove(index);
        taskRepository.salvarNoArquivo(array);
        } else {
            throw new InvalidIndexException("Índice inválido. Tarefa não foi deletada!");
        }
        
    }

}