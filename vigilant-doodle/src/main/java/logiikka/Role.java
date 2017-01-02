package logiikka;

public abstract class Role {

    private User user;
    private Scheme scheme;
    private String description;

    public Role(User user) {
        this.user = user;
        this.scheme = scheme;
        user.addRole(this);
    }

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
        return this.user.getRealName();
    }

    public void setRealName(String realName) {
        this.user.setRealName(realName);
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}