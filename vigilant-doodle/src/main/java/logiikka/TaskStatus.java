package logiikka;
import java.time.LocalDateTime;

/**
 * 
 */
public class TaskStatus implements Status {

    private String name;
    private String description;
    private final LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime expectedDone;
    private LocalDateTime deadline;
    private Task task;

    /**
     * Default constructor
     */
    public TaskStatus(String name, Task task) {
        this.name = name;
        this.task = task;
        this.startTime = LocalDateTime.now();
        this.endTime = LocalDateTime.MAX;
        this.expectedDone = LocalDateTime.MAX;
        this.deadline = LocalDateTime.MAX;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return this.description;
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
    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    @Override
    public void setDeadline(LocalDateTime datetime) {
        this.deadline = datetime;
    }

    @Override
    public Boolean isDone() {
        if (this.endTime != LocalDateTime.MAX) {
            return true;
        }
        return false;
    }

    @Override
    public void setDone() {
        int jobsDone = 0;
        for (Job job : this.task.getJobs()) {
            if (job.isDone()) {
                jobsDone++;
            }
        }
        if (jobsDone == this.task.getJobs().size()) {
            this.endTime = LocalDateTime.now();
        }
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