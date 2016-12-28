package logiikka;

import java.time.LocalDateTime;

/**
 * 
 */
public class JobStatus implements Status {

    private String name;
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;

    public JobStatus(String name) {
        this.name = name;
        this.startTime = LocalDateTime.now();
    }

    @Override
    public String toString() {

        return  "{ name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", deadline=" + deadline +
                ", expectedDone=" + expectedDone +
                '}';
    }

    @Override
    public String getName() {
        return this.name;
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
    public void setDescription(String description) {
        this.description = description;
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
        return this.endTime != null;
    }

    @Override
    public Boolean setDone() {
        if (isDone()) {
            this.endTime = LocalDateTime.now();
            return true;
        }
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