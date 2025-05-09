import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class TaskServiceTest {

    private TaskService taskService;

    @Before
    public void setUp() {
        taskService = new TaskService();
    }

    // 1. Crear una tarea correctamente
    @Test
    public void testCreateTask() {
        Task task = taskService.createTask("Título de prueba", "Descripción de prueba");
        assertNotNull(task);
        assertEquals("Título de prueba", task.getTitle());
        assertEquals("Descripción de prueba", task.getDescription());
        assertTrue(task.getId() > 0);
    }

    // 2. Obtener una tarea existente
    @Test
    public void testGetTask() {
        Task task = taskService.createTask("Buscar", "Encontrar esta tarea");
        Task result = taskService.getTask(task.getId());
        assertNotNull(result);
        assertEquals(task.getTitle(), result.getTitle());
    }

    // 3. Eliminar una tarea existente
    @Test
    public void testDeleteTask() {
        Task task = taskService.createTask("Eliminar", "Eliminar esta tarea");
        boolean deleted = taskService.deleteTask(task.getId());
        assertTrue(deleted);
        assertNull(taskService.getTask(task.getId()));
    }

    // 4. Obtener todas las tareas
    @Test
    public void testGetAllTasks() {
        taskService.createTask("Tarea 1", "Una tarea");
        taskService.createTask("Tarea 2", "Otra tarea");

        List<Task> tasks = taskService.getAllTasks();
        assertEquals(2, tasks.size());
    }

    // 5. Eliminar una tarea inexistente
    @Test
    public void testDeleteNonExistentTask() {
        boolean deleted = taskService.deleteTask(999);
        assertFalse(deleted);
    }
}
