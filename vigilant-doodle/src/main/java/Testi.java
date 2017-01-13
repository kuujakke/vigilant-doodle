import config.Configuration;
import graphic.Login;
import logic.DefaultFactory;
import logic.database.Database;
import logic.login.User;
import logic.roles.projectroles.Member;
import logic.schemes.project.Project;
import org.mongodb.morphia.Datastore;

/**
 * Created by kuujakke on 11.1.2017.
 */
public class Testi {

    private static Login login;
    private static DefaultFactory defaultFactory;
    private static Configuration configuration;
    private static Datastore datastore;

    public static void main(String[] args) throws Exception {
        configuration = new Configuration("test.properties");
        login = new Login(configuration.getProperties());
        datastore = login.getDatabase();
        defaultFactory = new DefaultFactory(new Configuration());
        saveMember();
    }

    private static void saveMember() {
        User user = defaultFactory.createUser();
        user.setRealName("Testikäyttäjä2");
        Project project = defaultFactory.createProject();
        project.setDescription("Uusi hieno projekti");
        Member member = defaultFactory.createMember(user, project);
        member.setDescription("Testi");
        if (datastore != null) {
            System.out.println("Tallennetaan projecti: " + "\n" + project.toString());
            datastore.save(project);
            System.out.println("Saving member: " + "\n" + member.toString());
            datastore.save(member);
            System.out.println("Saving user: " + "\n" + user.toString());
            datastore.save(user);
        }
    }
}
