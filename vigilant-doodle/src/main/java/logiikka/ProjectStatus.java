package logiikka;
import java.time.LocalDateTime;


/**
 * 
 */
public class ProjectStatus implements Status {

    private Role owner;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;
    private LocalDateTime endTime;
    private LocalDateTime startTime;

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
    public LocalDateTime getStartTime() {
        return this.startTime;
    }

    @Override
    public LocalDateTime getEndTime() {
        return this.endTime;
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
    public void setDone() {
        this.endTime = LocalDateTime.now();
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