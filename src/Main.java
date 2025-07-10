import controller.TaskController;
import exceptions.InvalidIndexException;

public class Main {
    public static void main(String[] args) throws InvalidIndexException {

       TaskController taskController = new TaskController();
       taskController.task_menu();
    
    }
}