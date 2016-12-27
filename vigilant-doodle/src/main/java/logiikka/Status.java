package logiikka;

import java.time.LocalDateTime;

/**
 * Created by kuujakke on 26.12.2016.
 */
public interface Status {

    String toString();
    String getName();
    void setName(String name);
    String getDescription();
    void setDescription();
    Role getOwner();
    void setOwner(Role role);
    LocalDateTime getDeadline();
    void setDeadline(LocalDateTime datetime);
    Boolean isCOmpleted();
    Boolean setCompleted();

}
