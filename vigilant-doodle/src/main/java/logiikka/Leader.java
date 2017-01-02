package logiikka;

public class Leader extends Member {

    private Project project;

    public Leader(User user, Project project) {
        super(user, project);
    }

    public void setProject(Project project) {
        this.project = project;
    }

}