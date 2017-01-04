package logic.schemes.task;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class TaskFactory {

    public Task createTask(String taskName) {
        return new Task(taskName);
    }
}
