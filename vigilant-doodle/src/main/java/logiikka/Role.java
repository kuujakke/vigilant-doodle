package logiikka;
import java.util.*;

/**
 * 
 */
public interface Role {

    /**
     * Default constructor
     */
    public Role() {
    }

    /**
     * 
     */
    public User user;

    /**
     * 
     */
    public String roleName;

    /**
     * 
     */
    public String roleDescription;


    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public User getUser() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Role getRole() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getRoleName() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getRoleDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param name
     */
    public void setRoleName(String name) {
        // TODO implement here
    }

    /**
     * @param description
     */
    public void setRoleDescription(String description) {
        // TODO implement here
    }

}