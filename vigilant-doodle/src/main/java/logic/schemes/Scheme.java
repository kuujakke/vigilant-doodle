package logic.schemes;

import java.time.LocalDateTime;

/**
 * Base functionality for Project, Task and Job.
 */

public abstract class Scheme {
    private String name;
    private String description;
    private Status status;

    public Scheme(String name) {
        this.name = name;
        this.status = new Status();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return this.status;
    }

    public LocalDateTime getDeadline() {
        return this.status.getDeadline();
    }

    public void setDeadline(LocalDateTime deadline) {
        this.status.setDeadline(deadline);
    }

    public LocalDateTime getExpectedDone() {
        return this.status.getExpectedDone();
    }

    public void setExpectedDone(LocalDateTime datetime) {
        this.status.setExpectedDone(datetime);
    }

    public boolean isDone() {
        return this.status.isDone();
    }

    public void setDone() {
        this.status.setDone();
    }

}
