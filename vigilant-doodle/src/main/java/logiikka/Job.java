package logiikka;

import javafx.print.PrinterJob;

import java.util.*;

/**
 * 
 */
public class Job {

    private String jobName;

    /**
     * Default constructor
     */
    public Job(String name) {
        this.jobName = name;
    }

    /**
     * 
     */
    public PrinterJob.JobStatus jobStatus;

    /**
     * 
     */
    public Worker jobWorker;


    /**
     * @return
     */
    public String getName() {
        // TODO implement here
        return "";
    }

    /**
     * @param name
     */
    public void setName(String name) {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getDescription() {
        // TODO implement here
        return "";
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        // TODO implement here
    }

}