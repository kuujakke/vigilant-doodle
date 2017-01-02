package logiikka;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class TestFactory {

    private final ProjectFactory projectFactory;
    private final TaskFactory taskFactory;

    public TestFactory() {
        this.projectFactory = new ProjectFactory();
        this.taskFactory = new TaskFactory();
        this.
    }

    public Project createTestProject() {
        return this.projectFactory.createProject("Test-Project");
    }

    public Task createTestTask() {
        return this.taskFactory.createTask("Test-Task");
    }
}
