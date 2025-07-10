package controller;

import java.util.Scanner;

import exceptions.InvalidIndexException;
import model.Task;
import service.TaskService;

public class TaskController {

    Scanner sc = new Scanner(System.in);
    TaskService taskService = new TaskService();
    boolean continuar = true;

    public void task_menu() throws InvalidIndexException {
        while (continuar) {
            int opcao;
            try {
                System.out.println("Digite uma opção: \n1. Adicionar uma task \n2. Listar tasks \n3. Atualizar task \n4. Deletar uma task \n5. Sair");
                String input = sc.nextLine();
                opcao = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Digite um número de 1 a 5.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Nova task: ");
                    taskService.add(new Task(sc.nextLine()));
                    break;
                case 2:
                    System.out.println("Listar tasks: ");
                    taskService.read();
                    System.out.println();
                    break;
                case 3:
                    try {
                        System.out.println("Atualizando uma task: \nDigite o índice da task a ser atualizada: ");
                        int index = Integer.parseInt(sc.nextLine());
                        System.out.println("Digite a descrição da nova tarefa: ");
                        Task tskk = new Task(sc.nextLine());
                        taskService.update(index, tskk);
                    } catch (InvalidIndexException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Digite o índice da task a ser deletada: ");
                    int index2 = sc.nextInt();
                    taskService.delete(index2);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}