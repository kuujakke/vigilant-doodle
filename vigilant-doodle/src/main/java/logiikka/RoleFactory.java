package logiikka;

/**
 * Created by kuujakke on 30.12.2016.
 */
public interface RoleFactory {

    Role createRole(String roleType, User user);

}
