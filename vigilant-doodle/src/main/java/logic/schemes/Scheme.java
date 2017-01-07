package logic.schemes;

import java.time.LocalDateTime;

/**
 * Base functionality for Project, Task and Job.
 */
public abstract class Scheme {
    private String name;
    private String description;
    private Status status;

    /**
     * Initializes the scheme with a name.
     *
     * @param name String containing the new schemes name.
     */
    public Scheme(String name) {
        this.name = name;
        this.status = new Status();
    }

    /**
     * Gets the name for the scheme.
     *
     * @return String containing the string name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the scheme.
     *
     * @param name String containing new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the description for the scheme.
     *
     * @return String containing the scheme description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the scheme.
     *
     * @param description String containing the new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the scheme status object.
     *
     * @return Status object of the scheme.
     */
    public Status getStatus() {
        return this.status;
    }

    /**
     * Gets the scheme deadline.
     *
     * @return LocalDateTime containing the deadline.
     */
    public LocalDateTime getDeadline() {
        return this.status.getDeadline();
    }

    /**
     * Set the scheme deadline.
     *
     * @param deadline LocalDateTime object to be set as scheme deadline.
     */
    public void setDeadline(LocalDateTime deadline) {
        this.status.setDeadline(deadline);
    }

    /**
     * Gets the expected completion time of the scheme.
     *
     * @return LocalDateTime object representing expected completion time.
     */
    public LocalDateTime getExpectedDone() {
        return this.status.getExpectedDone();
    }

    /**
     * Sets the expected completion time for the scheme.
     *
     * @param datetime LocalDateTime object containing the expected completion time.
     */
    public void setExpectedDone(LocalDateTime datetime) {
        this.status.setExpectedDone(datetime);
    }

    /**
     * Returns true if scheme is done.
     *
     * @return true if done
     */
    public boolean isDone() {
        return this.status.isDone();
    }

    /**
     * Sets the scheme as done.
     */
    public void setDone() {
        this.status.setDone();
    }

    /**
     * Returns true if scheme is associated with another scheme.
     *
     * @param scheme Scheme to search for.
     *
     * @return true if scheme associated with.
     */
    public abstract boolean hasScheme(Scheme scheme);

}
