package logiikka;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 
 */
public class ProjectStatus implements Status {

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
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void setDescription() {

    }

    @Override
    public Role getOwner() {
        return null;
    }

    @Override
    public void setOwner(Role role) {

    }

    @Override
    public LocalDateTime getDeadline() {
        return null;
    }

    @Override
    public void setDeadline(LocalDateTime datetime) {

    }

    @Override
    public Boolean isCOmpleted() {
        return null;
    }

    @Override
    public Boolean setCompleted() {
        return null;
    }
}