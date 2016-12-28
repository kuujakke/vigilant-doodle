package logiikka;

import java.time.LocalDateTime;

/**
 * Created by kuujakke on 26.12.2016.
 */
public interface Status {
    void setName(String name);
    String getName();
    void setDescription(String description);
    String getDescription();
    String toString();

    LocalDateTime getStartTime();

    LocalDateTime getEndTime();

    LocalDateTime getDeadline();
    void setDeadline(LocalDateTime datetime);
    Boolean isDone();
    Boolean setDone();
    void setExpectedDone(LocalDateTime datetime);
    LocalDateTime getExpectedDone();
}
