package logic.schemes;

import java.time.LocalDateTime;

/**
 * Created by kuujakke on 26.12.2016.
 */
public class Status {

    private String name;
    private String description;
    private LocalDateTime timeCreated;
    private LocalDateTime timeCompleted;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;

    public Status() {
        this.timeCreated = LocalDateTime.now();
        this.timeCompleted = null;
        this.deadline = null;
        this.expectedDone = null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "Nimi: " + this.name + "\n" +
                "Kuvaus: " + this.description;
    }

    public LocalDateTime getStartTime() {
        return this.timeCreated;
    }

    public LocalDateTime getCompleted() {
        return this.timeCompleted;
    }

    public void setCompleted() {
        this.timeCompleted = LocalDateTime.now();
    }

    public boolean isCompleted() {
        if (this.timeCompleted != null) {
            if (this.timeCompleted.isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public Boolean isDone() {
        if (this.timeCompleted != null) {
            if (this.timeCompleted.isBefore(LocalDateTime.now())) {
                return true;
            }
        }
        return false;
    }

    public void setDone() {
        this.timeCompleted = LocalDateTime.now();
    }

    public void setExpectedDone(LocalDateTime datetime) {
        this.expectedDone = datetime;
    }

    public LocalDateTime getExpectedDone() {
        return this.expectedDone;
    }
}
