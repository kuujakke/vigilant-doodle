package logiikka;

import java.util.*;

/**
 * 
 */
public class Project {

    private String projectName;
    private ProjectStatus projectStatus;
    public ArrayList<Task> tasks;
    public ArrayList<Leader> leaders;
    public ArrayList<Member> members;

    /**
     * Default constructor
     */
    public Project(String name) {
        this.projectName = name;
        this.projectStatus = new ProjectStatus();
        this.tasks = new ArrayList<>();
        this.leaders = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    /**
     * @return
     */
    public String toString() {
        return this.projectName;
    }

    /**
     * @param task
     */
    public void addTask(Task task) {
        this.tasks.add(task);
    }

    /**
     * @return
     */
    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    /**
     * @param task
     */
    public void deleteTask(Task task) {
        // TODO implement here
    }

    /**
     * @param user
     */
    public void addMember(User user) {
        // TODO implement here
    }

    /**
     * @param user
     */
    public void removeMember(User user) {
        // TODO implement here
    }

    /**
     * @param user
     */
    public void addLeader(User user) {
        // TODO implement here
    }

    /**
     * @param user
     */
    public void removeLeader(User user) {
        // TODO implement here
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }
}