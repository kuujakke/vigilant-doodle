package logic.schemes;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.time.LocalDateTime;

/**
 * Keeps the status of a Project, Task or Job.
 * Has the ending and starting times. Keeps the deadline and the prediction for completion.
 * Marks a scheme completed.
 */
@Entity
public class Status {

    @Id
    private ObjectId objectId = new ObjectId();

    private String name;
    private String description;
    private LocalDateTime timeCreated;
    private LocalDateTime timeCompleted;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;

    /**
     * Initializes class variables with null and sets time created.
     */
    public Status() {
        this.timeCreated = LocalDateTime.now();
        this.timeCompleted = null;
        this.deadline = null;
        this.expectedDone = null;
    }

    /**
     * Sets name.
     *
     * @param name String containing name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets name.
     *
     * @return String containing name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets description.
     *
     * @param description String containing new description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets description.
     *
     * @return String containing description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * String representing the status.
     *
     * @return String containing general information about status.
     */
    public String toString() {
        return "Nimi: " + this.name + "\n" +
                "Kuvaus: " + this.description;
    }

    /**
     * Gets start time.
     *
     * @return LocalDateTime containing start time.
     */
    public LocalDateTime getStartTime() {
        return this.timeCreated;
    }

    /**
     * Gets time completed.
     *
     * @return LocalDateTime containing time completed.
     */
    public LocalDateTime getCompleted() {
        return this.timeCompleted;
    }

    /**
     * Sets status completed.
     */
    public void setCompleted() {
        this.timeCompleted = LocalDateTime.now();
    }

    /**
     * Returns true if completed.
     *
     * @return boolean if completed.
     */
    public boolean isCompleted() {
        if (this.timeCompleted != null) {
            if (this.timeCompleted.isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets deadline.
     *
     * @return LocalDateTime containing the deadline.
     */
    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    /**
     * Sets new deadline.
     *
     * @param deadline LocalDateTime containing new deadline.
     */
    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    /**
     * Returns true if done.
     *
     * @return boolean true if done.
     */
    public Boolean isDone() {
        if (this.timeCompleted != null) {
            if (this.timeCompleted.isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets status done.
     */
    public void setDone() {
        this.timeCompleted = LocalDateTime.now();
    }

    /**
     * Sets expected time done.
     *
     * @param datetime LocalDateTime containing new expected done time.
     */
    public void setExpectedDone(LocalDateTime datetime) {
        this.expectedDone = datetime;
    }

    /**
     * Returns expected done time.
     *
     * @return LocalDateTime expected time done.
     */
    public LocalDateTime getExpectedDone() {
        return this.expectedDone;
    }
}
