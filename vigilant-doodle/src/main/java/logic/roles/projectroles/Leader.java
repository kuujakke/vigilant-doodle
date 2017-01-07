package logic.roles.projectroles;

import logic.login.User;
import logic.schemes.project.Project;

/**
 *  A role with a privileged access to the project.
 */
public class Leader extends Member {

    /**
     * Passes the user and project to its superclass Member.
     *
     * @param user User account associated with Leader
     * @param project Project where the leader belongs to.
     */
    public Leader(User user, Project project) {
        super(user, project);
    }

    /**
     * Sets new project to the leader.
     *
     * @param project Project to add the leader to.
     */
    public void setProject(Project project) {
        super.setProject(project);
    }

}