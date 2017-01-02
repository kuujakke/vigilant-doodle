package logiikka;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class ProjectFactory {

    private final String DEFAULT_PROJECT_NAME = "Empty name";
    private final String DEFAULT_PROJECT_DESCRIPTION = "No description.";
    private final String DEFAULT_USER_NAME = "DefaultUser";
    private final String REAL_NAME = "Jebediah Kerman";

    public Leader createLeader(User user, Project project) {
        return new Leader(user, project);
    }

    public Member createMember(User user, Project project) {
        return new Member(user, project);
    }

    public Project createProject(String projectName) {
        if (projectName.isEmpty() || projectName.length() > 0) {
            return new Project(SchemeType.DEFAULT_PROJECT_NAME);
        }
        return new Project(projectName);
    }
}
