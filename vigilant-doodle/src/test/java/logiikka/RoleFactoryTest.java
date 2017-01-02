package logiikka;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kuujakke on 30.12.2016.
 */
public class RoleFactoryTest {

    private RoleFactory roleFactory;
    private User user;

    @Before
    public void setUp() throws Exception {
        this.roleFactory = new RoleFactory();
        this.user = new User("TestUser", "password");
    }

    @Test
    public void manufactureMember() throws Exception {
        Member member = this.roleFactory.createMember(this.user);
    }

}