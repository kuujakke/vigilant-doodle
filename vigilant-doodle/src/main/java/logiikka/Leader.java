package logiikka;

/**
 * 
 */
public class Leader extends Member {

    /**
     * Default constructor
     */
    public Leader(String name, User user) {
        super(name, user);
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
        Leader leader = new Leader(member.getName(), member.getUser());
        project.leaders.add(leader);
    }

    /**
     * @param member 
     * @param task
     */
    public void assignSupervisor(Member member, Task task) {
        Supervisor supervisor = new Supervisor(member.getName(), member.getUser());
        member.getUser().roles.add(supervisor);
        task.setSupervisor(supervisor);
    }

}