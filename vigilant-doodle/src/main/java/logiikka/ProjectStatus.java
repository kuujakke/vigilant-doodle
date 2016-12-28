package logiikka;
import java.time.LocalDateTime;
import java.util.*;


/**
 * 
 */
public class ProjectStatus implements Status {

    private Role owner;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;

    /**
     * Default constructor
     */
    public ProjectStatus() {
    }

    /**
     *
     */
    public String projectName;

    /**
     *
     */
    public String projectDescription;


    @Override
    public String getName() {
        return this.projectName;
    }

    @Override
    public void setName(String name) {
        this.projectName = name;
    }

    @Override
    public String getDescription() {
        return this.projectDescription;
    }

    @Override
    public void setDescription(String description) {
        this.projectDescription = description;
    }

    @Override
    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    @Override
    public void setDeadline(LocalDateTime datetime) {
        this.deadline = datetime;
    }

    @Override
    public Boolean isDone() {
        return false;
    }

    @Override
    public Boolean setDone() {
        return false;
    }

    @Override
    public void setExpectedDone(LocalDateTime datetime) {
        this.expectedDone = datetime;
    }

    @Override
    public LocalDateTime getExpectedDone() {
        return this.expectedDone;
    }
}