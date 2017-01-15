package logic.roles;

import logic.DefaultFactory;
import logic.login.User;
import logic.roles.projectroles.Member;
import logic.schemes.project.Project;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kuujakke on 4.1.2017.
 */
public class RoleTest {

    private DefaultFactory defaultFactory;
    private User user;
    private Project project;
    private Member member;

    @Before
    public void setUp() throws Exception {
        this.defaultFactory = new DefaultFactory();
        this.user = this.defaultFactory.createUser();
        this.project = this.defaultFactory.createProject();
        this.member = this.defaultFactory.createMember(this.user, this.project);
    }

    @Test
    public void getUser() throws Exception {
        assertThat(this.member.getUser()).isSameAs(this.user);
        assertThat(this.member.getUser().hasRole(this.member)).isTrue();
    }

    @Test
    public void setUser() throws Exception {
        Member anotherMember = this.defaultFactory.createMember(this.defaultFactory.createUser(), this.project);
        assertThat(anotherMember.getUser()).isNotSameAs(this.user);
        assertThat(anotherMember).isNotSameAs(this.member);

    }

    @Test
    public void setDescription() throws Exception {
        String orig = this.member.getDescription();
        this.member.setDescription("Test");
        assertThat(this.member.getDescription()).isNotEqualTo(orig);
        assertThat(this.member.getDescription()).isEqualTo("Test");
    }

    @Test
    public void toStringIsNotNull() {
        assertThat(this.member.toString()).isNotEmpty();
    }

}