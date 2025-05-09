import java.util.Scanner;
import java.util.List;

public class TaskManagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskService taskService = new TaskService();

        System.out.println("=== Task Manager ===");

        while (true) {
            System.out.println("\n1. Crear tarea");
            System.out.println("2. Listar tareas");
            System.out.println("3. Eliminar tarea");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    System.out.print("Título: ");
                    String title = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String description = scanner.nextLine();
                    Task newTask = taskService.createTask(title, description);
                    System.out.println("Tarea creada: " + newTask);
                    break;

                case 2:
                    List<Task> tasks = taskService.getAllTasks();
                    if (tasks.isEmpty()) {
                        System.out.println("No hay tareas.");
                    } else {
                        for (Task t : tasks) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 3:
                    System.out.print("ID de la tarea a eliminar: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    boolean deleted = taskService.deleteTask(id);
                    if (deleted) {
                        System.out.println("Tarea eliminada.");
                    } else {
                        System.out.println("No se encontró la tarea.");
                    }
                    break;

                case 4:
                    scanner.close();
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción inválida.");
            }
        }

    }
}
