package logiikka;

/**
 * Created by kuujakke on 30.12.2016.
 */
public interface RoleFactory {

    public Role createRole(String roleType, User user) throws Exception {
        switch (roleType.toUpperCase()) {
            case "MEMBER":

            case "LEADER":
            case "WORKER":
                return new Worker(user.getName(), user);
            case "SUPERVISOR":
                return new Supervisor(user.getName(), user);
            default:
                throw new Exception(roleType + "is not a valid roleType!");
        }
    }
}
