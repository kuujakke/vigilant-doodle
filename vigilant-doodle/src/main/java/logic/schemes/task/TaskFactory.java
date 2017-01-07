package logic.schemes.task;

import config.Configuration;

/**
 * A factory for creating tasks.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class TaskFactory {

    Configuration configuration;

    public TaskFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a new task with a name and returns it.
     *
     * @param taskName String representation of the task name
     *
     * @return Task object with the given name set.
     */
    public Task createTask(String taskName) {
        return new Task(taskName);
    }

    /**
     * Creates a new task with tasks name and description set to
     * the values passed in as parameters.
     *
     * @param taskName String containing the task name
     * @param taskDescription String containing the task description
     *
     * @return Task with name and description set to the given values.
     */
    public Task createTask(String taskName, String taskDescription) {
        Task task = new Task(taskName);
        task.setDescription(taskDescription);
        return task;
    }

    /**
     * Creates a task with default task name and description got
     * from the configuration class that was initialized in the constructor.
     *
     * @return Task with default name and description
     */
    public Task createTask() {
        return createTask(
                this.configuration.getTaskName(),
                this.configuration.getTaskDescription());
    }
}
