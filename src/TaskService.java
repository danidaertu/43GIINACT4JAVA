import java.util.*;

public class TaskService {
    private Map<Integer, Task> tasks = new HashMap<>();
    private int idCounter = 1;

    public Task createTask(String title, String description) {
        Task task = new Task(idCounter++, title, description);
        tasks.put(task.getId(), task);
        return task;
    }

    public Task getTask(int id) {
        return tasks.get(id);
    }

    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }
}
