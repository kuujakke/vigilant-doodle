package logic.roles;

import logic.login.User;
import logic.schemes.Scheme;
import logic.schemes.job.Job;
import logic.schemes.task.Task;

/**
 * All roles have this in common.
 */

public abstract class Role {

    private User user;
    private Scheme scheme;
    private String description;

    public Role(User user) {
        this.user = user;
        this.scheme = scheme;
        user.addRole(this);
    }

    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Description: " + this.getDescription();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return this.user.getRealName();
    }

    public void setRealName(String realName) {
        this.user.setRealName(realName);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Adds a scheme that the role is responsible of.
     *
     * @param scheme Scheme to be assigned to the role.
     */
    public abstract void addResponsibility(Scheme scheme);

    /**
     * Removes a scheme that the role is responsible of.
     *
     * @param scheme Scheme that is to be removed from the roles responsibilities.
     */
    public abstract void removeResponsibility(Scheme scheme);

    /**
     * Returns true is the role has responsibility in the scheme.
     *
     * @param scheme Scheme to be compared against roles responsibility.
     *
     * @return true if the role has responsibility in the scheme.
     */
    public abstract boolean hasResponsibility(Scheme scheme);
}