package logiikka;

/**
 * 
 */
public class Leader extends Member {

    /**
     * Default constructor
     */
    public Leader(String name, Project project, User user) {
        super(name, project, user);
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
        removeMember(member);
        Leader leader = new Leader(member.getRoleName(), project, member.getUser());
    }

    /**
     * @param member 
     * @param task
     */
    public void assignTaskMaster(Member member, Task task) {
        // TODO implement here
    }

}