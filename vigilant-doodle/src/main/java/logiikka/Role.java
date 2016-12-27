package logiikka;

import java.util.*;

/**
 *
 */
public interface Role {

    /**
     * @return
     */
    String toString();

    /**
     * @return
     */
    User getUser();

    /**
     * @return
     */
    Role getRole();

    /**
     * @return
     */
    String getRoleName();

    /**
     * @return
     */
    String getRoleDescription();

    /**
     * @param name
     */
    void setRoleName(String name);

    /**
     * @param description
     */
    void setRoleDescription(String description);

}