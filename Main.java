import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Functions tasks = new Functions();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Digite uma opção: \n1. Adicionar uma task \n2. Listar tasks \n3. Atualizar task \n4. Deletar uma task \n5. Sair");
            int opcao = sc.nextInt();
            sc.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Nova task: ");
                    tasks.add(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Listar tasks: ");
                    tasks.read();
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Atualizando uma task: \nDigite o índice da task a ser atualizada: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nova task: ");
                    String tskk = sc.nextLine();
                    tasks.update(index, tskk);
                    break;
                case 4:
                    System.out.println("Digite o índice da task a ser deletada: ");
                    int index2 = sc.nextInt();
                    tasks.delete(index2);
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