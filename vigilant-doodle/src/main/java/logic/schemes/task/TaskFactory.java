package logic.schemes.task;

import config.Configuration;
import logic.schemes.Scheme;
import logic.schemes.SchemeFactory;

/**
 * A factory for creating tasks.
 * Has a Configuration object from where it retrieves the default settings from.
 */
public class TaskFactory implements SchemeFactory {

    Configuration configuration;

    /**
     * Initializes the configuration.
     *
     * @param configuration new configuration to be used.
     */
    public TaskFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * Creates a task with name and default description.
     *
     * @param taskName String containing name for the new task.
     *
     * @return Task containing a name and default description.
     */
    public Task createTask(String taskName) {
        return new Task(taskName);
    }


    /**
     * Creates a task with default task name and description got
     * from the configuration class that was initialized in the constructor.
     *
     * @return Task with default name and description
     */
    @Override
    public Task createScheme() {
        return createScheme(
                this.configuration.getTaskName(),
                this.configuration.getTaskDescription());
    }

    /**
     * Creates a new task with a name and default description, then returns it.
     *
     * @param name String representation of the task name
     *
     * @return Task object with the given name set.
     */
    @Override
    public Task createScheme(String name) {
        Task task = new Task(name);
        task.setDescription(this.configuration.getTaskDescription());
        return task;
    }


    /**
     * Creates a new task with tasks name and description set to
     * the values passed in as parameters.
     *
     * @param name String containing the task name
     * @param description String containing the task description
     *
     * @return Task with name and description set to the given values.
     */
    @Override
    public Task createScheme(String name, String description) {
        Task task = new Task(name);
        task.setDescription(description);
        return task;
    }
}
