package logiikka;

import java.util.*;

/**
 * 
 */
public class Job extends Scheme {

    private Role worker;

    public Job(String name) {
        super(name);
    }

    public Role getWorker() {
        return this.worker;
    }

    public void setWorker(Role worker) {
        this.worker = worker;
    }
}