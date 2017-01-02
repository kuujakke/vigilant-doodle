package logiikka;

public class Leader extends Member {

    private Project project;

    public Leader(User user) {
        super(user);
    }

    public void setProject(Project project) {
        this.project = project;
    }

}