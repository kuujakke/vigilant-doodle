package logiikka;
import java.time.LocalDateTime;
import java.util.*;

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
    private Project project;

    /**
     * Default constructor
     */
    public TaskStatus(String name) {
        this.name = name;
        this.startTime = LocalDateTime.now();
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
    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    @Override
    public void setDeadline(LocalDateTime datetime) {
        this.deadline = datetime;
    }

    @Override
    public Boolean isDone() {
        if (this.endTime != null) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean setDone() {
        int tasksDone = 0;
        for(Task task : this.project.getTasks()) {
            if(task.isDone()) {
                tasksDone++;
            }
        }
        if (tasksDone == this.project.getTasks().size()) {
            this.endTime = LocalDateTime.now();
            return true;
        } else {
            return false;
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