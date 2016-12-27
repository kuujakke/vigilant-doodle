package logiikka;

/**
 * 
 */
public class Leader extends Member {

    /**
     * Default constructor
     */
    public Leader(String name, Project project) {
        super(name, project);
    }


    /**
     * @param member
     */
    public void addMember(Member member) {
        this.project.addMember(member);
    }

    /**
     * @param member
     */
    public void removeMember(Member member) {
        this.project.removeMember(member);
    }

    /**
     * @param member 
     * @param project
     */
    public void promoteToLeader(Member member, Project project) {
        // TODO implement here
    }

    /**
     * @param member 
     * @param task
     */
    public void assignTaskMaster(Member member, Task task) {
        // TODO implement here
    }

}