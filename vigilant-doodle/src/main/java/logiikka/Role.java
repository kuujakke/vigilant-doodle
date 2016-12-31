package logiikka;

import java.util.*;

public abstract class Role {

    private User user;
    private String description;

    public String toString() {
        return "Name: " + this.getName() + "\n" +
                "Description: " + this.getDescription();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return this.user.getName();
    }

    public void setName(String name) {
        this.user.setName(name);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}