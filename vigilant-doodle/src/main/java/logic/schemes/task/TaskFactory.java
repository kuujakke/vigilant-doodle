package logic.schemes.task;

/**
 * A factory for creating tasks.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class TaskFactory {

    public Task createTask(String taskName) {
        return new Task(taskName);
    }
}
