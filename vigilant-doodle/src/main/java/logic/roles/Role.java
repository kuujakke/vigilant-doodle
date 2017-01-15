package logic.roles;

import logic.login.User;
import logic.schemes.Scheme;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.mongodb.morphia.annotations.Reference;

/**
 * All roles have this in common.
 */
@Entity("roles")
public abstract class Role {

    @Id
    private ObjectId id;

    @Reference("users")
    private User user;

    private String description;

    /**
     * Zero-arg constructor for morphia.
     */
    public Role() {

    }

    /**
     * Default constructor initializing the user class-variable with the value passed in.
     *
     * @param user User to be associated with role.
     */
    public Role(User user) {
        this.user = user;
        this.id = new ObjectId();
        user.addRole(this);
    }

    /**
     * Returns a string that has the users real name and roles description.
     *
     * @return String containing users real name and role description.
     */
    public String toString() {
        return "Name: " + this.user.getRealName() + "\n" +
                "Description: " + this.getDescription();
    }

    /**
     * Returns the user object of the role.
     *
     * @return User associated with the role.
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Gets the role description.
     *
     * @return String containing the role description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the role description.
     *
     * @param description String containing the new description.
     */
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