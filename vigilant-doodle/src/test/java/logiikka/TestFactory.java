package logiikka;

/**
 * Created by kuujakke on 2.1.2017.
 */
public class TestFactory {

    private final ProjectFactory projectFactory = new ProjectFactory();
    private final TaskFactory taskFactory = new TaskFactory();

    public TestFactory() {
    }

    public Project createTestProject() {
        return this.projectFactory.createProject("Test-Project");
    }

    public Task createTestTask() {
        return this.taskFactory.createTask("Test-Task");
    }
}
