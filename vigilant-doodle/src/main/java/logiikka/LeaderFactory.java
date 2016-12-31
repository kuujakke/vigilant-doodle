package logiikka;

/**
 * Created by kuujakke on 31.12.2016.
 */
public class LeaderFactory implements RoleFactory {
    @Override
    public Role createRole(String roleType, User user) throws Exception {
        return new Leader(user.getName(), user);
    }
}
