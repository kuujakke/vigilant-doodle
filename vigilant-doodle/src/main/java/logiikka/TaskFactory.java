package logiikka;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class TaskFactory {

    public Worker createWorker(User user, Task task) {
        return new Worker(user, task);
    }

    public Supervisor createSupervisor(User user, Task task) {
        return new Supervisor(user, task);
    }

    public Task createTask(String taskName) {
        return new Task(taskName);
    }
}
