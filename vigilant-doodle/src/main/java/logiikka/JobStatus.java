package logiikka;

import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class JobStatus implements Status {

    private String jobName;
    private String jobDescription;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime deadline;
    private LocalDateTime expectedDone;

    public JobStatus(String name) {
        this.jobName = name;
        this.startTime = LocalDateTime.now();
    }

    @Override
    public String getDescription() {
        return this.jobDescription;
    }

    @Override
    public void setName(String name) {
        this.jobName = name;
    }

    @Override
    public String getName() {
        return this.jobName;
    }

    @Override
    public void setDescription(String description) {

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
    public Boolean isCompleted() {
        return this.endTime != null;
    }

    @Override
    public Boolean setCompleted() {
        this.endTime = LocalDateTime.now();
        return true;
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